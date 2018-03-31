package com.gym.user.service.impl;

import com.gym.user.domain.entity.Role;
import com.gym.user.domain.entity.RoleName;
import com.gym.user.domain.repository.mysql.RoleRepository;
import com.gym.user.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }


    public void createAllRoles() {
        for(RoleName roleName : RoleName.values()){
            Role role = new Role(roleName);
            roleRepository.save(role);
        }
    }
}
