package com.abc.dao.idao;

import com.abc.common.Res;
import com.abc.controller.vo.DeptEmpVo;
import com.abc.dao.entity.Emp;
import com.abc.service.dto.EmpDto;

import java.util.List;

public interface IReportDao {
    List<EmpDto> findbyvo(DeptEmpVo deptEmpVo) throws Exception;
}
