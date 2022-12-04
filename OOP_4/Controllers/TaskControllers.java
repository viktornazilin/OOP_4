package Controllers;

import Model.Repository;
import Model.Task;

import java.util.List;

public class TaskControllers {
    private final Repository repository;

    public TaskControllers(Repository repository) {
        this.repository = repository;
    }

    public void saveTask(Task task) {
        repository.CreateTask(task);
    }

    public Task readTask(String userId) throws Exception {
        List<Task> tasks = repository.getAllTasks();
        for (Task task : tasks) {
            if (task.getId().equals(userId)) {
                return task;
            }
        }

        throw new Exception("Task not found");
    }
}