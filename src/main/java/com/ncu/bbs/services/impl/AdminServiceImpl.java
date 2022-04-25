package com.ncu.bbs.services.impl;

import com.ncu.bbs.bean.Administrator;
import com.ncu.bbs.dao.AdministratorMapper;
import com.ncu.bbs.services.administratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements administratorService {
    @Autowired
    AdministratorMapper administratorMapper;
    public void insertAdministrator(Administrator administrator) {
        administratorMapper.insert(administrator);
    }

    public List<Administrator> selectAllAdministrator() {
        List<Administrator> list=administratorMapper.selectByExample(null);
        return list;
    }
}
