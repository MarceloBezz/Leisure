package org.deem.project.leisure.Config;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;



import org.deem.project.leisure.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Lazy
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

    //@Bean
    //public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    @Override
	protected void configure(HttpSecurity http) throws Exception{
         http
        .authorizeRequests()
        .antMatchers("/leisure/index","/leisure/**", "/static/**", "/usuario/cadastrar","/usuario/cadastrar**").permitAll()
        .and()
        .authorizeRequests()
        .antMatchers(GET,"/adm/**").hasAnyAuthority("ROLE_ADMIN")
        .antMatchers(POST,"/adm/**").hasAnyAuthority("ROLE_ADMIN")
        .antMatchers(POST,"/usuario/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
        .antMatchers(GET,"/usuario/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
        .anyRequest().permitAll()
        .and()
        .httpBasic()  
        .and()
        .formLogin()
        .defaultSuccessUrl("/usuario/perfil", true)
        .loginPage("/leisure/login").permitAll()
        .and()
        .logout()
        .invalidateHttpSession(true)
        .logoutRequestMatcher(new AntPathRequestMatcher("/usuario/logout"))
        .logoutSuccessUrl("/leisure/index")
        .and()
        .csrf().disable();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    	auth.authenticationProvider(authenticationProvider());
    }
    
    

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
}
