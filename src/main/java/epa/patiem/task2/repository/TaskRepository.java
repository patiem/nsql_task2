package epa.patiem.task2.repository;

import epa.patiem.task2.model.SubTask;
import epa.patiem.task2.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.Date;
import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {

    List<Task> findByCategory(String category);

    @Query(value = "{'category': {$eq: ?0}}", fields = "subTasks")
    List<SubTask> findByCategorySubTasks(String category);

    @Update("{ '$push' : { 'subTasks' : ?1 } }")
    Task findAndPushSubTaskById(String id, SubTask subTask);

    @Query("{'deadline': {$lt: ?0}}")
    List<Task> findOverdueTasks(Date currentDate);

    @Query("{'description': {$regex: ?0, $options: 'i'}}")
    List<Task> findByDescriptionContaining(String text);

    @Query("{'subTasks.name': {$regex: ?0, $options: 'i'}}")
    List<Task> findBySubTaskNameContaining(String name);
}
