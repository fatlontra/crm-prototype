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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

  @Test
  @DisplayName("1 + 1 = 2")
  void addsTwoNumbers() {
    Calculator calculator = new Calculator();
    assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
  }

  @Test
  @DisplayName("1 - 1 = 0")
  void subSingleDigitNumbers() {
    Calculator calculator = new Calculator();
    assertEquals(0, calculator.sub(1, 1), "1 - 1 should equal 0");

  }

  @Test
  @DisplayName("21 - 1 = 20")
  void subDoubleDigitNumbers() {
    Calculator calculator = new Calculator();
    assertEquals(20, calculator.sub(21, 1), "21 - 1 should equal 20");
  }

  @Test
  @DisplayName("-5 - -1 = -4")
  void subSingNegativeNumbers() {
    Calculator calculator = new Calculator();
    assertEquals(-4, calculator.sub(-5, -1), "-5 - -1 should equal -4");

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
