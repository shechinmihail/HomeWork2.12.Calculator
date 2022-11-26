package com.skypro.homework212calculator.controller;

import com.skypro.homework212calculator.exception.IllegalCalculatorException;
import com.skypro.homework212calculator.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @ExceptionHandler(value = IllegalCalculatorException.class)
    public ResponseEntity<String> illegalCalculatorHandler(IllegalCalculatorException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @GetMapping("/")
    public String hello() {
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping("plus")
    public String fold(int num1, int num2) {
        int result = calculatorService.fold(num1, num2);
        return String.format("%d + %d = %d", num1, num2, result);
    }

    @GetMapping("/minus")
    public String subtract(int num1, int num2) {
        int result = calculatorService.subtract(num1, num2);
        return String.format("%d - %d = %d", num1, num2, result);
    }

    @GetMapping("/multiply")
    public String multiply(int num1, int num2){
        int result = calculatorService.multiply(num1, num2);
        return String.format("%d * %d = %d", num1, num2, result);
    }

    @GetMapping("/divide")
    public String divide(int num1, int num2) throws IllegalCalculatorException {
        int result = calculatorService.divide(num1, num2);
        return String.format("%d / %d = %d", num1, num2, result);
    }

}
