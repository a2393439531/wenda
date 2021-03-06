package com.demo.wenda.dao;

import com.demo.wenda.domain.Question;
import com.demo.wenda.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface QuestionDao {
    String TABLE_NAME = "question";
    String INSERT_FIELDS = "title,content,user_id,anonymous,create_time,comment_count";
    String SELECT_FIELDS = "question_id,"+INSERT_FIELDS;

    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,") values(#{title},#{content},#{userId},#{anonymous},#{createTime},#{commentCount})"})
    @Options(useGeneratedKeys=true, keyProperty="questionId", keyColumn="question_id")//插入成功后马上返回，其自增的id
    int addQuestion(Question question);


    List<Question> selectUserLatestQuestions(@Param("userId") int userId, @Param("offset") int offset,
                             @Param("limit") int limit);

    @Select({"select * from "+TABLE_NAME+" where question_id = #{id}"})
    Question getById(int id);

    @Select({"select * from "+TABLE_NAME+" order by create_time desc"})
    List<Question> selectLatestQuestions();

    @Select({"select count(*) from "+TABLE_NAME+" where user_id= #{userId}"})
    Long getUserQuestionCount(int userId);


//    update question set comment_count = comment_count+1 where question_id = 13;
    @Update({"update "+TABLE_NAME+" set comment_count = comment_count+1 where question_id = #{questionId}"})
    Long incrCommentCount(Integer questionId);

    @Select({"select create_time from " + TABLE_NAME + " where question_id= #{questionId}"})
    String getTime(int questionId);

    List<Question> selectHotQuestion(@Param("list") List list);
}
