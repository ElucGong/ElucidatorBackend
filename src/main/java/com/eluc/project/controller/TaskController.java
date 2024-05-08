package com.eluc.project.controller;

import com.eluc.project.entity.Task;
import com.eluc.project.mapper.TaskMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskMapper taskMapper;

    @GetMapping("")
    public PageInfo getTask(@RequestParam("value") String title,
                            @RequestParam("page") int page,
                            @RequestParam("size") int size){
        PageHelper.startPage(page, size);
        List<Task> list = taskMapper.getTask(title);

        return new PageInfo(list);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") int id){
        return taskMapper.getTaskById(id);
    }

    @GetMapping("/uid/{uid}")
    public PageInfo getTaskByUser(@PathVariable("uid") int uid,
                                  @RequestParam("page") int page,
                                  @RequestParam("size") int size,
                                  @RequestParam("title") String title){
        PageHelper.startPage(page, size);
        List<Task> list = taskMapper.getTaskByUser(uid, title);

        return new PageInfo(list);
    }

    @GetMapping("/follow/uid/{uid}")
    public PageInfo getTaskByFolllow(@PathVariable("uid") int uid,
                                     @RequestParam("page") int page,
                                     @RequestParam("size") int size,
                                     @RequestParam("title") String title){
        PageHelper.startPage(page, size);
        List<Task> list = taskMapper.getTaskByFollow(uid, title);

        return new PageInfo(list);
    }

    @PostMapping("")
    public int create(@RequestBody Task task){
        return taskMapper.createTask(task);
    }

    @PutMapping("")
    public int update(@RequestBody Task task){
        return taskMapper.updateTask(task);
    }

    @PutMapping("/state")
    public int setState(@RequestBody Task task){
        return taskMapper.setTaskState(task);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return taskMapper.deleteTask(id);
    }
}
