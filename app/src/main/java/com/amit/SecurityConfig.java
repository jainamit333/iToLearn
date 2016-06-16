package com.amit;

/**
 * Created by amit on 2/6/16.
 */
public class SecurityConfig{}
//@EnableWebSecurity
//@Configuration
//@Import(SqlConfig.class)
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
//    @Autowired
//    DataSource dataSource;
//
//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
//
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("select user_name , password from users where user_name = ?")
//                .authoritiesByUsernameQuery("select user_name , password from users where user_name = ?");
//    }
//
//    @Override
//    protected void configure(HttpSecurity security) throws Exception{
//        security.authorizeRequests().antMatchers("/*").access("hasRole('ROLE_ADMIN)").anyRequest().permitAll()
//                .and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
//                .and().logout().logoutSuccessUrl("/login?logout").and().exceptionHandling().accessDeniedPage("/403").and().csrf();
//    }
//}
