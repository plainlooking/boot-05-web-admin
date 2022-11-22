package com.atguigu.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableController {

    @GetMapping("/basic_table.html")
    public String basic_table(){
        return "basic_table";
    }

    @GetMapping("/dynamic_table.html")
    public String dynamic_table(){
        return "dynamic_table";
    }

    @GetMapping("/editable_table.html")
    public String editable_table(){
        return "editable_table";
    }

    @GetMapping("/responsive_table.html")
    public String responsive_table(){
        return "responsive_table";
    }
}
