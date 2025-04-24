package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validate")
public class ValidationController {
    private final DerivedData derivedData = new DerivedData();
    @GetMapping
    public boolean  validate(
        @RequestParam String moduleAttr,
        @RequestParam String customOperatorValue,
        @RequestParam String operator
    ){
        return derivedData.validateOperator(moduleAttr, customOperatorValue, operator);
    }
}
