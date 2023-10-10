package me.chaelim.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
//userDetails : 시큐리티에 사용자의인증 정보를 담아두는 인터페이스
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private long id;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "nickname", unique = true)
    private String nickname;
    @Builder
    public User(String email, String password, String nickname){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }
    @Override // 사용자의 id를 반환 (고유한 값)
    public String getUsername() {
        return email;
    }
    @Override // 계정 만료 여부 반환
    public boolean isAccountNonExpired() {
        return true; // 만료되지 않음 -> true
    }
    @Override // 계정 잠금 여부 반환
    public boolean isAccountNonLocked() {
        return true; // 잠금되지 않음 -> true
    }
    @Override // 패스워드 만료 여부 반환
    public boolean isCredentialsNonExpired() {
        return true; // 만료되지 않음 -> true
    }
    @Override // 계정 사용 가능 여부 반환
    public boolean isEnabled() {
        return true; // 사용 가능 -> true
    }
    public User update(String nickname) { //사용자 이름 변경
        this.nickname = nickname;
        return this;
    }
}
