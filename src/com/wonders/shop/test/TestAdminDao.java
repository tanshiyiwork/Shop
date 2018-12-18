package com.wonders.shop.test;

import com.wonders.shop.common.AdminDao;
import com.wonders.shop.entity.AdminEntity;

public class TestAdminDao {

    public static void main(String[] args) {
        addAdmin();
    }
    public static void addAdmin(){
        AdminDao adminDao=new AdminDao();
        AdminEntity admin=new AdminEntity();
        admin.setStName("≤‚ ‘1");
        admin.setStPwd("123");
        boolean isSuccess=adminDao.addAdmin(admin);
        System.out.println(isSuccess);
    }
}
