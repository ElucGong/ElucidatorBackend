package com.eluc.project.controller;

import com.eluc.project.entity.Follow;
import com.eluc.project.mapper.FollowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follow")
@CrossOrigin
public class FollowController {

    @Autowired
    private FollowMapper followMapper;

    @PostMapping("")
    public int create(@RequestBody Follow follow){
        return followMapper.createFollow(follow);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return followMapper.deleteFollow(id);
    }

    @GetMapping("")
    public Follow getFollow(@RequestParam("uid") int uid,
                            @RequestParam("tid") int tid){
        Follow res =  followMapper.getFollow(uid, tid);
        System.out.println(res);
        return res;
    }
}
