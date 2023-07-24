package com.hhcc.modules.common.utils.core.secure;

import lombok.Data;

@Data
public class TokenInfo {
    private String token;
    private int expire;
}
