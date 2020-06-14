package com.gms.controllers;

import com.gms.domains.request.AccountRequest;
import com.gms.domains.response.TokenResponse;
import com.gms.service.auth.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl authService;

    @PostMapping
    public TokenResponse signIn(@RequestBody @Valid AccountRequest accountRequest) {
        return authService.signIn(accountRequest);
    }

}
