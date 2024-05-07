package com.eluc.project.controller;

import com.eluc.project.entity.Post;
import com.eluc.project.mapper.PostMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostMapper postMapper;

    @GetMapping("")
    public PageInfo getPost(@RequestParam("value") String title,
                            @RequestParam("page") int page,
                            @RequestParam("size") int size){
        PageHelper.startPage(page, size);
        List<Post> list = postMapper.getPost(title);

        return new PageInfo(list);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable("id") int id){
        return postMapper.getPostById(id);
    }

    @GetMapping("/uid/{uid}")
    public PageInfo getPostByUser(@PathVariable("uid") int uid,
                                  @RequestParam("page") int page,
                                  @RequestParam("size") int size,
                                  @RequestParam(value = "title", required = false) String title){
        PageHelper.startPage(page, size);
        List<Post> list;
        if(title == null)
            list = postMapper.getPostByUser(uid);
        else
            list = postMapper.getPostByUserAndTitle(uid, title);

        return new PageInfo(list);
    }

    @GetMapping("/tid/{tid}")
    public PageInfo getPostByTask(@PathVariable("tid") int tid,
                                  @RequestParam("page") int page,
                                  @RequestParam("size") int size,
                                  @RequestParam(value = "title", required = false) String title){
        PageHelper.startPage(page, size);
        List<Post> list;
        if(title == null)
            list = postMapper.getPostByTask(tid);
        else
            list = postMapper.getPostByTaskAndTitle(tid, title);

        return new PageInfo(list);
    }

    @PostMapping("")
    public int create(@RequestBody Post post){
        return postMapper.createPost(post);
    }

    @PutMapping("")
    public int update(@RequestBody Post post){
        return postMapper.updatePost(post);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return postMapper.deletePost(id);
    }

    @GetMapping("/statistic/tid/{tid}")
    public List<Post> getPostForStatistic(@PathVariable("tid") int tid){
        return postMapper.getPostByTask(tid);
    }
}
