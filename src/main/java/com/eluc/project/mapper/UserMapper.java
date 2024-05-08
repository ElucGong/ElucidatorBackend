package com.eluc.project.mapper;

import com.eluc.project.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT id, name, email, avatar, description, created_at, is_admin, is_active FROM user " +
            "WHERE LOCATE(#{name}, name)>0 AND is_admin=false")
    public List<User> getUser(String name);

    @Select("SELECT id, name, email, avatar, description, created_at, is_admin, is_active FROM user WHERE id=#{id}")
    public User getUserById(int id);

    @Select("SELECT * FROM user WHERE name=#{name}")
    public User getUserByName(String name);

    @Select("SELECT * FROM user WHERE email=#{email}")
    public User getUserByEmail(String email);

    @Insert("INSERT INTO user (name, password, email) VALUES (#{name}, #{password}, #{email})")
    public int createUser(User user);

    @Update("UPDATE user SET name=#{name}, description=#{description}, avatar=#{avatar} WHERE id=#{id}")
    public int updateUser(User user);

    @Update("Update user SET is_active=#{isActive} WHERE id=#{id}")
    public int setUserState(User user);

    @Select("SELECT user.id, user.name, user.email, user.avatar, user.description " +
            "FROM user INNER JOIN follow ON user.id=follow.uid " +
            "WHERE follow.tid=#{tid} AND LOCATE(#{name}, user.name)>0")
    public List<User> getUserForStatistic(int tid, String name);
}
