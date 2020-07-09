package com.campus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.campus.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	User findByUsername(String username);
	
	@Query(nativeQuery = true,value = "SELECT username FROM USER WHERE role='ROLE_TEACHER'")
	List<String> findname();
	
	@Query(nativeQuery = true,value = "SELECT * FROM USER WHERE role='ROLE_STUDENT' AND username=?1 AND password=?2")
	User getUsers(String username,String password);
}
