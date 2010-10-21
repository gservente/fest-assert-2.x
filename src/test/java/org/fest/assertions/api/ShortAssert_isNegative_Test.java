/*
 * Created on Oct 20, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010 the original author or authors.
 */
package org.fest.assertions.api;

import static junit.framework.Assert.assertSame;
import static org.mockito.Mockito.*;

import org.fest.assertions.internal.Shorts;
import org.junit.*;

/**
 * Tests for <code>{@link ShortAssert#isNegative()}</code>.
 *
 * @author Alex Ruiz
 */
public class ShortAssert_isNegative_Test {

  private Shorts Shorts;
  private ShortAssert assertions;

  @Before public void setUp() {
    Shorts = mock(Shorts.class);
    assertions = new ShortAssert((short)6);
    assertions.shorts = Shorts;
  }

  @Test public void should_verify_that_actual_is_negative() {
    assertions.isNegative();
    verify(Shorts).assertIsNegative(assertions.info, assertions.actual);
  }

  @Test public void should_return_this() {
    ShortAssert returned = assertions.isNegative();
    assertSame(assertions, returned);
  }
}
