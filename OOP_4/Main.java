import Controllers.TaskControllers;
import Model.FileOperation;
import Model.FileOperationImpl;
import Model.Repository;
import Model.RepositoryFile;
import View.ViewTask;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("board.txt");
        Repository repository = new RepositoryFile(fileOperation);
        TaskControllers controller = new TaskControllers(repository);
        ViewTask view = new ViewTask(controller);
        view.run();
    }
}