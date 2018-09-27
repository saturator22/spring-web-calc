package com.codecool.springcalc.Factories;

import com.codecool.springcalc.Services.*;
import org.springframework.stereotype.Component;

@Component
public class CalculationServiceFactory {

    public Calculatable getCalculationService(String operation) {

        switch(operation) {
            case "addition":
                return new AdditionService();
            case "substraction":
                return new SubstractionService();
            case "multiplication":
                return new MultiplicationService();
            case "division":
                return new DivisionService();
        }

        throw new IllegalArgumentException();
    }
}
