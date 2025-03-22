package br.com.freitag.taskcontrol.repository;

import br.com.freitag.taskcontrol.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
