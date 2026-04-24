import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.logging.Logger;

class OutOfListindException extends Exception {
    private static Logger logger = Logger.getLogger("В списке нет таких пунктов");

    public OutOfListindException(int choise) {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString() + "В списке выбора действий нет пункта - " + choise + " максимум - 4");
    }
}



public class Main {

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        TaskManager taskManager = new TaskManager();
        Scanner scannerTask = new Scanner(System.in);

        while (true) {
            System.out.println(taskManager.taskMenu());
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Добавление задачи");
                    String taskTitle = scannerTask.nextLine();
                    tasks = taskManager.addTask(tasks, taskTitle);
                    break;
                case 2:
                    showTask(tasks);
                    break;
                case 3:
                    System.out.println("Введите номер удаление задачи");
                    int index = scannerTask.nextInt();
                    taskManager.removeTask(tasks,index);
                    break;
                case 4:
                    System.out.println("Введите номер завершенной задачи");
                    int ind = scannerTask.nextInt();
                    tasks = taskManager.doneTask(tasks, ind);
                    break;
                case 0:
                    return;
                default:
                    try {
                        throw new OutOfListindException(choice);
                    } catch (OutOfListindException e) {
                        System.out.println("Выбранного пункта не существует" + e.getMessage());
                    } finally {
                        System.out.println("Попробуйе еще раз");
                    }
                    break;
            }
        }
    }

    public static void showTask(List<Task> list) {
        if (list.isEmpty()) {
            System.out.println("Задач пока нет!");
        }
        int index = 1;
        for (Task task : list) {
            System.out.println(index++ + " : " + task + " " + (task.isDone() ? "[✓]" : "[]"));
        }
    }
}