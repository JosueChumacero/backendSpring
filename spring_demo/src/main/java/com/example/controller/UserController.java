/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.modelo.User;
import com.example.service.UserServiceI;
import com.example.util.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ChUmA
 */
@RestController
public class UserController {

    @Autowired
    protected UserServiceI userServiceI;

    protected ObjectMapper mapper;

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public RestResponse saveOrUpdate(@RequestBody String userJson) {
        try {
            mapper = new ObjectMapper();
            User user = mapper.readValue(userJson, User.class);
            if (!userValidator(user)) {
                return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "algunos campos obligatorios esta nulos");
            }
            userServiceI.save(user);
            return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
        } catch (IOException ex) {
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), ex.getMessage());
        }
    }

    private boolean userValidator(User user) {
        boolean isValid = true;
        if (user.getFirstName().isEmpty()) {
            isValid = false;
        }
        if (user.getFirstSurname().isEmpty()) {
            isValid = false;
        }
        if (user.getAddress().isEmpty()) {
            isValid = false;
        }
        return isValid;
    }
}
