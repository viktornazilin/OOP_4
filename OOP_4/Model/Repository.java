package Model;

import java.util.List;

public interface Repository {
    List<Task> getAllTasks();
    String CreateTask(Task task);
}