package com.xwrokz.service.impl;

import com.xwrokz.dto.UserDTO;
import com.xwrokz.repositpry.UserRepository;
import com.xwrokz.repositpry.impl.UserRepositoryImpl;
import com.xwrokz.service.UserService;

public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl() {
        userRepository = new UserRepositoryImpl();
    }
    public boolean validateAndAddInfo(UserDTO dto) {

        System.out.println("service validation layer ");
        if (dto != null) {
            userRepository.addUserInfo(dto);
            return true;
        }
        return false;
    }
}
