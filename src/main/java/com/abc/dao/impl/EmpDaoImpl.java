package com.abc.dao.impl;

import com.abc.controller.vo.DelVo;
import com.abc.dao.entity.Emp;
import com.abc.dao.idao.IEmpDao;
import com.abc.dao.util.DBUtil;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("empDao")
public class EmpDaoImpl implements IEmpDao {

    @Override
    public List<Emp> searchByPage(int start, int size) throws SQLException, ClassNotFoundException {
        Connection con = DBUtil.getConnection();
        String sql = "SELECT empno,ename,job,mgr,hiredate,sal,comm,deptno FROM emp LIMIT ?,? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,start);
        ps.setInt(2,size);
        ResultSet set = ps.executeQuery();
        List<Emp> emps = new ArrayList<Emp>();
        while (set.next()){
            Emp emp = new Emp(set.getInt(1),set.getString(2),set.getString(3),set.getDouble(4),set.getDate(5),set.getDouble(6),set.getDouble(7),set.getInt(8));
            emps.add(emp);
        }
        DBUtil.close(set,ps,con);
        return emps;
    }

    @Override
    public List<Emp> searchByName(String ename) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "SELECT empno,ename,job,mgr,hiredate,sal,comm,deptno FROM emp where ename like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        System.out.println(ename);
        ps.setString(1,"%"+ename+"%");
        ResultSet set = ps.executeQuery();
        List<Emp> emps = new ArrayList<>();
        while (set.next()){
            Emp emp = new Emp(set.getInt(1),set.getString(2),set.getString(3),set.getDouble(4),set.getDate(5),set.getDouble(6),set.getDouble(7),set.getInt(8));
            emps.add(emp);
        }
        System.out.println(emps);
        DBUtil.close(set,ps,con);
        return emps;
    }

    @Override
    public Emp searchById(Integer empno) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "SELECT empno,ename,job,mgr,hiredate,sal,comm,deptno FROM emp where empno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,empno);
        ResultSet set = ps.executeQuery();
        Emp emp =null;
        if(set.next()){
            emp = new Emp(set.getInt(1),set.getString(2),set.getString(3),set.getDouble(4),set.getDate(5),set.getDouble(6),set.getDouble(7),set.getInt(8));
        }
        DBUtil.close(set,ps,con);
        return emp;
    }

    @Override
    public void delete(Emp emp) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "delete from emp where empno=? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,emp.getEmpno());
        ps.executeUpdate();
        DBUtil.close(null,ps,con);
    }

    @Override
    public void save(Emp emp) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "insert into emp (ename,hiredate,sal) values (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,emp.getEname());
        ps.setDate(2,new java.sql.Date(emp.getHiredate().getTime()));
        ps.setDouble(3,emp.getSal());
        ps.executeUpdate();
        DBUtil.close(null,ps,con);
    }

    @Override
    public void update(Emp emp) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "update emp set ename=?,hiredate=?,sal=? where empno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,emp.getEname());
        ps.setDate(2,new java.sql.Date(emp.getHiredate().getTime()));
        ps.setDouble(3,emp.getSal());
        ps.setInt(4,emp.getEmpno());
        ps.executeUpdate();
        DBUtil.close(null,ps,con);
    }

    @Override
    public void delBatch(List<DelVo> delVoList) throws SQLException, ClassNotFoundException {
        Connection con = DBUtil.getConnection();
        StringBuilder builder = new StringBuilder("delete from emp where empno in (");
        for (int i = 0; i < delVoList.size(); i++) {
            if (i==delVoList.size()-1){
                builder.append(delVoList.get(i).getEmpno()+")");
            }else {
                builder.append(delVoList.get(i).getEmpno()+",");
            }
        }
        String sql = builder.toString();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        DBUtil.close(null,ps,con);
    }
}
