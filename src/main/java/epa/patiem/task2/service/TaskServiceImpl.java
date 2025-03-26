package epa.patiem.task2.service;

import epa.patiem.task2.model.SubTask;
import epa.patiem.task2.model.Task;
import epa.patiem.task2.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public List<Task> getOverdueTasks() {
        return List.of();
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        return List.of();
    }

    @Override
    public List<SubTask> getSubTasksByTaskCategory(String category) {
        return List.of();
    }

    @Override
    public Task saveTask(Task task) {
        task.setDateOfCreation(LocalDateTime.now());
        return repository.save(task);
    }

    @Override
    public Task updateTaskWithSubtask(String id, SubTask subTask) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("No Task with id %s", id)));
        task.addSubtask(subTask);
        return repository.save(task);
    }

    @Override
    public void deleteTask(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Task> searchByDescription(String word) {
        return List.of();
    }

    @Override
    public List<Task> searchBySubtaskName(String word) {
        return List.of();
    }
}