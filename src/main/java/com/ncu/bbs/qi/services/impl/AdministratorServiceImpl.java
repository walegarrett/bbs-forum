package com.ncu.bbs.qi.services.impl;

import com.ncu.bbs.bean.Administrator;
import com.ncu.bbs.bean.AdministratorExample;
import com.ncu.bbs.dao.AdministratorMapper;
import com.ncu.bbs.qi.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@Service
@ContextConfiguration("classpath:applicationContext.xml")
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    AdministratorMapper AdministratorMapper;
    public void insertAdministrator(Administrator Administrator) {
        AdministratorMapper.insert(Administrator);
    }

    public List<Administrator> selectAllAdministrator() {
        List<Administrator> list=AdministratorMapper.selectByExample(null);
        return list;
    }

    @Override
    public Administrator checkLogin(String aAdminname, String aPassword) {
        AdministratorExample example = new AdministratorExample();
        AdministratorExample.Criteria criteria = example.createCriteria();
        criteria.andAAdminnameEqualTo(aAdminname);
        criteria.andAPasswordEqualTo(aPassword);
        long count = AdministratorMapper.countByExample(example);
        List<Administrator>list=AdministratorMapper.selectByExample(example);
        if(count==0)
        {
            return null;
        }else
        {
           Administrator administrator = new Administrator();
           administrator.setaAdminname(aAdminname);
           administrator.setaPassword(aPassword);
//        return administrator;
            return list.get(0);
        }
    }

//    /**
//     * 检验用户账号是否可用
//     * @param
//     * @return  true代表当前账号可用 false代表不可用
//     */
//    public boolean checkaAdminname(String aAdminname){
//        AdministratorExample example = new AdministratorExample();
//        AdministratorExample.Criteria criteria = example.createCriteria();
//        criteria.andAAdminnameEqualTo(aAdminname);
//        long count = AdministratorMapper.countByExample(example);
//        return count==0;
//    }
//
//    @Override
//    public boolean checkaPassword(String aAdminname,String aPassword) {
//
//        AdministratorExample example = new AdministratorExample();
//        AdministratorExample.Criteria criteria = example.createCriteria();
//        criteria.andAPasswordEqualTo(aPassword);
//        criteria.andAAdminnameEqualTo(aAdminname);
//        long count = AdministratorMapper.countByExample(example);
//        return count==0;
//    }
//
//    /**
//     * 根据管理员的账号查找一个管理员
//     * @param aAdminname
//     * @return
//     */
//    @Override
//    public Administrator getAdminByAdminname(String aAdminname) {
//        AdministratorExample administratorExample=new AdministratorExample();
//        AdministratorExample.Criteria criteria=administratorExample.createCriteria();
//        criteria.andAAdminnameEqualTo(aAdminname);
//        List<Administrator>list=AdministratorMapper.selectByExample(administratorExample);
//        if(list.size()>0){
//            return list.get(0);
//        }else return null;
//    }


}
