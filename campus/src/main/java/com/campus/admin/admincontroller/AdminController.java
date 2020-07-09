package com.campus.admin.admincontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.entity.User;
import com.campus.repository.UserRepository;

@RestController
@RequestMapping("/admin/user")
public class AdminController {
@Autowired
UserRepository userRepository;
@GetMapping
public List<User> findall(){
	return userRepository.findAll();
}
@GetMapping("/{username}")
public User find(@PathVariable String username) {
	return userRepository.findByUsername(username);
}
@PutMapping
public User update(
		  @RequestBody User user) {
	userRepository.findById(user.getId()).get();
	return userRepository.save(user);
}

}
