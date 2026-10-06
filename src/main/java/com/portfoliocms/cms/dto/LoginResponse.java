package com.portfoliocms.cms.dto;

public record LoginResponse(
        String token,
        String username
) {}
