package epa.patiem.task2.service;

import epa.patiem.task2.model.SubTask;
import epa.patiem.task2.model.Task;
import epa.patiem.task2.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public List<Task> getAll() {
        return repository.findAll();
    }

    @Override
    public Task getTaskById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("No Task with id %s", id)));
    }

    @Override
    public List<Task> getOverdueTasks() {
        return repository.findOverdueTasks(new Date());
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        return repository.findByCategory(category);    }

    @Override
    public List<SubTask> getSubTasksByTaskCategory(String category) {
        return repository.findByCategorySubTasks(category);
    }

    @Override
    public Task saveTask(Task task) {
        task.setDateOfCreation(LocalDateTime.now());
        return repository.save(task);
    }

    @Override
    public Task updateTaskWithSubtask(String id, SubTask subTask) {
        return repository.findAndPushSubTaskById(id, subTask);
    }

    @Override
    public void deleteTask(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Task> findByDescriptionContaining(String phrase) {
        return repository.findByDescriptionContaining(phrase);
    }

    @Override
    public List<Task> findBySubTaskNameContaining(String phrase) {
        return repository.findBySubTaskNameContaining(phrase);
    }
}