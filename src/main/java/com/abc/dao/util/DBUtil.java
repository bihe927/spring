package com.abc.dao.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    private static final DataSource ds = new ComboPooledDataSource("dao_c3p0");

    public static DataSource getDs() {
        return ds;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return ds.getConnection();
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException {
        if (rs != null) rs.close();
        if (rs != null) ps.close();
        if (con != null) con.close();
    }
}
