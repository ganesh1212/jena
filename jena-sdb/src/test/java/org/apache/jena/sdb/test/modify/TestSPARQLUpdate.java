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

package org.apache.jena.sdb.test.modify;

import junit.framework.JUnit4TestAdapter ;
import junit.framework.TestSuite ;
import org.apache.jena.sdb.SDBFactory ;
import org.apache.jena.sdb.Store ;
import org.apache.jena.sdb.test.junit.SDBTestUtils ;
import org.apache.jena.sparql.modify.AbstractTestUpdateGraph ;
import org.apache.jena.update.GraphStore ;

public class TestSPARQLUpdate extends AbstractTestUpdateGraph
{
    public static junit.framework.TestSuite suite() {
        TestSuite ts = new TestSuite();
        ts.addTest(new JUnit4TestAdapter(TestSPARQLUpdate.class));
        return ts;
    }
    
    @Override
    protected GraphStore getEmptyGraphStore()
    {
        Store store = SDBTestUtils.createInMemoryStore() ;
        GraphStore graphStore = SDBFactory.connectGraphStore(store) ;
        return graphStore ;
    }
}
