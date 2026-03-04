package com.chetraseng.sunrise_task_flow_api.services;

<<<<<<< HEAD
import com.chetraseng.sunrise_task_flow_api.dto.TaskRequest;
import com.chetraseng.sunrise_task_flow_api.dto.TaskResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface TaskService {
    List<TaskResponse> findAll();
    Optional<TaskResponse> findById(Long id);
    TaskRequest create(String title, String description);
    Optional<TaskResponse> update(Long id, String title, String description);
    Optional<TaskResponse> complete(Long id);
    boolean delete(Long id);

    List<TaskResponse> findAllIncompleteOrderedByDate();
=======
import com.chetraseng.sunrise_task_flow_api.dto.TaskResponse;
import java.util.List;

public interface TaskService {
  List<TaskResponse> findAll();

  TaskResponse findById(Long id);

  TaskResponse create(String title, String description);

  TaskResponse update(Long id, String title, String description);

  TaskResponse complete(Long id);

  void delete(Long id);
>>>>>>> f2844df7839fb4f5be1fd26972c17c104c86203b
}
