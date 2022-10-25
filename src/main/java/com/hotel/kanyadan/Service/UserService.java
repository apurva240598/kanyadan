package com.hotel.kanyadan.Service;

import com.hotel.kanyadan.Mapper.UserMapper;
import com.hotel.kanyadan.Model.Req.UserRequest;
import com.hotel.kanyadan.Model.Res.CommonResponse;
import com.hotel.kanyadan.Model.User;
import com.hotel.kanyadan.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public CommonResponse createUser(UserRequest userRequest) {
        User user = userRepository.findByUsername(userRequest.getUsername());
        if (user == null) {
            userRepository.save(UserMapper.mapUserRequestToUser(userRequest));
            log.info("User Created");
            return CommonResponse.builder()
                    .message("User Created")
                    .build();
        } else {
            log.info("User already exist with same username");
            return CommonResponse.builder()
                    .message("User already exist with same username")
                    .build();
        }
    }

    public CommonResponse login(UserRequest userRequest) {
        User user = userRepository.findByUsername(userRequest.getUsername());
        User password = userRepository.findByUsernameAndPassword(userRequest.getUsername(), userRequest.getPassword());
        if (user == null) {
            return CommonResponse.builder()
                    .message("User not found")
                    .statusCode("404")
                    .build();
        } else if (password == null) {
            return CommonResponse.builder()
                    .message("Invalid Password")
                    .build();
        } else {
            return CommonResponse.builder()
                    .message("Login Successfully")
                    .build();
        }

    }
}
