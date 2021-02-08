package net.suncaper.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("GlobalVariable")
public class GlobalVariableController {//全局变量控制器，需要什么就往里面加，要取的时候就写方法来取

    public static int id;//公司id
    public static String name;//公司名称
    @GetMapping("GetCompanyId")
    public int GetCompanyID(){//公司Id被存在全局变量中，需要的时候就从里面取
        return id;
    }

    @RequestMapping("GetCompanyName")
    public String GetCompanyName(){//公司Name被存在全局变量中，需要的时候就从里面取
        return name;
    }
}
