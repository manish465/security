package com.manish.security.service;

import com.manish.security.config.jwt.JwtHelper;
import com.manish.security.dao.AuthRequest;
import com.manish.security.dao.UserInfoDTO;
import com.manish.security.entity.User;
import com.manish.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtHelper jwtHelper;
    private final AuthenticationManager authenticationManager;

    public String addNewUser(UserInfoDTO userInfoDTO) {

        userRepository.save(User.builder()
                        .email(userInfoDTO.getEmail())
                        .password(passwordEncoder.encode(userInfoDTO.getPassword()))
                        .name(userInfoDTO.getName())
                        .roles(userInfoDTO.getRoles())
                        .build());

        return "user added to system ";
    }

    public String authenticateAndGetToken(AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtHelper.generateToken(authRequest.getUsername());
        }else
            throw new UsernameNotFoundException("invalid user request !");
    }
}
