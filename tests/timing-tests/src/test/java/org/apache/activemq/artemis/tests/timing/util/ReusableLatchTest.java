/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.artemis.tests.timing.util;

import org.apache.activemq.artemis.tests.util.ServiceTestBase;
import org.junit.Test;

import org.junit.Assert;

import org.apache.activemq.artemis.utils.ReusableLatch;

public class ReusableLatchTest extends ServiceTestBase
{
   @Test
   public void testTimeout() throws Exception
   {
      ReusableLatch latch = new ReusableLatch();

      latch.countUp();

      long start = System.currentTimeMillis();
      Assert.assertFalse(latch.await(1000));
      long end = System.currentTimeMillis();

      Assert.assertTrue("Timeout didn't work correctly", end - start >= 1000 && end - start < 2000);
   }
}
