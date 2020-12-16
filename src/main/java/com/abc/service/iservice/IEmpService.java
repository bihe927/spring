package com.abc.service.iservice;

import com.abc.common.Res;
import com.abc.controller.vo.DelVo;
import com.abc.dao.entity.Emp;

import java.util.List;

public interface IEmpService {

    List<Emp> searchByPage(int page, int size);
    List<Emp> searchByName(String name);
    Emp searchById(Integer empno);
    String delete(Emp emp);
    String  save(Emp emp);
    String update(Emp emp);

    Res delBatch(List<DelVo> delVoList);
}
