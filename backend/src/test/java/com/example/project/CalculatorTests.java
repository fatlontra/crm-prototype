/*
 * Copyright 2015-2025 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

  @ParameterizedTest(name = "{0} - {1} = {2}", quoteTextArguments = false)
  @CsvSource(textBlock = """
          0,    1,  -1
          1,    2,  -1
          49,  51,  -2
          1,  100, -99
      """)

  void sub(int first, int second, int expectedResult) {
    Calculator calculator = new Calculator();
    assertEquals(expectedResult, calculator.sub(first, second),
        () -> first + " - " + second + " should equal " + expectedResult);

  }

  @ParameterizedTest(name = "{0} + {1} = {2}", quoteTextArguments = false)
  @CsvSource(textBlock = """
      0,    1,   1
      1,    2,   3
      49,  51, 100
      1,  100, 101
      """)

  void add(int first, int second, int expectedResult) {
    Calculator calculator = new Calculator();
    assertEquals(expectedResult, calculator.add(first, second),
        () -> first + " + " + second + " should equal " + expectedResult);
  }

}
