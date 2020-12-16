package com.abc.dao.idao;

import com.abc.controller.vo.DelVo;
import com.abc.dao.entity.Emp;

import java.sql.SQLException;
import java.util.List;

public interface IEmpDao{

    List<Emp> searchByPage(int page, int size) throws Exception;
    List<Emp> searchByName(String ename) throws Exception;
    Emp searchById(Integer empno) throws Exception;
    void delete(Emp emp) throws Exception;
    void save(Emp emp) throws Exception;
    void update(Emp emp) throws Exception;

    void delBatch(List<DelVo> delVoList) throws SQLException, ClassNotFoundException;
}
