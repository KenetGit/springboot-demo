package top.kenetgit.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kenetgit.springbootdemo.pojo.TbUser;
import top.kenetgit.springbootdemo.util.JSONResult;
import top.kenetgit.springbootdemo.util.JsonUtils;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test")
    public JSONResult test() {
        TbUser user = new TbUser();
        user.setId(Long.valueOf(6));
        user.setUsername("jsonUser");
        user.setPassword("jsonUser");
        // 将user换成json字符串再存储
        stringRedisTemplate.opsForValue().set("json:user", JsonUtils.objectToJson(user));
        // 取出json字符串转换成user对象
        TbUser user1 = JsonUtils.jsonToPojo(stringRedisTemplate.opsForValue().get("json:user"),TbUser.class);
        return JSONResult.okBuild(user1);
    }
}
