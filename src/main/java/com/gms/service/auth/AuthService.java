package com.gms.service.auth;

import com.gms.domains.response.TokenResponse;
import com.gms.domains.request.AccountRequest;

public interface AuthService {
    TokenResponse signIn(AccountRequest accountRequest);
}
