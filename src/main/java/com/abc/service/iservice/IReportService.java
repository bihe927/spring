package com.abc.service.iservice;

import com.abc.common.Res;
import com.abc.controller.vo.DeptEmpVo;
import com.abc.service.dto.EmpDto;

import java.util.List;

public interface IReportService {
    Res<List<EmpDto>> makeReportForDeptEmp(DeptEmpVo deptEmpVo);
}
