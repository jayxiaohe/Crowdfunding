package com.atguigu.crowd.service.api;

import java.util.List;

import com.atguigu.crowd.entity.Admin;

public interface AdminService {
    
    public void saveAdmin(Admin admin);

    public List<Admin> getAll();
}
