package me.chaelim.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.chaelim.springbootdeveloper.dto.request.UserSignUpRequestDto;
import me.chaelim.springbootdeveloper.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {
    private final UserService userService;

    @PostMapping("/user")
    public String signup(UserSignUpRequestDto dto) {
        userService.save(dto);
        return "redirect/login";
    }
}