/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ChUmA
 */
@RestController
public class IndexController {
    
    @RequestMapping("/")
    public String index(){
        return "HOLA MUNDO";
    }
}
