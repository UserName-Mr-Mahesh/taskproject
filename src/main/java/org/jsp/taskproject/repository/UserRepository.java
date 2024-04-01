package org.jsp.taskproject.repository;

import java.util.Optional;

import org.jsp.taskproject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	Optional<Users> findByEmail(String email);

}
