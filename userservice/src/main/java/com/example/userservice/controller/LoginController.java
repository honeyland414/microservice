package com.example.userservice.controller;

import com.example.userservice.pojo.JwtToken;
import com.example.userservice.pojo.Result;
import com.example.userservice.pojo.User;
import com.example.userservice.pojo.LoginRequest;
import com.example.userservice.service.TokenService;
import com.example.userservice.service.UserService;
import com.example.userservice.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class LoginController {
    private final UserService userService;
    private final TokenService tokenService;

    public LoginController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }


    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest request) {
        Optional<User> user = userService.findByUsernamePassword(request);
        if (user.isPresent()) {
            Optional<JwtToken> optional = tokenService.getByUsername(request.getUsername());
            String token;
            if (optional.isPresent()) {
                token = optional.get().getToken();
            } else {
                token = JwtUtil.generateToken(request.getUsername());
                tokenService.createToken(request.getUsername(), token);
            }

            return Result.builder()
                    .success(true)
                    .code(20000)
                    .message("success")
                    .data(Map.of("token", token))
                    .build();
        } else {
            return Result.builder()
                    .success(false)
                    .code(404)
                    .message("account not exist!")
                    .build();
        }

    }

    @GetMapping("/info")
    public Result info(String token) {
        String username = JwtUtil.getClaimsByToken(token).getSubject();
        String url = "";

        return Result.builder()
                .code(20000)
                .data(Map.of("name", username))
                .build();
    }

    @PostMapping("/logout")
    public Result logout() {
        return Result.builder()
                .code(20000)
                .build();
    }

}
