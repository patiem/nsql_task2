NoSQL Training Task 2

MongoDB
Install MongoDB and use corresponding Java driver.
Create simple task manager console app. Your tasks should have the following fields:

date of creation;
deadline;
name;
description;
list of subtasks with simple structure (name/description);
category.

Provide the following operations:

Display on console all tasks. 5 points - DONE
Display overdue tasks. 5 points - DONE
Display all tasks with a specific category (query parameter). 5 points - DONE
Display all subtasks related to tasks with a specific category (query parameter). 5 points
Perform insert/update/delete of the task. 5 points -DONE
Perform insert/update/delete all subtasks of a given task (query parameter). 10 points
Support full-text search by word in the task description. 10 points - DONE
Support full-text search by a sub-task name. 5 points - DONE

For the highest score, you can try to implement DAO with any ORM solution for MongoDB (+10 bonus points).


http://localhost:8080/swagger-ui/index.html - for swagger ui