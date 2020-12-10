package com.nsu.lister;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author yr
 * @date 2020/11/19 14:07
 */
    public class SessionCounter implements HttpSessionListener {

        private static int activeSessions = 0;
        //session创建时执行
        @Override
        public void sessionCreated(HttpSessionEvent se) {
            activeSessions++;
        }
        //session销毁时执行
        @Override
        public void sessionDestroyed(HttpSessionEvent se) {
            if (activeSessions > 0){
                activeSessions--;
            }
        }
        //获取活动的session个数(在线人数)
        public static int getActiveSessions() {
            return activeSessions;
        }
    }
