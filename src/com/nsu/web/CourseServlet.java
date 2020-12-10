package com.nsu.web;

import com.nsu.bean.Course;
import com.nsu.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author yr
 * @date 2020/11/16 20:26
 */
public class CourseServlet extends BaseServlet{
    CourseService courseService = new CourseService();
    public void add(HttpServletRequest req, HttpServletResponse resp){

    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        courseService.deleteCourseById(Integer.valueOf(id));
        resp.sendRedirect("/student/courseServlet?action=list");
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Course course = courseService.queryCourseById(Integer.parseInt(id));
        req.setAttribute("course",course);
        req.getRequestDispatcher("/pages/manager/course_edit.jsp").forward(req,resp);


    }
    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> courses = courseService.queryCourses();
        req.setAttribute("courses",courses);
        req.getRequestDispatcher("/pages/manager/manager_course.jsp").forward(req,resp);
    }
    public void query(HttpServletRequest req, HttpServletResponse resp){

    }
}
