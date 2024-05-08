package com.eluc.project.controller;

import com.eluc.project.entity.User;
import com.eluc.project.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("")
    public PageInfo getUser(@RequestParam("page") int page,
                            @RequestParam("size") int size,
                            @RequestParam("value") String name){
        PageHelper.startPage(page, size);
        List<User> list = userMapper.getUser(name);

        return new PageInfo(list);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userMapper.getUserById(id);
    }

    @GetMapping("/name/{name}")
    public User getUserByName(@PathVariable("name") String name){
        return userMapper.getUserByName(name);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable("email") String email){
        return userMapper.getUserByEmail(email);
    }

    @PostMapping("")
    public int create(@RequestBody User user) {
        return userMapper.createUser(user);
    }

    @PutMapping("")
    public int update(@RequestBody User user) {
        return userMapper.updateUser(user);
    }

    @PutMapping("/state")
    public int setState(@RequestBody User user) {
        return userMapper.setUserState(user);
    }

    @GetMapping("/statistic/tid/{tid}")
    public PageInfo getUserForStatistic(@PathVariable("tid") int tid,
                                        @RequestParam("page") int page,
                                        @RequestParam("size") int size,
                                        @RequestParam("name") String name){
        PageHelper.startPage(page, size);
        List<User> list = userMapper.getUserForStatistic(tid, name);

        return new PageInfo(list);
    }
}
