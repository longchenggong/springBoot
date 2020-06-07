package com.ello.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/15  15:55
 * @since 1.0.0
 */
/*@ResponseBody   //所有方法返回的数据写给浏览器(如果是对象返回json数据)
@Controller*/

@RestController
public class HelloWorldController {

    @Value("${person.name}")
    private String name;

    @GetMapping("/hello")
    public String  sayHello_get(){
        return "Hi ~~@@ Hi~~~"+name;
    }

    @PostMapping("hello")
    public String  sayHello_post(){
        return "Hi ~~@@ Hi~~~";
    }


    @RequestMapping(value = "thymeleaf",method = RequestMethod.GET)
    public String show(Model model){
        model.addAttribute("uid","sdfs");
        model.addAttribute("name","name");
        System.out.println("@@@"+model);

        return "thymeleaf";
    }



}
