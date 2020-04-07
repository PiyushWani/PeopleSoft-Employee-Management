package com.peoplesoft.employee.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.peoplesoft.employee.models.EmployeeDocs;
import com.peoplesoft.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping
    public EmployeeDocs saveEmployee(@RequestBody JsonNode payload){
        return service.save(payload);
    }

    @GetMapping
    public JsonNode findEmployeeById(@RequestParam("experianId") Integer experianId){
        return service.findById(experianId);
    }

    @GetMapping("/name")
    public Iterable<EmployeeDocs> findViaEmployeeName(@RequestParam("name") String name){
        return service.findViaEmployeeName(name);
    }
}
