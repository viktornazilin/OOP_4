package View;

import Controllers.TaskControllers;
import Model.Task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ViewTask {

    private TaskControllers taskController;

    public ViewTask(TaskControllers userController) {
        this.taskController = userController;
    }

    public void run(){
        Commands com = Commands.NONE;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    String title = prompt("Название: ");
                    String description = prompt("Описание: ");
                    String fullname = prompt("Ответственный: ");
                    String date = LocalDate.now().toString();
                    String time = LocalTime.now().toString();
                    String deadline = prompt("deadline: ");
                    String level = prompt("level: ");

                    taskController.saveTask(new Task(title, description, fullname, date, time, deadline, level));
                    break;
                case READ:
                    String id = prompt("Идентификатор пользователя: ");
                    try {
                        Task task = taskController.readTask(id);
                        System.out.println(task);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}