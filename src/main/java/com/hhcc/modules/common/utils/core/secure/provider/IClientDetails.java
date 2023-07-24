package com.hhcc.modules.common.utils.core.secure.provider;

import java.io.Serializable;

public interface IClientDetails extends Serializable {
    String getClientId();

    String getClientSecret();

    Integer getAccessTokenValidity();

    Integer getRefreshTokenValidity();
}
