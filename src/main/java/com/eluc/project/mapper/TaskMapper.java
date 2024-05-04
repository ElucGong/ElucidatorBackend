package com.eluc.project.mapper;

import com.eluc.project.entity.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Select("SELECT * FROM task WHERE LOCATE(#{title}, title)>0")
    public List<Task> getTask(String title);

    @Select("SELECT * FROM task WHERE id=#{id}")
    public Task getTaskById(int id);

    @Select("SELECT * FROM task WHERE uid=#{uid}")
    public List<Task> getTaskByUser(int uid);

    @Select("SELECT * FROM task WHERE uid=#{uid} AND LOCATE(#{title}, title)>0")
    public List<Task> getTaskByUserAndTitle(int uid, String title);

    @Select("SELECT task.id, task.title, task.description, task.media, " +
            "task.cover, task.state, task.created_at, task.uid " +
            "FROM task INNER JOIN follow ON task.id=follow.tid " +
            "WHERE follow.uid=#{uid}")
    public List<Task> getTaskByFollow(int uid);

//    @Select("SELECT * FROM task WHERE id IN (SELECT tid FROM follow WHERE uid=#{uid})")
//    public List<Task> getTaskByFollow(int uid);

    @Select("SELECT task.id, task.title, task.description, task.media, " +
            "task.cover, task.state, task.created_at, task.uid " +
            "FROM task INNER JOIN follow ON task.id=follow.tid " +
            "WHERE follow.uid=#{uid} AND LOCATE(#{title}, task.title)>0")
    public List<Task> getTaskByFollowAndTitle(int uid, String title);

    @Insert("INSERT INTO task (title, description, media, cover, uid) " +
            "VALUES (#{title}, #{description}, #{media}, #{cover}, #{uid})")
    public int createTask(Task task);

    @Update("UPDATE task SET title=#{title}, description=#{description}, media=#{media}, " +
            "cover=#{cover} WHERE id=#{id}")
    public int updateTask(Task task);

    @Update("Update task SET state=#{state} WHERE id=#{id}")
    public int setTaskState(Task task);

    @Delete("DELETE FROM task WHERE id=#{id}")
    public int deleteTask(int id);
}
