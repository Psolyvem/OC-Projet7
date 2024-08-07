package com.openclassrooms.pcs.repositories;

import com.openclassrooms.pcs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * Interface that let Spring implements all basic CRUD methods for accessing the users table in the database.
 * Also declares a method findByUsername() so that spring can handle request by username on that table.
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>
{
	public User findByUsername(String username);
}
