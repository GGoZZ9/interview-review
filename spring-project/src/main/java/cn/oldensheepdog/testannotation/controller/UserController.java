package cn.oldensheepdog.testannotation.controller;

import cn.oldensheepdog.testannotation.model.Response;
import cn.oldensheepdog.testannotation.model.ResponseCode;
import cn.oldensheepdog.testannotation.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class UserController {

    @GetMapping(value = "/user/findAllUser", produces = "application/json;charset=UTF-8")
    public Response<List<User>> findAllUser(){
        log.info("开始查询所有数据...");

        final List<User> findAllUser = new ArrayList<>();
        findAllUser.add(new User("Alice", 26));
        findAllUser.add(new User("Jack", 28));

        Response<List<User>> response = new Response(findAllUser, ResponseCode.SUCCESS.code(), ResponseCode.SUCCESS.message());
        log.info("response: {} \n", response.toString());
        return response;
    }
}
