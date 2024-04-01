package org.jsp.taskproject.serviceImpl;

import org.jsp.taskproject.entity.Users;
import org.jsp.taskproject.payload.UserDto;
import org.jsp.taskproject.repository.UserRepository;
import org.jsp.taskproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Users user=userDtoToEntity(userDto);
		Users savedUser=userRepository.save(user);
		return entityToUserDto(savedUser);
	}
	private Users userDtoToEntity(UserDto userDto) {
		Users users=new Users();
		users.setName(userDto.getName());
		users.setEmail(userDto.getEmail());
		users.setPassword(userDto.getPassword());
		return users;
	}
	private UserDto entityToUserDto(Users savedUser) {
		UserDto userDto=new UserDto();
		userDto.setId(savedUser.getId());
		userDto.setEmail(savedUser.getEmail());
		userDto.setPassword(savedUser.getPassword());
		userDto.setName(savedUser.getName());
		return userDto;
	}

}
