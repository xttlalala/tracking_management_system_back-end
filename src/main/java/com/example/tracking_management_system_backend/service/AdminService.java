package com.example.tracking_management_system_backend.service;

import com.example.tracking_management_system_backend.entity.Admin;
import com.example.tracking_management_system_backend.entity.Manager;
import com.example.tracking_management_system_backend.entity.User;
import com.example.tracking_management_system_backend.repository.AdminRepositpry;
import com.example.tracking_management_system_backend.repository.ManagerRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@Data
@Transactional
public class AdminService  {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AdminRepositpry adminRepositpry;
    @Autowired
    private ManagerRepository managerRepository;

    public void addAdmin(Admin admin){
        adminRepositpry.save(admin);
    }
    public void addManager(Manager manager){
//        if(managerRepository.findByNumber(manager.getUser().getNumber())==null){
//            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
//        }
        User u = manager.getUser();
        u.setPassword(encoder.encode(String.valueOf(manager.getUser().getNumber())));
        u.setRole(User.Role.MANAGER);
        log.debug("{}",manager);
        managerRepository.save(manager);
    }

}
