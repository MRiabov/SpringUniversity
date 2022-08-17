package edu.mriabov.springuniversity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().ignoringAntMatchers("/saveMsg", "/public/**","/api/**", "/data-api/**").and()
                .authorizeRequests()
                .mvcMatchers("/dashboard","/displayProfile","/updateProfile","/api/**","/data-api/**").authenticated()
                .mvcMatchers("/displayMessages","/admin/**","/springUniversity/actuator/**").hasRole("ADMIN")
                .mvcMatchers("/student/**").hasRole("STUDENT")
                .mvcMatchers("/home", "/holidays/**", "/contact", "/error",
                        "/saveMsg", "/courses", "/about", "/login", "/public/**","/profile/**").permitAll()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
                .and().httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
