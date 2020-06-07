package com.ello.oa.controller.system;

import com.ello.oa.controller.AjaxResult;
import com.ello.oa.controller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/28  10:45
 * @since 1.0.0
 */
@Controller
public class loginController extends BaseController {

    @GetMapping("/login")//get则return login.html
    public String login(HttpServletRequest request, HttpServletResponse response){
        System.out.println("af");
        return "login";

    }

    @PostMapping("/login")//get则return login.html
    public AjaxResult login_Post(String username, String password, Boolean rememberMe){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return success();

    }
}
