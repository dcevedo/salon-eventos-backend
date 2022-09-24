package com.ciclo3.saloneventos.controllers;
import com.ciclo3.saloneventos.exceptions.ApiMalformedException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RouteController {

    @RequestMapping(value = ("/{path:[^\\.]*}"))
    public String redirect(HttpServletRequest request ){
        return "forward:/";
    }
    @RequestMapping(value = "/api/**") 
    public void invalidApi(HttpServletRequest request){
        throw new ApiMalformedException(request.getRequestURI());
    }
}