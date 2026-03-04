package com.chetraseng.sunrise_task_flow_api.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chetraseng.sunrise_task_flow_api.model.Task;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query("SELECT t FROM Task t WHERE t.completed = false ORDER BY t.createdAt DESC")
    List<Task> findAllIncompleteOrderedByDate();

}
