package com.hhcc.modules.common.utils.core.secure.constant;

public interface SecureConstant {
    String BASIC_HEADER_KEY = "Authorization";
    String BASIC_HEADER_PREFIX = "Basic ";
    String BASIC_HEADER_PREFIX_EXT = "Basic%20";
    String CLIENT_FIELDS = "client_id, client_secret, access_token_validity, refresh_token_validity";
    String BASE_STATEMENT = "select client_id, client_secret, access_token_validity, refresh_token_validity from blade_client";
    String DEFAULT_FIND_STATEMENT = "select client_id, client_secret, access_token_validity, refresh_token_validity from blade_client order by client_id";
    String DEFAULT_SELECT_STATEMENT = "select client_id, client_secret, access_token_validity, refresh_token_validity from blade_client where client_id = ?";
}
