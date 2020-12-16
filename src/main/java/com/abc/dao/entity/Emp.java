package com.abc.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public class Emp {
    private int empno;
    private String ename;
    private String job;
    private double mgr;
    private Date hiredate;
    private double sal;
    private double comm;
    private int deptno;

    public Emp() {

    }

    public Emp(String ename, Date hiredate, Double sal) {
        this.ename=ename;
        this.hiredate = hiredate;
        this.sal=sal;
    }

    public Emp(int empno, String ename, Date hiredate, Double sal) {
        this.empno=empno;
        this.ename=ename;
        this.hiredate=hiredate;
        this.sal=sal;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getMgr() {
        return mgr;
    }

    public void setMgr(double mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public Emp(Integer empno, String ename, String job, double mgr, Date hiredate, double sal, double comm, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }
}
