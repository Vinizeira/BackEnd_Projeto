package com.example.tutorialv2.service;

import com.example.tutorialv2.data.vo.v1.security.AccountCredentialsVO;
import com.example.tutorialv2.data.vo.v1.security.TokenVO;
import com.example.tutorialv2.repository.UserRepository;
import com.example.tutorialv2.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
   private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private UserRepository userRepository;

    @SuppressWarnings("rawtypes")
    public ResponseEntity signin(AccountCredentialsVO data) {
        try {
            var username = data.getUsername(); //leandro
            var password = data.getPassword(); //admin123

            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getUsername(),  data.getPassword()));
            } catch (Exception ignored){}

            var user = userRepository .findByUsername(data.getUsername());

            var tokenResponse = new TokenVO();
            if (user != null) {
                tokenResponse = tokenProvider.createAccessToken(data.getUsername(), user.getRoles());
            } else {
                throw new UsernameNotFoundException("Username " + data.getUsername() + " not found!");
            }
            return ResponseEntity.ok(tokenResponse);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadCredentialsException("Invalid username/password supplied!");
        }
    }


        public ResponseEntity refreshToken(String username, String refreshToken) {
            var user = userRepository.findByUsername(username);

            var tokenResponse = new TokenVO();
            if (user != null) {
                tokenResponse = tokenProvider.refreshToken(refreshToken);
            } else {
                throw new UsernameNotFoundException("Username" + username + "Não encontrado");
            }
            return ResponseEntity.ok(tokenResponse);
        }


}
