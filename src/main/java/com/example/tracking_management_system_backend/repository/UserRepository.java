package com.example.tracking_management_system_backend.repository;

import com.example.tracking_management_system_backend.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User,Integer>{
    User findByNumber(int number);
    User findById(int id);
}
