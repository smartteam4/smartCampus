package com.campus.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.campus.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

//	//学生更改自身密码
//	@Modifying
//	@Query("update user set password=?3 where role=?0 and username=?1 and password=?2")
//	int updatePassword(String role,String username,String oldpwd,String newpwd);
}
