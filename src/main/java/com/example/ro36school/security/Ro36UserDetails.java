package com.example.ro36school.security;

import com.example.ro36school.entity.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class Ro36UserDetails implements UserDetails {

    private final Student student;

    public Ro36UserDetails(Student student) {
        this.student = student;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority studentAuthority = new SimpleGrantedAuthority("STUDENT");
        return Set.of(studentAuthority);
    }

    @Override
    public String getPassword() {
        return student.getUserPassword();
    }

    //email/username cu ce se autentifica userul meu
    @Override
    public String getUsername() {
        return student.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
