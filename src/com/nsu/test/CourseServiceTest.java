package com.nsu.test;

import com.nsu.bean.Course;
import com.nsu.service.CourseService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yr
 * @date 2020/11/16 20:06
 */
public class CourseServiceTest {
CourseService courseService = new CourseService();
    @Test
    public void addCourse() {
        courseService.addCourse(new Course(null,"语言的艺术","姚老师","9-1-2050","C5",60,60));
    }

    @Test
    public void deleteCourseById() {
        courseService.deleteCourseById(3);
    }

    @Test
    public void updateCourse() {
        courseService.updateCourse(new Course(7,"语言的艺术","姚老师","9-1-2020","C5",60,60));
    }

    @Test
    public void queryCourseById() {
        System.out.println(courseService.queryCourseById(7));
    }

    @Test
    public void queryCourses() {
        List<Course> courses = courseService.queryCourses();
        for (Course course:courses){
            System.out.println(course);
        }
    }
    @Test
    public void updateRemainCount(){
        courseService.updateRemainCount(1,59);
    }
}