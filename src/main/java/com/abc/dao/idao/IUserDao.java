package com.abc.dao.idao;

import com.abc.dao.entity.User;

import java.sql.SQLException;

public interface IUserDao {
    int exist(String username) throws Exception;
    User login(String username, String password) throws Exception;
}
