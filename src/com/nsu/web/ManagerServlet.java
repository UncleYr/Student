package com.nsu.web;

import com.nsu.bean.Course;
import com.nsu.bean.Manager;
import com.nsu.bean.User;
import com.nsu.service.CourseService;
import com.nsu.service.ManagerService;
import com.nsu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yr
 * @date 2020/11/16 14:56
 */
public class ManagerServlet extends BaseServlet{
    ManagerService managerService = new ManagerService();
    CourseService courseService = new CourseService();
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Manager loginManager = managerService.login(new Manager(null,username, password));
        if (loginManager==null){
            req.setAttribute("msg","用户名或密码错误");
            req.getRequestDispatcher("/pages/manager/login.jsp").forward(req,resp);

        }else {
            req.getSession().setAttribute("username",username);
            req.getRequestDispatcher("/pages/manager/login_success.jsp").forward(req,resp);
        }
    }

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = managerService.queryUsers();
        req.setAttribute("users",users);
        req.getRequestDispatcher("/pages/manager/student.jsp").forward(req,resp);
    }
    public void addCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数==封装成为Course对象
        Course course = WebUtils.copyParamToBean(req.getParameterMap(),new Course());
        courseService.addCourse(course);
        resp.sendRedirect("/student/courseServlet?action=list");
    }
    public void updateCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Course course = WebUtils.copyParamToBean(req.getParameterMap(), new Course());
        courseService.updateCourse(course);
        resp.sendRedirect("/student/courseServlet?action=list");
    }


    public void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        managerService.addUser(user);
        resp.sendRedirect("/student/managerServlet?action=list");
    }
    public void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        managerService.deleteUserById(id);
        resp.sendRedirect("/student/managerServlet?action=list");
    }
    public void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user = managerService.queryUserById(id);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/pages/manager/student_edit.jsp").forward(req,resp);

    }
    public void getStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user= WebUtils.copyParamToBean(req.getParameterMap(), new User());
        managerService.updateUser(user);
        resp.sendRedirect("/student/managerServlet?action=list");

    }
    public void searchUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String username = req.getParameter("username");
        String id = req.getParameter("id");
        if(id==null){
            id="";
        }
        List<User> users = managerService.findUsersByNameAndId(username, id);
        req.setAttribute("users",users);
        req.getRequestDispatcher("/pages/manager/student.jsp").forward(req,resp);


    }
}
