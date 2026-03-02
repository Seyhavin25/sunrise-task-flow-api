package com.chetraseng.sunrise_task_flow_api.controllers;

import com.chetraseng.sunrise_task_flow_api.dto.TaskRequest;
import com.chetraseng.sunrise_task_flow_api.dto.TaskResponse;
import com.chetraseng.sunrise_task_flow_api.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {
  private final TaskService taskService;

  @GetMapping
  public List<TaskResponse> getAllTask(@RequestParam(required = false) Boolean completed) {
    return taskService.findAll().stream()
        .filter(t -> completed == null || completed.equals(t.getCompleted()))
        .toList();
  }

  @GetMapping("/{id}")
  public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id) {
    return taskService
        .findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest request) {
    TaskResponse taskResponse = taskService.create(request.getTitle(), request.getDescription());
    return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);
  }

  @PutMapping("/{id}")
  public ResponseEntity<TaskResponse> updateTask(
          @PathVariable Long id,
          @RequestBody TaskRequest request) {
    Optional<TaskResponse> response = taskService.update(id, request.getTitle(), request.getDescription());
    return response.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PatchMapping("/{id}/complete")
  public ResponseEntity<TaskResponse> completeTask(@PathVariable Long id) {
    return taskService.complete(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
    if (taskService.delete(id)) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
