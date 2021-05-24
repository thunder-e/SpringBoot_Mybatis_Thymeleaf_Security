package com.sw.s1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration //설정 파일입니다
@EnableWebSecurity //security를 활성화할게요
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// Security를 무시하는 경로 설정
		web.ignoring()
		   .antMatchers("/resources/**")
		   .antMatchers("/images/**")
		   .antMatchers("/css/**")
		   .antMatchers("/js/**")
		   .antMatchers("/vendor/**")
		   .antMatchers("/favicon/**")
		   ;
	
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 로그인(인증요청) 없이 바로 가고싶을 때, permitAll()
		http
			.authorizeRequests()
				.antMatchers("/")
				.permitAll()		// 누구나 허용
				.antMatchers("/notice/list", "/notice/select").permitAll()
				.antMatchers("/notice/**").hasRole("ADMIN")
				.anyRequest().authenticated() // 그이외 어떤 요청이든 인증이 필요합니다
//				.antMatchers("/member")
//				.authenticated()	// 로그인한 유저만 허용
//				.antMatchers("/admin")
//				.hasRole("ADMIN")	// 로그인한 유저 중 role이 ADMIN만 허용
				;
	
	
	
	
	
	}
	
	
}
