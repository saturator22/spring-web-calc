package com.codecool.springcalc.Services;

import com.codecool.springcalc.Model.CalculatorModel;

public class DivisionService implements Calculatable {

    @Override
    public double calculate(CalculatorModel calculatorModel) {
        if(calculatorModel.getSecondNumber() == 0) {
            throw new IllegalArgumentException("Divisor cannot equals 0");
        }
        return calculatorModel.getFirstNumber()/calculatorModel.getSecondNumber();
    }
}
