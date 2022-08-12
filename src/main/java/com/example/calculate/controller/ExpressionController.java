package com.example.calculate.controller;

import com.example.calculate.model.Expression;
import com.example.calculate.service.ExpressionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ExpressionController {

    private final ExpressionService expressionService;

    public ExpressionController(ExpressionService expressionService) {
        this.expressionService = expressionService;
    }


    @GetMapping
    public String greetingSome(Model model){
        model.addAttribute("expression" , new Expression());
                return "Operations";
    }

    @GetMapping("/my")
    public String myExpression(Model model ){
        model.addAttribute("my",expressionService.list());
        return "operation-info";
    }


    @PostMapping("/")
    public String greetingSubmit(Model model, @Valid Expression expression, Errors errors) {
        if (errors.hasErrors()) {
            return "operations";
        }
        double result = expressionService.getResult(expression.getNumOne(), expression.getNumTwo(), expression.getExpr());
        model.addAttribute("result", "Result: " + result);
        expressionService.addExpression(expression.getExpr(),expression.getNumOne(),expression.getNumTwo(),result);
        return "operations";
    }



    @PostMapping("/multiplication")
    public String multiplication(@Valid Expression expression, Errors errors, Model model){
        if (errors.hasErrors()) {
            return "operations";
        }
        double result1 = expressionService.multiplication(expression.getNumOne(), expression.getNumTwo(),expression.getExpr());
        model.addAttribute("result1", "Result: " + result1);
        expressionService.addExpression("*",expression.getNumOne(),expression.getNumTwo(),result1);
        return "operations";
    }

    @PostMapping("/division")
    public String division(@Valid Expression expression, Errors errors, Model model){
        if (errors.hasErrors()) {
            return "operations";
        }
        double result2 = expressionService.division(expression.getNumOne(), expression.getNumTwo(),expression.getExpr());
        model.addAttribute("result2", "Result: " + result2);
        expressionService.addExpression("/",expression.getNumOne(),expression.getNumTwo(),result2);
        return "operations";
    }
    @PostMapping("/addition")
    public String addition(@Valid Expression expression, Errors errors, Model model){
        if (errors.hasErrors()) {
            return "operations";
        }
        double result3 = expressionService.addition(expression.getNumOne(), expression.getNumTwo(),expression.getExpr());
        model.addAttribute("result3", "Result: " + result3);
        expressionService.addExpression("+",expression.getNumOne(),expression.getNumTwo(),result3);
        return "operations";
    }
    @PostMapping("/subtraction")
    public String subtraction(@Valid Expression expression, Errors errors, Model model){
        if (errors.hasErrors()) {
            return "operations";
        }
        double result4 = expressionService.subtraction(expression.getNumOne(), expression.getNumTwo(),expression.getExpr());
        model.addAttribute("result4", "Result: " + result4);
        expressionService.addExpression("-",expression.getNumOne(),expression.getNumTwo(),result4);
        return "operations";
    }

}
