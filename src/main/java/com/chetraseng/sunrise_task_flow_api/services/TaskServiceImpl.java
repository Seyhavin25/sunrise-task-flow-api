package com.chetraseng.sunrise_task_flow_api.services;

<<<<<<< HEAD
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
=======
import com.chetraseng.sunrise_task_flow_api.dto.TaskResponse;
import com.chetraseng.sunrise_task_flow_api.exception.ResourceNotFoundException;
import com.chetraseng.sunrise_task_flow_api.mapper.TaskMapper;
import com.chetraseng.sunrise_task_flow_api.model.TaskModel;
import com.chetraseng.sunrise_task_flow_api.repository.TaskRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
  private final TaskRepository taskRepository;
  private final TaskMapper taskMapper;

  @Override
  public List<TaskResponse> findAll() {
    return taskRepository.findAll().stream().map(taskMapper::toTaskResponse).toList();
  }

  @Override
  public TaskResponse findById(Long id) {
    return taskRepository
        .findById(id)
        .map(taskMapper::toTaskResponse)
        .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
  }

  @Override
  public TaskResponse create(String title, String description) {
    TaskModel task = new TaskModel();
    task.setTitle(title);
    task.setDescription(description);
    return taskMapper.toTaskResponse(taskRepository.save(task));
  }

  @Override
  public TaskResponse update(Long id, String title, String description) {
    TaskModel task =
        taskRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    task.setTitle(title);
    task.setDescription(description);
    return taskMapper.toTaskResponse(taskRepository.save(task));
  }

  @Override
  public TaskResponse complete(Long id) {
    TaskModel task =
        taskRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    task.setCompleted(true);
    return taskMapper.toTaskResponse(taskRepository.save(task));
  }

  @Override
  public void delete(Long id) {
    if (!taskRepository.delete(id)) {
      throw new ResourceNotFoundException("Task not found with id: " + id);
    }
  }
}
>>>>>>> f2844df7839fb4f5be1fd26972c17c104c86203b
