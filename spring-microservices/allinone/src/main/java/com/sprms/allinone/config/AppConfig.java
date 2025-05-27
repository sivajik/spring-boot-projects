package com.sprms.allinone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Map;

interface MyInterface {

    default void show() {
        System.out.println("Default method in interface");
    }
    static void myname() {
        System.out.println("asdas");
    }
}

@Configuration
public class AppConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        DefaultSecurityFilterChain build = httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz ->
                        authz.requestMatchers("/admin/*").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/user/*").hasAuthority("ROLE_USER")
                                .anyRequest().permitAll())
                .oauth2ResourceServer(oauth ->
                        oauth.jwt(jwt -> jwt.jwtAuthenticationConverter(converter())))
                .build();
        return null;//build;
    }

    private JwtAuthenticationConverter converter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        var grantedAuthoritiesConverter = new Object();//new AadJwtGrantedAuthoritiesConverter(Map.of("roles", ""));
        //converter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        return converter;
    }

    @Bean
    RoleHierarchy rol() {
        RoleHierarchyImpl roleHierarchy = RoleHierarchyImpl.fromHierarchy("ROLE_MGR > ROL_DADMIN \n ");
        return  roleHierarchy;
    }

}
