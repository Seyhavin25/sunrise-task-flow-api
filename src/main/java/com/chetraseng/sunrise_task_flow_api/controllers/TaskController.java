package com.chetraseng.sunrise_task_flow_api.controllers;

import com.chetraseng.sunrise_task_flow_api.dto.TaskRequest;
import com.chetraseng.sunrise_task_flow_api.dto.TaskResponse;
import com.chetraseng.sunrise_task_flow_api.services.TaskService;
<<<<<<< HEAD
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Data
@RequestMapping("/api/tasks")

public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<TaskResponse> findAll() {
        return this.taskService.findAll();
    }
    @PostMapping
    public ResponseEntity<TaskRequest> create(@RequestBody TaskRequest tasksRequest) {
        TaskRequest created = taskService.create(tasksRequest.getTitle(),tasksRequest.getDescription());
        return ResponseEntity.status(201).body(created);
    }
    @PutMapping("/{id}")
    public Optional<TaskResponse> update(@PathVariable long id, @RequestBody TaskRequest tasksRequest) {
        return taskService.update(id, tasksRequest.getTitle(), tasksRequest.getDescription());
    }

    @DeleteMapping("/{id}")

    public void delete(@PathVariable long id) {
            taskService.delete(id);
    }
    @PatchMapping("/{id}/complete")
    public void complete(@PathVariable long id) {
        taskService.complete(id);
    }
    @GetMapping("/incomplete")
    public ResponseEntity<List<TaskResponse>> findAllIncompleteOrderedByDate() {
        return ResponseEntity.ok(taskService.findAllIncompleteOrderedByDate());
    }

=======
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
  public TaskResponse getTaskById(@PathVariable Long id) {
    return taskService.findById(id);
  }

  @PostMapping
  public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest request) {
    TaskResponse taskResponse = taskService.create(request.getTitle(), request.getDescription());
    return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);
  }

  @PutMapping("/{id}")
  public TaskResponse updateTask(@PathVariable Long id, @RequestBody TaskRequest request) {
    return taskService.update(id, request.getTitle(), request.getDescription());
  }

  @PatchMapping("/{id}/complete")
  public TaskResponse completeTask(@PathVariable Long id) {
    return taskService.complete(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteTask(@PathVariable Long id) {
    taskService.delete(id);
  }
>>>>>>> f2844df7839fb4f5be1fd26972c17c104c86203b
}
