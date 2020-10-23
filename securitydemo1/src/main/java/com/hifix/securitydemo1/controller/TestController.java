package com.hifix.securitydemo1.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/hello")
    public  String hello(){

return "hello security!";
    }

@GetMapping("index")
    public String index(){
        return "hello index";
}


    @GetMapping("update")
    @Secured({"ROLE_sale","ROLE_manager"})
    public String update(){
        return "hello index";
    }



}
