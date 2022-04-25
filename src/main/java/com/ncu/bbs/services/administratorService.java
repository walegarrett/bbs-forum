package com.ncu.bbs.services;

import com.ncu.bbs.bean.Administrator;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

public interface administratorService {
    public void insertAdministrator(Administrator administrator);
    public List<Administrator> selectAllAdministrator();
}
