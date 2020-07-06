package com.example.tracking_management_system_backend.interceptor;

import com.example.tracking_management_system_backend.component.RequestComponent;
import com.example.tracking_management_system_backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Autowired
    private RequestComponent requestComponent;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(requestComponent.getRole()!= User.Role.ADMIN){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"无权限");
        }
        return true;
    }
}
