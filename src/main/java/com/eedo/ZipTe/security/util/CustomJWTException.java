package com.eedo.ZipTe.security.util;

import io.jsonwebtoken.JwtException;

public class CustomJWTException extends JwtException {
    public CustomJWTException(String message) {
        super(message);
    }
}
