package com.codecool.springcalc.Services;

import com.codecool.springcalc.Model.CalculatorModel;

public class SubstractionService implements Calculatable {

    @Override
    public double calculate(CalculatorModel calculatorModel) {
        return calculatorModel.getFirstNumber() - calculatorModel.getSecondNumber();
    }
}
