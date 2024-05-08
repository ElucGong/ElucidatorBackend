package com.eluc.project.mapper;

import com.eluc.project.entity.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    @Select("SELECT * FROM post WHERE LOCATE(#{title}, title)>0")
    public List<Post> getPost(String title);

    @Select("SELECT * FROM post WHERE id=#{id}")
    public Post getPostById(int id);

    @Select("SELECT * FROM post WHERE uid=#{uid} AND LOCATE(#{title}, title)>0")
    public List<Post>  getPostByUser(int uid, String title);

    @Select("SELECT * FROM post WHERE tid=#{tid} AND LOCATE(#{title}, title)>0")
    public List<Post>  getPostByTask(int tid, String title);

    @Insert("INSERT INTO post (title, description, media, cover, uid, tid) " +
            "VALUES (#{title}, #{description}, #{media}, #{cover}, #{uid}, #{tid})")
    public int createPost(Post post);

    @Update("UPDATE post SET title=#{title}, description=#{description}, media=#{media}, " +
            "cover=#{cover} WHERE id=#{id}")
    public int updatePost(Post post);

    @Delete("DELETE FROM post WHERE id=#{id}")
    public int deletePost(int id);
}
