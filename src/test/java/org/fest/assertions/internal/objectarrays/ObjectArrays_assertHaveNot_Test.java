/*
 * Created on Mar 5, 2012
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
 * Copyright @2012 the original author or authors.
 */
package org.fest.assertions.internal.objectarrays;

import static org.fest.assertions.error.ElementsShouldNotHave.elementsShouldNotHave;
import static org.fest.assertions.test.TestData.someInfo;
import static org.fest.test.TestFailures.failBecauseExpectedAssertionErrorWasNotThrown;
import static org.fest.util.Arrays.array;
import static org.fest.util.Collections.list;

import static org.mockito.Mockito.verify;

import org.junit.Test;

import org.fest.assertions.core.AssertionInfo;
import org.fest.assertions.internal.ObjectArrays;
import org.fest.assertions.internal.ObjectArraysWithConditionBaseTest;

/**
 * Tests for
 * <code>{@link ObjectArrays#haveNot(org.fest.assertions.core.AssertionInfo, Object[], org.fest.assertions.core.Condition)}</code>
 * .
 * 
 * @author Nicolas François
 * @author Mikhail Mazursky
 * @author Joel Costigliola
 */
public class ObjectArrays_assertHaveNot_Test extends ObjectArraysWithConditionBaseTest {

  @Test
  public void should_pass_if_each_element_satisfies_condition() {
    actual = array("Solo", "Leia");
    arrays.assertDoNotHave(someInfo(), actual, jediPower);
  }

  @Test
  public void should_throw_error_if_condition_is_null() {
    thrown.expectNullPointerException("The condition to evaluate should not be null");
    arrays.assertDoNotHave(someInfo(), actual, null);
  }

  @Test
  public void should_fail_if_condition_is_met() {
    testCondition.shouldMatch(false);
    AssertionInfo info = someInfo();
    try {
      actual = array("Solo", "Leia", "Yoda");
      arrays.assertDoNotHave(someInfo(), actual, jediPower);
    } catch (AssertionError e) {
      verify(failures).failure(info, elementsShouldNotHave(actual, list("Yoda"), jediPower));
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }

}
