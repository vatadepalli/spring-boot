package com.mdt.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdt.pma.dao.SecurityRepository;
import com.mdt.pma.entities.UserAccount;

@Service
public class SecurityService {
	
	@Autowired
	SecurityRepository secRepo;

	public UserAccount save(UserAccount userAccount) {
		return secRepo.save(userAccount);
	}
	
}
