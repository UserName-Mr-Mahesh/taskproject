package org.jsp.taskproject.repository;

import java.util.List;

import org.jsp.taskproject.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findAllByUsersId(long userid);

}
