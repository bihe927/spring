package com.abc.service.dto;

import java.math.BigDecimal;
import java.util.Date;

public class EmpDto {
    private String ename;
    private String dname;
    private BigDecimal sal;
    private String loc;

    public EmpDto(String ename, String dname, BigDecimal sal, String loc) {
        this.ename = ename;
        this.dname = dname;
        this.sal = sal;
        this.loc = loc;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

}
