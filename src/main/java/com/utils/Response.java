package com.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.asyncresttemplate.User;

/**
 * ${DESCRIPTION}
 *
 * @author lidongliang
 * @create 2018-01-01 下午4:11
 **/
@Controller
public class Response {

    @RequestMapping("/api1")
    public ResponseEntity<User> method1() {
        User user = new User();
        user.setId(1L);
        user.setName("xiaoming");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
