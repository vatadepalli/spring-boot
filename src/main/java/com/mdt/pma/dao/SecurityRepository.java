package com.mdt.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.mdt.pma.entities.UserAccount;

public interface SecurityRepository extends CrudRepository<UserAccount, Long>{

}
