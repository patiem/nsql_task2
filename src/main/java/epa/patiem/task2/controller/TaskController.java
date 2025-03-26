package epa.patiem.task2.controller;

import epa.patiem.task2.model.SubTask;
import epa.patiem.task2.model.Task;
import epa.patiem.task2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAll();
    }

    @PostMapping(value = "/task")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task created = taskService.saveTask(task);
        return ResponseEntity.ok().body(created);
    }

    @PutMapping(value = "/task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody SubTask subTask) {
        Task updated = taskService.updateTaskWithSubtask(id, subTask);
        return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping(value = "/task/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().body(id);
    }

    @GetMapping(value = "/overdue")
    public List<Task> getOverdueTasks() {
        return taskService.getOverdueTasks();
    }

    @GetMapping(value = "/category/{category}")
    public List<Task> getTasksByCategory(@PathVariable String category) {
        return taskService.getTasksByCategory(category);
    }

    @GetMapping(value = "/category/subtasks/{category}")
    public List<SubTask> getSubtasksByTaskCategory(@PathVariable String category) {
        return taskService.getSubTasksByTaskCategory(category);
    }

    @GetMapping(value = "/description/{phrase}")
    public List<Task> getTasksByDescription(@PathVariable String phrase) {
        return taskService.findByDescriptionContaining(phrase);
    }

    @GetMapping(value = "/subtasks/name/{name}")
    public List<Task> getTaskBySubtaskName(@PathVariable String name) {
        return taskService.findBySubTaskNameContaining(name);
    }

}