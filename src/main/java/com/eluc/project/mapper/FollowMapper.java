package com.eluc.project.mapper;

import com.eluc.project.entity.Follow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FollowMapper {

    @Insert("INSERT INTO follow (uid, tid) VALUES (#{uid}, #{tid})")
    public int createFollow(Follow follow);

    @Delete("DELETE FROM follow WHERE id=#{id}")
    public int deleteFollow(int id);

    @Select("SELECT * FROM follow WHERE uid=#{uid} AND tid=#{tid}")
    public Follow getFollow(int uid, int tid);
}
