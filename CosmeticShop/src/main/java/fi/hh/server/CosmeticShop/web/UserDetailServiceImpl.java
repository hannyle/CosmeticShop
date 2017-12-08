package fi.hh.server.CosmeticShop.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.hh.server.CosmeticShop.domain.User;
import fi.hh.server.CosmeticShop.domain.UserRepository;
	
	@Service
	public class UserDetailServiceImpl implements UserDetailsService {
	private final UserRepository repository;
	
	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.repository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User thisUser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username,
		thisUser.getPassword(),	AuthorityUtils.createAuthorityList(thisUser.getUserRole()));
		return user;
	}
}
