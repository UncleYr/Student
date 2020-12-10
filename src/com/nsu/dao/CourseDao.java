package com.nsu.dao;

import com.nsu.bean.Course;
import com.nsu.bean.User;

import java.util.List;

/**
 * @author yr
 * @date 2020/11/16 17:31
 */
public class CourseDao extends BaseDao{
    public int addCourse(Course course){
        String sql = "insert into s_course(`coursename`,`teacher`,`time`,`place`,`count`,`remainCount`) values(?,?,?,?,?,?)";
        return update(sql,course.getName(),course.getTeacher(),course.getTime(),course.getPlace(),course.getCount(),course.getRemainCount());

    }
    public int deleteCourseById(Integer id){
        String sql = "delete from s_course where id = ?";
        return update(sql,id);
    }
    public int updateCourse(Course course){
        String sql = "update s_course set `coursename`=?,`teacher`=?,`time`=?,`place`=?,`count`=?,`remainCount`=? where id=?";
        return update(sql,course.getName(),course.getTeacher(),course.getTime(),course.getPlace(),course.getCount(),course.getRemainCount(),course.getId());
    }
    public Course queryCourseById(Integer id){
        String sql = "select `id`,`coursename` as `name`,`teacher`,`time`,`place`,`count`,`remainCount` from s_course where id = ?";
        return queryForOne(Course.class,sql,id);
    }
    public List<Course> queryCourses(){
        String sql = "select `id`,`coursename` as `name`,`teacher`,`time`,`place`,`count`,`remainCount` from s_course";
        return queryForList(Course.class,sql);
    }
    public int updateRemainCount(Course course){
        String sql = "update s_course set `remainCount`=? where id = ?";
        return update(sql,course.getRemainCount(),course.getId());
    }
}
