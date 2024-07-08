package com.VeeraJayathK.AMS_SpringBoot.services;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.VeeraJayathK.AMS_SpringBoot.entities.Admin;
import com.VeeraJayathK.AMS_SpringBoot.entities.Manager;
import com.VeeraJayathK.AMS_SpringBoot.exceptions.ManagerIsNotApprovedException;
import com.VeeraJayathK.AMS_SpringBoot.repositories.AdminRepository;
import com.VeeraJayathK.AMS_SpringBoot.repositories.ManagerRepository;

@Service
public class AuthServiceImpl implements UserDetailsService {

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private AdminRepository adminRepository;

	//Getting User Object by ID
	@Override
	public UserDetails loadUserByUsername(String signInId) throws UsernameNotFoundException {
		Optional<Manager> manager = managerRepository.findById(signInId);
		Optional<Admin> admin = adminRepository.findById(signInId);
		Admin ad = admin.orElse(null);
		Manager ma = manager.orElse(null);
		if(ad!=null)
			return adminFunction(ad);
		else if(ma!=null)
			return managerFunction(ma);

		return null;
	}

	//If user is admin
	public UserDetails adminFunction(Admin ad) {
		Set<GrantedAuthority> authorities = ad
				.getRoles()
				.stream()
				.map((role) -> new SimpleGrantedAuthority(role)).collect(Collectors.toSet());

		return new org.springframework.security.core.userdetails.User(ad.getVendorId(),
				ad.getPassword(),
				authorities);
	}

	//If user is Manager
	public UserDetails managerFunction(Manager ma) {

		//Checking for Manager Status
		if(ma.getStatus().equals("Approved")){
			Set<GrantedAuthority> authorities = ma
					.getRoles()
					.stream()
					.map((role) -> new SimpleGrantedAuthority(role)).collect(Collectors.toSet());

			return new org.springframework.security.core.userdetails.User(ma.getManagerId(),
					ma.getPassword(),
					authorities);
		}

		else {
			//System.out.println("You are no approved by the admin");
			throw new ManagerIsNotApprovedException();
		}
	}
}
