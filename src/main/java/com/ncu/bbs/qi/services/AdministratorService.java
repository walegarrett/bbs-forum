package com.ncu.bbs.qi.services;

import com.ncu.bbs.bean.Administrator;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
@Service
@ContextConfiguration("classpath:applicationContext.xml")
public interface AdministratorService {
    public void insertAdministrator(Administrator administrator);
    public List<Administrator> selectAllAdministrator();
//    boolean checkaAdminname(String aAdminname);
//
//    boolean checkaPassword(String aAdminname,String aPassword);
//
//    Administrator getAdminByAdminname(String aAdminname);

    Administrator checkLogin(String aAdminname, String aPassword);
}
