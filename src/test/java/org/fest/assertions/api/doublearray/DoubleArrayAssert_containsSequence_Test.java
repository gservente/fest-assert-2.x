/*
 * Created on Dec 20, 2010
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 * 
 * Copyright @2010-2011 the original author or authors.
 */
package org.fest.assertions.api.doublearray;

import static org.fest.util.DoubleArrayFactory.array;
import static org.mockito.Mockito.verify;

import org.fest.assertions.api.DoubleArrayAssert;
import org.fest.assertions.api.DoubleArrayAssertBaseTest;

/**
 * Tests for <code>{@link DoubleArrayAssert#containsSequence(double...)}</code>.
 * 
 * @author Alex Ruiz
 */
public class DoubleArrayAssert_containsSequence_Test extends DoubleArrayAssertBaseTest {

  @Override
  protected DoubleArrayAssert invoke_api_method() {
    return assertions.containsSequence(6d, 8d);
  }

  @Override
  protected void verify_internal_effects() {
    verify(arrays).assertContainsSequence(getInfo(assertions), getActual(assertions), array(6d, 8d));
  }
}
