package formalab.gestion.produits.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
private final String[] PUBLIC_ROUTES={
        "/api/v1/auth/**",//** means anything after the auth url
};
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().and().csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            // .antMatchers(new String[]{"/api/v1/auth/login","/api/v1/auth/register"})
            .antMatchers(PUBLIC_ROUTES).permitAll()
            //.antMatchers(ADMIN_ROUTES).hasRole("ADM")
            .anyRequest().authenticated()
            .and().httpBasic();
    }
}
