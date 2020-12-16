package com.abc.dao.util;

import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Connection;

public class DBUtilTest extends TestCase {

    @Test
    public void testGetConnection() throws Exception {
        Connection con1 = DBUtil.getConnection();
        System.out.println(DBUtil.getDs());
        System.out.println(con1);
        System.out.println("-----------------------");

        Connection con2 = DBUtil.getConnection();
        System.out.println(DBUtil.getDs());
        System.out.println(con2);
    }
}