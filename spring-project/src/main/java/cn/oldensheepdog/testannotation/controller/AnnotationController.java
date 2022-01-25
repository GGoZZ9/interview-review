package cn.oldensheepdog.testannotation.controller;

import cn.oldensheepdog.testannotation.annotation.GetDistributedLock;
import cn.oldensheepdog.testannotation.annotation.PrintLog;
import cn.oldensheepdog.testannotation.annotation.ResponseResult;
import cn.oldensheepdog.testannotation.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class AnnotationController {

    @ResponseResult
    @GetMapping(value = "/user/findAllUserByAnnotation", produces = "application/json;charset=UTF-8")
    public List<User> findAllUserByAnnotation(){
        log.info("开始查询所有数据。。。");
        List<User> findAllUser= new ArrayList<>();
        findAllUser.add(new User("雷震子", 26));
        findAllUser.add(new User("风火轮", 28));

        log.info("使用@ResponseResult 自定义注解进行响应的包装， 使controller代码更加简洁");
        return findAllUser;
    }

    @GetDistributedLock(lockKey = "userLock")
    @GetMapping(value = "/user/getDistributedLock", produces = "application/json;charset=UTF-8")
    public boolean getUserDistributedLock() {
        log.info("获取分布式锁");
        return true;
    }

    @PrintLog
    @GetMapping(value = "/user/findUserNameById/{id}", produces = "application/json;charset=UTF-8")
    public String findUserNameById(@PathVariable("id") int id){
        return  "风火轮";
    }
}
