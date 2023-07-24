package com.hhcc.modules.common.utils.core.secure.provider;

public interface IClientDetailsService {
    IClientDetails loadClientByClientId(String clientId);
}
