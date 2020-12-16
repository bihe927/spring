package com.abc.dao.impl;

import com.abc.controller.vo.DeptEmpVo;
import com.abc.dao.entity.Emp;
import com.abc.dao.idao.IReportDao;
import com.abc.dao.util.DBUtil;
import com.abc.service.dto.EmpDto;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("reportDao")
public class ReportDaoImpl implements IReportDao {
    @Override
    public List<EmpDto> findbyvo(DeptEmpVo deptEmpVo) throws SQLException, ClassNotFoundException {
        Connection con = DBUtil.getConnection();
        String sql = "select e.ename,d.dname,e.sal,d.loc from emp e left join dept d on e.deptno=d.deptno where e.deptno=? and e.sal between ? and ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,deptEmpVo.getDeptno());
        ps.setBigDecimal(2,deptEmpVo.getMinsal());
        ps.setBigDecimal(3,deptEmpVo.getMaxsal());
        ResultSet rs=ps.executeQuery();
        List<EmpDto> list = new ArrayList<EmpDto>();

        while (rs.next()){
            EmpDto empDto = new EmpDto(rs.getString(1),rs.getString(2),rs.getBigDecimal(3),rs.getString(4));
            list.add(empDto);
        }
        System.out.println(list.toString());
        DBUtil.close(rs,ps,con);
        return list;
    }
}
