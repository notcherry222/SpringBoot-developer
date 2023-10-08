package me.chaelim.springbootdeveloper.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("jwt")
public class JwtProperties {
    //JWT 생성, 유효성 검증
    private String issuer;
    private String secretKey;
}
