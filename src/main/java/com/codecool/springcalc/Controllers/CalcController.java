package com.codecool.springcalc.Controllers;

import com.codecool.springcalc.Factories.CalculationServiceFactory;
import com.codecool.springcalc.Model.CalculatorModel;
import com.codecool.springcalc.Services.Calculatable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalcController {

    @Autowired
    CalculationServiceFactory calculationServiceFactory;

    public CalcController(CalculationServiceFactory calculationServiceFactory) {
        this.calculationServiceFactory = calculationServiceFactory;
    }

    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public String calcForm(Model model) {
        model.addAttribute("calculatorModel", new CalculatorModel());
        return "calc";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST)
    public String getOperationResult(@ModelAttribute CalculatorModel calculatorModel) {
        Calculatable calculateService =
                calculationServiceFactory.getCalculationService(calculatorModel.getCalculation());
        System.out.println("RESULT: " + calculateService.calculate(calculatorModel));
        calculatorModel.setResult(calculateService.calculate(calculatorModel));
        return "result";
    }


}
