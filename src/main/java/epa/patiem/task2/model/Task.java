package epa.patiem.task2.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Task {
    private String id;
    private LocalDateTime dateOfCreation;
    private LocalDateTime deadline;
    private String name;
    private String description;
    private String category;
    private List<SubTask> subTasks;
}