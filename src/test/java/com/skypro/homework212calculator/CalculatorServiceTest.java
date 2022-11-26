package com.skypro.homework212calculator;

import com.skypro.homework212calculator.exception.IllegalCalculatorException;
import com.skypro.homework212calculator.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("foldTestMethod")
    public void foldTest(int n1, int n2, int result) {
        Assertions.assertEquals(result, calculatorService.fold(n1, n2));
    }

    @ParameterizedTest
    @MethodSource("subtractintTestMethod")
    public void subtractintTest(int n1, int n2, int result) {
        Assertions.assertEquals(result, calculatorService.subtract(n1, n2));
    }

    @ParameterizedTest
    @MethodSource("multiplyTestMethod")
    public void multiplyTest(int n1, int n2, int result) {
        Assertions.assertEquals(result, calculatorService.multiply(n1, n2));
    }

    @ParameterizedTest
    @MethodSource("divideTestMethod")
    public void divideTest(int n1, int n2, int result) throws IllegalCalculatorException {
        Assertions.assertEquals(result, calculatorService.divide(n1, n2));
    }

    @Test
    public void divideByZero() {
        Assertions.assertThrows(IllegalCalculatorException.class, () ->
        {
            calculatorService.divide(3, 0);
        });
    }

    public static List<Arguments> foldTestMethod() {
        return List.of(
                Arguments.of(10, 10, 20),
                Arguments.of(5, 5, 10),
                Arguments.of(2, 2, 4)
        );
    }

    public static List<Arguments> subtractintTestMethod() {
        return List.of(
                Arguments.of(10, 5, 5),
                Arguments.of(15, 5, 10),
                Arguments.of(6, 2, 4)
        );
    }

    public static List<Arguments> multiplyTestMethod() {
        return List.of(
                Arguments.of(10, 5, 50),
                Arguments.of(1, 5, 5),
                Arguments.of(6, 2, 12)
        );
    }

    public static List<Arguments> divideTestMethod() {
        return List.of(
                Arguments.of(10, 5, 2),
                Arguments.of(18, 2, 9),
                Arguments.of(6, 2, 3)
        );
    }
}
