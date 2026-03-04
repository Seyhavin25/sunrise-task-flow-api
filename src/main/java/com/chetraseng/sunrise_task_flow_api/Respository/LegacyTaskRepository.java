package com.chetraseng.sunrise_task_flow_api.Respository;

import com.chetraseng.sunrise_task_flow_api.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class LegacyTaskRepository {
    private Map<Long, Task> tasks = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong(1);

    public List<Task> findAll() {
        return tasks.values().stream().toList();
    }

    public Task save(Task task) {
        if (task.getId() == null) {
            long id = counter.incrementAndGet();
            task.setId(id);
        }

        tasks.put(task.getId(), task);

        return task;
    }

    public Boolean delete(Long id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            return true;
        }

        return false;
    }

    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(tasks.get(id));
    }

    public void deleteById(Long id) {
    }
}