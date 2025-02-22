package com.craig.test3it.springboot.app.springboot_test3it.security;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;

public class TokenJwtConfig {

    public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
    public static final String PREFIX_TOKEN = "Bearer ";
    public static final String HEADER_AUTHOTIZATION = "Authorization";
    public static final String  CONTENT_TYPE = "application/json";

}
