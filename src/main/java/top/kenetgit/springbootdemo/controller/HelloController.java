package top.kenetgit.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.kenetgit.springbootdemo.pojo.PageInfo;
import top.kenetgit.springbootdemo.pojo.User;
import top.kenetgit.springbootdemo.util.JSONResult;

import java.util.Date;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping("/test")
    @ResponseBody
    public JSONResult hello() {
        User user = new User();
        user.setUsername("kenet");
        user.setPassword("123344");
        user.setAge(22);
        user.setBirthday(new Date());
        return JSONResult.okBuild(user);
    }

    @RequestMapping("/html")
    public String thymeleaf(ModelMap modelMap) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageName("KenetGit");
        modelMap.addAttribute("pageInfo",pageInfo);
        return "freemarker/thymeleaf";
    }
}
