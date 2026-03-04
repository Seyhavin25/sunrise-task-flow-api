package com.chetraseng.sunrise_task_flow_api.controllers;

import com.chetraseng.sunrise_task_flow_api.dto.TaskRequest;
import com.chetraseng.sunrise_task_flow_api.dto.TaskResponse;
import com.chetraseng.sunrise_task_flow_api.services.TaskService;
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

}
