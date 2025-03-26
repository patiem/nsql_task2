package epa.patiem.task2.repository;

import epa.patiem.task2.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
