package com.skypro.homework212calculator.service;

import com.skypro.homework212calculator.exception.IllegalCalculatorException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int fold(int n1, int n2) {
        return n1 + n2;
    }

    public int subtract(int n1, int n2) {
        return n1 - n2;
    }

    public int multiply(int n1, int n2) {
        return n1 * n2;
    }

    public int divide(int n1, int n2) throws IllegalCalculatorException {
        if (n2 == 0){
            throw new IllegalCalculatorException("На 0 делить нельзя!");

        }
        return n1 / n2;
    }
}
