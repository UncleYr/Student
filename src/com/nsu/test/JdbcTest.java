package com.nsu.test;

import com.nsu.utils.JdbcUtils;
import org.junit.Test;

/**
 * @author yr
 * @date 2020/11/14 11:27
 */
public class JdbcTest {
    @Test
    public void testJdbcUtils(){
        System.out.println(JdbcUtils.getConnection());
    }
}
