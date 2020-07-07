package com.example.tracking_management_system_backend.controller;

import com.example.tracking_management_system_backend.component.RequestComponent;
import com.example.tracking_management_system_backend.entity.Manager;
import com.example.tracking_management_system_backend.repository.ManagerRepository;
import com.example.tracking_management_system_backend.service.AdminService;
import com.example.tracking_management_system_backend.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private RequestComponent requestComponent;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ManagerRepository managerRepository;

    @PostMapping("addManager")
    public Map addManager(@RequestBody Manager m){
        adminService.addManager(m);
        return Map.of("managers",adminService.getManagers());
    }
    @GetMapping("getManagers")
    public Map getManagers(){
        return Map.of("managers",adminService.getManagers());
    }
    @PostMapping("deleteManager")
    public Map deleteManager(@RequestBody Manager m){
        adminService.deleteManager(m.getId());
        return Map.of("managers",adminService.getManagers());
    }
}
