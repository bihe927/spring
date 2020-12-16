package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.controller.vo.DeptEmpVo;
import com.abc.dao.idao.IReportDao;
import com.abc.service.dto.EmpDto;
import com.abc.service.iservice.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("reportService")
public class ReportServiceImpl implements IReportService {

    @Autowired
    IReportDao reportDao;

    @Override
    public Res<List<EmpDto>> makeReportForDeptEmp(DeptEmpVo deptEmpVo) {
        List<EmpDto> res = null;
        try {
            res = reportDao.findbyvo(deptEmpVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (res!=null && res.size()>0){
            return Res.success(ResEnum.SUCCESS,res);
        }
        return Res.error(ResEnum.ERROR);
    }
}
