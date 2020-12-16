package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.SpringIOC;
import com.abc.dao.entity.Emp;
import com.abc.dao.idao.IEmpDao;
import com.abc.dao.util.DBUtil;
import com.abc.service.iservice.IEmpService;
import junit.framework.TestCase;
import org.hamcrest.core.CombinableMatcher;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class EmpServiceImplTest extends TestCase {

    public void testSearchByPage() {
        try {
            Connection con = DBUtil.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        IEmpService iEmpService = (IEmpService) SpringIOC.getSpringIoc().getBean("empService");
        List<Emp> emps = iEmpService.searchByPage(1,5);
        Iterator<Emp> iterator = emps.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getEname());
        }


    }
}