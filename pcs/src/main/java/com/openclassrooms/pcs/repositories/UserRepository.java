package com.openclassrooms.pcs.repositories;

import com.openclassrooms.pcs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>
{
	public User findByUsername(String username);
}
