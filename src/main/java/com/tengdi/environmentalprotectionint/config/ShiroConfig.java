
package com.tengdi.environmentalprotectionint.config;

import com.tengdi.userauthenuuid.modules.auth.shiro.UserRealm;
import com.tengdi.userauthenuuid.modules.auth.shiro.jwt.JWTFilter;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro的配置文件
 *
 * @author Mark sunlightcs@gmail.com
 * @since 3.0.0 2017-09-27
 */
@Configuration
public class ShiroConfig {

    @Bean("jwtFilter")
    public JWTFilter getJWTFilter() {
        return new JWTFilter();
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager getManager(UserRealm userRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        // 使用自己的realm
        manager.setRealm(userRealm);
        return manager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean factory(DefaultWebSecurityManager securityManager,JWTFilter jwtFilter) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);

//        factoryBean.setLoginUrl("/front/start/index.html");
//        factoryBean.setUnauthorizedUrl("/");

        // 添加自己的过滤器并且取名为jwt
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("jwt", jwtFilter);
        factoryBean.setFilters(filterMap);

        Map<String, String> filterRuleMap = new LinkedHashMap<>();
        // 所有请求通过我们自己的JWT Filter
        filterRuleMap.put("/**", "jwt");
//        Map<String, String> filterRuleMap = new LinkedHashMap<>();
//        filterRuleMap.put("/swagger/**", "anon");
//        filterRuleMap.put("/v2/api-docs", "anon");
//        filterRuleMap.put("/swagger-ui.html", "anon");
//        filterRuleMap.put("/webjars/**", "anon");
//        filterRuleMap.put("/swagger-resources/**", "anon");
//
//        filterRuleMap.put("/statics/**", "anon");
//        filterRuleMap.put("/front/**", "anon");
//        filterRuleMap.put("/front/start/index.html", "anon");
//        filterRuleMap.put("/sys/login", "anon");
//        filterRuleMap.put("/favicon.ico", "anon");
//        filterRuleMap.put("/captcha.jpg", "anon");
//        filterRuleMap.put("/**", "authc");
//
//        filterRuleMap.put("/druid","anon");
        factoryBean.setFilterChainDefinitionMap(filterRuleMap);
        return factoryBean;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        // 强制使用cglib，防止重复代理和可能引起代理出错的问题
        // https://zhuanlan.zhihu.com/p/29161098
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(org.apache.shiro.mgt.SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
