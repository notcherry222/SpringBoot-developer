package me.chaelim.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.chaelim.springbootdeveloper.domain.RefreshToken;
import me.chaelim.springbootdeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    //리프레시 토큰으로 리프레시 토큰 객체를 검색해서 전달하는 메소드
    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("unexpected token"));
    }
}
