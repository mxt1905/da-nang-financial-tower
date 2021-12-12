package com.uit.danangfinancialtower.constants;

/**
 * SecurityConst
 */
public final class SecurityConst {

    private SecurityConst() {
    }

    public static final String LOGIN_PAGE = "/login";
    public static final String DEFAULT_SUCCESS_URL = "/index";
    public static final Integer TOKEN_VALIDATION_DURATION = 21;
    public static final String TOKEN_VALIDATION_KEY = "somethingverysecured";
    public static final String DEFAULT_LOGOUT_SUCCESS_URL = "/login";
}
