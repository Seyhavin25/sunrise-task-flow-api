package com.chetraseng.sunrise_task_flow_api.services;

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
}
