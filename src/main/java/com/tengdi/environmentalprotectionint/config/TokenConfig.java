package com.tengdi.environmentalprotectionint.config;

import com.tengdi.userauthenuuid.modules.sso.DefaultTokenManager;
import com.tengdi.userauthenuuid.modules.sso.TdTokenManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenConfig {
    @Bean("tokenManager")
    public TdTokenManager getTokenManager() {
        return  new DefaultTokenManager();
    }
}
