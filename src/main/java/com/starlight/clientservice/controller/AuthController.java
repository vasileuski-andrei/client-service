package com.starlight.clientservice.controller;

import com.starlight.clientservice.dto.AuthRequestDto;
import com.starlight.clientservice.security.JwtTokenProvider;
import com.starlight.clientservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDto requestDto) {

        try {

            String userEmail = requestDto.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEmail, requestDto.getPassword()));
            userService.findByEmail(userEmail);
            String token = jwtTokenProvider.createToken(userEmail);
            log.info("Token created.");
            Map<Object, Object> credentialsResponse = new HashMap<>();
            credentialsResponse.put("email", userEmail);
            credentialsResponse.put("token", token);

            return ResponseEntity.ok(credentialsResponse);

        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid data", HttpStatus.FORBIDDEN);
        }

    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);

    }

}
