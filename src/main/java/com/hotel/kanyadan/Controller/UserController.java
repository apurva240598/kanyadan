package com.hotel.kanyadan.Controller;

import com.hotel.kanyadan.Model.Req.UserRequest;
import com.hotel.kanyadan.Model.Res.CommonResponse;
import com.hotel.kanyadan.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*" , maxAge = 3600)
@RestController
@RequestMapping("api/v1/users")
@Api(value="User Controller")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    @ApiOperation(value="Create User")
    public CommonResponse createUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }

    @PostMapping("login")
    @ApiOperation(value="Login")
    public CommonResponse login(@RequestBody UserRequest userRequest){
        return userService.login(userRequest);
    }

}
