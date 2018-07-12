package boot.backend.mongo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import boot.backend.mongo.service.LoginUserDetailsService;




@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	private LoginUserDetailsService loginUserDetailsService;
    
    @Autowired
	private UserAuthenticationSuccessHandler successHandler;
    
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
    
     
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/api/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		/*.antMatchers("/").permitAll()*/
		//.antMatchers("/getEmployees").hasAnyRole("USER", "ADMIN")
		.antMatchers("/").hasAnyRole("USER", "ADMIN")
		.anyRequest().authenticated().and().formLogin().successHandler(successHandler)
		.loginPage("/login").permitAll().and().logout().deleteCookies("remember-me").permitAll()
		.and()
        .rememberMe()
        .and()
        .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
		http.sessionManagement()
		.maximumSessions(1)
		.expiredUrl("/login")
		.maxSessionsPreventsLogin(false);
		/*http.csrf().disable();*/
		
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    UserDetailsService userDetailsService = loginUserDetailsService;
	    auth
	        .userDetailsService(userDetailsService)
	        .passwordEncoder(bCryptPasswordEncoder);

	}
	
	
	/* @Autowired
	 public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
	 authenticationMgr
	 .inMemoryAuthentication()
	 .withUser("root").password("{noop}" + 
	 Utils.decoder(new EncryptionCodec().excuteCodec().getDataMap().get(Users.root).getBytes())).authorities("ROLE_USER").and()  //{noop}
	 .withUser("jsr").password("{noop}" + 
	 Utils.decoder(new EncryptionCodec().excuteCodec().getDataMap().get(Users.jsr).getBytes())).authorities("ROLE_USER", "ROLE_ADMIN").and()
	 .withUser("sandeep").password("{noop}" +
	 Utils.decoder(new EncryptionCodec().excuteCodec().getDataMap().get(Users.sandeep).getBytes())).authorities("ROLE_USER").and()
	 .withUser("dinesh").password("{noop}" +
	 Utils.decoder(new EncryptionCodec().excuteCodec().getDataMap().get(Users.dinesh).getBytes())).authorities("ROLE_USER").and()
	 .withUser("ranjeet").password("{noop}" +
	 Utils.decoder(new EncryptionCodec().excuteCodec().getDataMap().get(Users.ranjeet).getBytes())).authorities("ROLE_USER").and()
	 .withUser("bimlesh").password("{noop}" +
	 Utils.decoder(new EncryptionCodec().excuteCodec().getDataMap().get(Users.bimlesh).getBytes())).authorities("ROLE_USER");
	}*/
	 
	 
	
	/*@Bean
	public UserDetailsService mongoUserDetails() {
	    return new LoginUserDetailsService();
	}*/
	

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	    return bCryptPasswordEncoder;
	}


	

}