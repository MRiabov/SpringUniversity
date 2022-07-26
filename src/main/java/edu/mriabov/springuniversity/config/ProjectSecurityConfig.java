package edu.mriabov.springuniversity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> {try {auth
                                .antMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                                .antMatchers("/notices", "/contact").permitAll()
                                .and().formLogin().loginPage("/login")
                                .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
                                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
        ).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("12345").roles("USER")
                .and()
                .withUser("admin").password("54321").roles("ADMIN")
                .and().passwordEncoder(NoOpPasswordEncoder.getInstance());

    }
}
