package com.campus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.entity.Student;
import com.campus.entity.Teacher;
import com.campus.entity.User;
import com.campus.repository.StudentRepository;
import com.campus.repository.TeacherRepository;
import com.campus.repository.UserRepository;

@RestController
public class TestController {

	@Autowired
	TeacherRepository teacherRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/init")
	public void init() {
		List<Teacher> teacherList = teacherRepository.findAll();
		List<Student> studentList = studentRepository.findAll();
		List<User> userList = new ArrayList<>();
		for (Student s : studentList) {
			User user = new User();
			user.setUsername(s.getId());
			user.setPassword(s.getId());
			user.setRole("ROLE_STUDENT");
			user.setStatus(true);
			userList.add(user);
		}
		for (Teacher s : teacherList) {
			User user = new User();
			user.setUsername(s.getId());
			user.setPassword(s.getId());
			user.setRole("ROLE_TEACHER");
			user.setStatus(true);
			userList.add(user);
		}
		userRepository.saveAll(userList);
	}
	
}
