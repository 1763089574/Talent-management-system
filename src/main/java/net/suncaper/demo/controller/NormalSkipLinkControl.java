package net.suncaper.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//普通跳转页面的通用
//如果没有特别的需求，此控制器就可以实现所有双 '/' 页面跳转

@Controller
public class NormalSkipLinkControl {
    @RequestMapping("/{path1}/{path2}")

    public String PageSkip1(@PathVariable("path1") String p ,@PathVariable("path2") String q ){
        return p+"/"+q;
    }


}
