package com.abc.controller;

import com.abc.dao.util.DBUtil;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = DBUtil.getConnection();
        String sql = "call proc_transfer_money(?,?,?)";
        CallableStatement cs = con.prepareCall(sql);
        cs.setString(1,"MARTIN");
        cs.setString(2,"JONES");
        cs.setBigDecimal(3,new BigDecimal("1000"));
        cs.executeUpdate();
        DBUtil.close(null,cs,con);
    }
}
