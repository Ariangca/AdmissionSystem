package com.aripoo.admission_system.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/","/index","/css/*","/js/*").permitAll()
                .antMatchers("/course_list","/course_info/**").hasAuthority(ApplicationUserPermission.COURSE_READ.getPermission())
                .antMatchers("/course_add","/course_delete","/course_edit/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
                .antMatchers("/result_list").hasAuthority(ApplicationUserPermission.RESULT_READ.getPermission())
                .antMatchers("/result_add","/result_delete","/result_edit/**").hasAuthority(ApplicationUserPermission.RESULT_WRITE.getPermission())
                .antMatchers("/student_list").hasAuthority(ApplicationUserPermission.STUDENT_READ.getPermission())
                .antMatchers("/student_add","/student_delete","/student_edit/**").hasAuthority(ApplicationUserPermission.STUDENT_WRITE.getPermission())
                .antMatchers("/teacher_list").hasAuthority(ApplicationUserPermission.TEACHER_READ.getPermission())
                .antMatchers("/teacher_add","/teacher_delete","/teacher_edit/**").hasAuthority(ApplicationUserPermission.TEACHER_WRITE.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .failureUrl("/login_error")
                .defaultSuccessUrl("/",true)
                .and()
                .logout().permitAll()
                .logoutSuccessUrl("/")
        ;
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails studentUser=User.builder()
                .username("student")
                .password(passwordEncoder.encode("student"))
//                .roles(ApplicationUserRole.STUDENT.name()) // ROLE_STUDENT
                .authorities(ApplicationUserRole.STUDENT.getGrantedAuthorities())
                .build();

        UserDetails teacherUser=User.builder()
                .username("teacher")
                .password(passwordEncoder.encode("teacher"))
//                .roles(ApplicationUserRole.TEACHER.name()) // ROLE_TEACHER
                .authorities(ApplicationUserRole.TEACHER.getGrantedAuthorities())
                .build();

        UserDetails arUser=User.builder()
                .username("ar")
                .password(passwordEncoder.encode("ar"))
//                .roles(ApplicationUserRole.ADMIN.name()) // ROLE_ADMIN
                .authorities(ApplicationUserRole.ADMIN.getGrantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(
                studentUser,
                teacherUser,
                arUser
        );
    }
}
