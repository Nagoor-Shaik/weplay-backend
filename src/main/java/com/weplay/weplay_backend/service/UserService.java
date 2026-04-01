package com.weplay.weplay_backend.service;

import com.weplay.weplay_backend.JwtUtil;
import com.weplay.weplay_backend.model.User;
import com.weplay.weplay_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return "Email already registered";
        }
        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );
        userRepository.save(user);
        return "User registered successfully";
    }

    public String loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return "User not found";
        }
        if (!passwordEncoder.matches(password,
                user.getPassword())) {
            return "Invalid password";
        }
        return jwtUtil.generateToken(email);
    }
}
