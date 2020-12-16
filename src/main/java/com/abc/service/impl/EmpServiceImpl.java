package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.controller.vo.DelVo;
import com.abc.dao.entity.Emp;
import com.abc.dao.idao.IEmpDao;
import com.abc.service.iservice.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("empService")
public class EmpServiceImpl implements IEmpService {
    @Autowired
    IEmpDao empDao;

    @Override
    public List<Emp> searchByPage(int page, int size) {
        List<Emp> emps = null;
        try {
            emps = empDao.searchByPage((page-1)*size,size);
        } catch(Exception e){
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public List<Emp> searchByName(String name) {
        List<Emp> emps = null;
        try {
            emps = empDao.searchByName(name);
        } catch(Exception e){
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public Emp searchById(Integer empno) {
        Emp emp = null;
        try {
            emp = empDao.searchById(empno);
        } catch(Exception e){
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public String delete(Emp emp) {
        String flag = Comm.ERROR;
        try {
            empDao.delete(emp);
            flag = Comm.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public String save(Emp emp) {
        String flag = Comm.ERROR;
        try {
            empDao.save(emp);
            flag = Comm.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public String update(Emp emp) {
        String flag = Comm.ERROR;
        try {
            empDao.update(emp);
            flag = Comm.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Res delBatch(List<DelVo> delVoList) {
        if (delVoList==null && delVoList.size()==0){
            return Res.error(ResEnum.ERROR_PARAMS_IN_DELBATCH);
        }
        try {
            empDao.delBatch(delVoList);
            return Res.success(ResEnum.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return Res.error(ResEnum.ERROR);
        }
    }
}
