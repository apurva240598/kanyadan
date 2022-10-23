package com.hotel.kanyadan.Mapper;

import com.hotel.kanyadan.Model.Req.UserRequest;
import com.hotel.kanyadan.Model.Res.UserResponse;
import com.hotel.kanyadan.Model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public User mapUserRequestToUser(UserRequest userRequest){
        return User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .phone(userRequest.getPhone())
                .build();
    }

    public UserResponse mapUserToUserResponse(User user){
        return UserResponse.builder()
                .username(user.getUsername())
                .build();
    }
}
