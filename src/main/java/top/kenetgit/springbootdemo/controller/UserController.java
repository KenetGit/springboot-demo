package top.kenetgit.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.kenetgit.springbootdemo.pojo.PageInfo;
import top.kenetgit.springbootdemo.pojo.TbUser;
import top.kenetgit.springbootdemo.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(ModelMap modelMap) throws Exception {

        TbUser user = new TbUser();
        user.setUsername("吴晓龙");
        user.setId(Long.valueOf(5));
        user.setPassword("12344");

        userService.saveUser(user);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageName("addUser");
        modelMap.addAttribute("pageInfo",pageInfo);
        return "freemarker/thymeleaf";
    }
}
