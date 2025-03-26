package epa.patiem.task2.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "tasks")
public class Task {
    @Id
    private String id;
    private LocalDateTime dateOfCreation;
    private LocalDateTime deadline;
    private String name;
    private String description;
    private String category;
    private List<SubTask> subTasks;

    public boolean addSubtask(SubTask subTask) {
        return subTasks.add(subTask);
    }
}