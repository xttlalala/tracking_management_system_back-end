package com.example.tracking_management_system_backend.service;

import com.example.tracking_management_system_backend.entity.Admin;
import com.example.tracking_management_system_backend.repository.AdminRepositpry;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Data
@Transactional
public class AdminService  {
    @Autowired
    private AdminRepositpry adminRepositpry;
    public void addAdmin(Admin admin){
        adminRepositpry.save(admin);
    }
}
