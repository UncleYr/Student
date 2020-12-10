package com.nsu.web;

import com.nsu.bean.Course;
import com.nsu.bean.User;
import com.nsu.service.CourseService;
import com.nsu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author yr
 * @date 2020/11/16 9:21
 */
public class UserServlet extends BaseServlet {
    UserService userService = new UserService();
    CourseService courseService = new CourseService();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        User loginUser = userService.login(new User(id, null, password, null, null, null, null, null));
        if (loginUser == null) {
            req.setAttribute("msg", "学号或者密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            User user = userService.queryUserById(id);
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/index.jsp").forward(req,resp);
        req.getSession().invalidate();
    }

    public void updatePassword(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String password = req.getParameter("password");
        User user = (User) req.getSession().getAttribute("user");
        user.setPassword(password);
        userService.updatePassword(user.getId(), password);
        req.setAttribute("upPassword","密码修改成功！");
        req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
    }

    public void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        req.getRequestDispatcher("/pages/user/user_show.jsp").forward(req, resp);

    }

    public void showCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Course> courses = courseService.queryCourses();
        req.setAttribute("courses",courses);
        req.getRequestDispatcher("/pages/user/user_course.jsp").forward(req, resp);
    }
    public void addCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String courseName = req.getParameter("courseName");

        if ("无".equals(user.getCourse())){
            String id = req.getParameter("id");
            String remainCount = req.getParameter("remainCount");
            Integer i=Integer.parseInt(remainCount);
            if (i<1){
                req.setAttribute("upCourse","该课程已选完，请选择其他课程!");
            }else {
                //保存课程到用户表中
                userService.updateCourse(user.getId(),courseName);
                //改变session域中user课程的值
                user.setCourse(courseName);
                //改变数据库中课程剩余数量
                courseService.updateRemainCount(Integer.parseInt(id),i-1);
                req.setAttribute("upCourse","恭喜选课成功！");
            }
        }
        else {
            req.setAttribute("upCourse","你已选课不能再选了！");
        }
        req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
    }
}
