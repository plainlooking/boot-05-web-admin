package com.atguigu.admin.controller;

import com.atguigu.admin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    /**
     * 来登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String LoginPage(){

        return "login";
    }

   @PostMapping("/login")
    public String index(User user, HttpSession session, Model model){

        if (!StringUtils.isEmpty(user.getUserName()) && "123456".equals(user.getPassword())){
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser",user);
            //登陆成功重定向到index.html，重定向防止表单重复提交
            return "redirect:/index.html";
       }else {
            model.addAttribute("msg", "账号或者密码错误");
            return "login";
        }
    }

    /**
     * 去index页面
     * @return
     */
    @GetMapping("/index.html")
    public String indexPage(HttpSession session,Model model){
        //是否登录，拦截器，过滤器
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null){
            return "index";
        }else {
            model.addAttribute("msg","请重新登陆");
            return "login";
        }
    }
}
