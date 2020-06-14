package com.gms.service.auth;

import com.gms.domains.request.AccountRequest;
import com.gms.domains.response.TokenResponse;
import com.gms.entities.user.User;
import com.gms.entities.user.repository.UserRepository;
import com.gms.exceptions.UserNotFoundException;
import com.gms.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;


    @Override
    public TokenResponse signIn(AccountRequest accountRequest) {
        User user = userRepository.findByUserId(accountRequest.getUserId()).filter(u -> passwordEncoder.matches(accountRequest.getUserId(), u.getUserPw()))
                .orElseThrow(UserNotFoundException::new);

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(user.getId()))
                .build();
    }
}
