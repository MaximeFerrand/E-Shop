package ajc.sopra.eshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		return http.antMatcher("/**")
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS).permitAll()
				.antMatchers(HttpMethod.GET,"/api/auth").authenticated()
				.antMatchers(HttpMethod.POST ,"/api/user/signup").anonymous()
				.antMatchers(HttpMethod.POST ,"/api/supplier/signup").anonymous()
				.antMatchers(HttpMethod.PATCH,"/api/user/**").authenticated()
				.antMatchers(HttpMethod.POST, "/api/user/**").hasRole("USER")
				.antMatchers(HttpMethod.PATCH,"/api/supplier/**").authenticated()
				.antMatchers(HttpMethod.POST, "/api/supplier/**").hasRole("SUPPLIER")
				.antMatchers(HttpMethod.POST, "/api/order/**").hasRole("USER")
				.antMatchers(HttpMethod.POST, "/api/orderDetail/**").hasRole("USER")
				.anyRequest().hasRole("ADMIN")
				/*.anyRequest().permitAll()*/
			.and()
			.httpBasic()
			.and()
			.build();
		// @formatter:on
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
