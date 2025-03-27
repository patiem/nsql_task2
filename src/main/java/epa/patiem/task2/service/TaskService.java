package epa.patiem.task2.service;

import epa.patiem.task2.model.SubTask;
import epa.patiem.task2.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAll();
    Task getTaskById(String id);
    List<Task> getOverdueTasks();
    List<Task> getTasksByCategory(String category);
    List<Task> getSubTasksByTaskCategory(String category);

    Task saveTask(Task task);
    void updateTaskWithSubtask(String id, SubTask subTask);
    void deleteTask(String id);

    List<Task> findByDescriptionContaining(String phrase);
    List<Task> findBySubTaskNameContaining(String phrase);
}