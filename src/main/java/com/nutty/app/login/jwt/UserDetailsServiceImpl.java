package com.nutty.app.login.jwt;

import com.nutty.app.login.domain.User;
import com.nutty.app.login.repository.SignUpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
// userDetailsImple에 user를 넣어주는 서비스입니다.
public class UserDetailsServiceImpl implements UserDetailsService {

	private final SignUpRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {

		User account = accountRepository.findByEmail(nickname).orElseThrow(
				() -> new RuntimeException("Not Found Account")
		);

		UserDetailsImpl userDetails = new UserDetailsImpl();
		userDetails.setAccount(account);

		return userDetails;
	}
}