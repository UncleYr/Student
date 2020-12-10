package com.nsu.service;

import com.nsu.bean.Course;
import com.nsu.bean.User;
import com.nsu.dao.CourseDao;
import com.nsu.dao.ManagerDao;

import java.util.List;

/**
 * @author
 * @date 2020/11/16 19:46
 */
public class CourseService {
    private CourseDao courseDao = new CourseDao();
    private ManagerDao managerDao = new ManagerDao();
    public void addCourse(Course course){
        courseDao.addCourse(course);
    }
    public void deleteCourseById(Integer id){
        courseDao.deleteCourseById(id);
    }
    public void updateCourse(Course course){
        courseDao.updateCourse(course);
    }
    public Course queryCourseById(Integer id){
        return courseDao.queryCourseById(id);
    }
    public List<Course> queryCourses(){
        return courseDao.queryCourses();
    }
    public int updateRemainCount(Integer id, Integer remainCount){

        return courseDao.updateRemainCount(new Course(id,null,null,null,null,null,remainCount));
    }

}
