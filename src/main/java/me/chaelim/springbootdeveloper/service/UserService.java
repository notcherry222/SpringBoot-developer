package me.chaelim.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.chaelim.springbootdeveloper.domain.User;
import me.chaelim.springbootdeveloper.dto.request.UserSignUpRequestDto;
import me.chaelim.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(UserSignUpRequestDto dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }
}
