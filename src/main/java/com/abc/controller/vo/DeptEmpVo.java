package com.abc.controller.vo;

import java.math.BigDecimal;

public class DeptEmpVo {
    private int deptno;
    private BigDecimal minsal;
    private BigDecimal maxsal;

    public DeptEmpVo(int deptno, BigDecimal minsal, BigDecimal maxsal) {
        this.deptno = deptno;
        this.minsal = minsal;
        this.maxsal = maxsal;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public BigDecimal getMinsal() {
        return minsal;
    }

    public void setMinsal(BigDecimal minsal) {
        this.minsal = minsal;
    }

    public BigDecimal getMaxsal() {
        return maxsal;
    }

    public void setMaxsal(BigDecimal maxsal) {
        this.maxsal = maxsal;
    }
}
