package com.demo.wenda.dao;

import com.demo.wenda.domain.Collections;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * create by: one
 * create time:2018/12/1 17:47
 * 描述：CollectionDAO
 */
@Mapper
public interface CollectionDAO {
    String TABLE_NAME = "collection";
    String INSERT_FIELDS = "user_id,entity_id,entity_type,create_date";

    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,") values(#{userId},#{entityId},#{entityType},#{createDate})"})
    Integer addComment(Collections collection);

    @Delete({"delete  from ",TABLE_NAME," where entity_id = #{entityId} and entity_type = #{entityType} and uset_id = #{userId}"})
    Integer deleteComment(Collections collection);

    @Select({"select COUNT(*) from",TABLE_NAME,"where user_id = #{userId}"})
    Integer getUserCollectionCount(int userId);

    @Select({"select entity_id from", TABLE_NAME, "where user_id = #{userId} and entity_type = #{entityType}"})
    List<String> getEntityId(int userId, int entityType);

    @Select({"select collection_id from", TABLE_NAME, "where user_id = #{userId} and entity_type = #{entityType} and entity_id = #{entityId}"})
    Integer getId(int userId, int entityType, int entityId);
}
