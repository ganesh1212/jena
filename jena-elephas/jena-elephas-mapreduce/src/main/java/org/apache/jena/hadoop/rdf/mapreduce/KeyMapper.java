/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.jena.hadoop.rdf.mapreduce;

import java.io.IOException;

import org.apache.hadoop.mapreduce.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A mapper which discards the value replacing it with the key
 * 
 *
 * @param <TKey> Key type
 * @param <TValue> Value type
 */
public class KeyMapper<TKey, TValue> extends Mapper<TKey, TValue, TKey, TKey> {
    private static final Logger LOG = LoggerFactory.getLogger(KeyMapper.class);

    private boolean tracing = false;
    
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        super.setup(context);
        this.tracing = LOG.isTraceEnabled();
    }

    @Override
    protected void map(TKey key, TValue value, Context context) throws IOException,
            InterruptedException {
        if (this.tracing) {
            LOG.trace("Key = {}", key);
        }
        context.write(key, key);
    }

}
