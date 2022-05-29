package com.ph17480.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ph17480.entity.Account;
public interface AccountRepository extends JpaRepository<Account, Integer>{
//	@Query("SELECT entity FROM accounts entity WHERE email=:email")
//	public Account finByEmail(@Param("email") String email);
}
