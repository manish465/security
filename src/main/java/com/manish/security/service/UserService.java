package com.manish.security.service;

import com.manish.security.dao.UserInfoDTO;
import com.manish.security.entity.User;
import com.manish.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String addNewUser(UserInfoDTO userInfoDTO) {

        userRepository.save(User.builder()
                        .email(userInfoDTO.getEmail())
                        .password(passwordEncoder.encode(userInfoDTO.getPassword()))
                        .name(userInfoDTO.getName())
                        .roles(userInfoDTO.getRoles())
                        .build());

        return "user added to system ";
    }
}
