package com.chetraseng.sunrise_task_flow_api.services;

import com.chetraseng.sunrise_task_flow_api.Respository.TaskRepository;
import com.chetraseng.sunrise_task_flow_api.dto.TaskRequest;
import com.chetraseng.sunrise_task_flow_api.dto.TaskResponse;
import com.chetraseng.sunrise_task_flow_api.mapper.TaskMapper;
import com.chetraseng.sunrise_task_flow_api.model.Task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper TaskMapper;

    @Override
    public List<TaskResponse> findAll() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(TaskMapper::tasks).toList();
    }

    @Override
    public Optional<TaskResponse> findById(Long id) {
        return taskRepository.findById(id)
                .map(TaskMapper::tasks);
    }

    @Override
    public TaskRequest create(String title, String description) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        Task savedTask = taskRepository.save(task);
        return TaskMapper.taskRequest(savedTask);
    }

    @Override
    public Optional<TaskResponse> update(Long id, String title, String description) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(title);
                    task.setDescription(description);
                    Task updatedTask = taskRepository.save(task);
                    return TaskMapper.tasks(updatedTask);
                });
    }

    @Override
    public Optional<TaskResponse> complete(Long id) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setCompleted(true);
                    Task completedTask = taskRepository.save(task);
                    return TaskMapper.tasks(completedTask);
                });
    }

    @Override
    public boolean delete(Long id) {
        if (!taskRepository.existsById(id)) {
            return false;
        }
        taskRepository.deleteById(id);
        return true;
    }
    @Override
    public List<TaskResponse> findAllIncompleteOrderedByDate() {
        return taskRepository.findAllIncompleteOrderedByDate()
                .stream()
                .map(TaskMapper::tasks)
                .toList();
    }
}