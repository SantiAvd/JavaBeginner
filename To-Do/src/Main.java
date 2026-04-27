import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();
        taskManager.loadFromFile();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(taskManager.taskMenu());

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 0:
                        taskManager.saveToFile();
                        System.out.println("Выход...");
                        return;

                    case 1:
                        System.out.println("Введите название задачи:");
                        String title = scanner.nextLine();

                        System.out.println("Введите описание (или оставьте пустым):");
                        String description = scanner.nextLine();

                        if (description.isEmpty()) {
                            taskManager.addTask(title);
                        } else {
                            taskManager.addTask(title, description);
                        }
                        break;

                    case 2:
                        showTasks(taskManager.getTasks());
                        break;

                    case 3:
                        System.out.println("Введите номер задачи для удаления:");
                        int removeIndex = scanner.nextInt();
                        taskManager.removeTask(removeIndex);
                        break;

                    case 4:
                        System.out.println("Введите номер выполненной задачи:");
                        int doneIndex = scanner.nextInt();
                        taskManager.markTaskAsDone(doneIndex);
                        break;

                    default:
                        throw new OutOfListindException(choice);
                }

            } catch (OutOfListindException e) {
                System.out.println(e.getMessage());
                System.out.println("Попробуйте ещё раз");
            }
        }
    }

    public static void showTasks(List<Task> list) {
        if (list.isEmpty()) {
            System.out.println("Задач пока нет!");
            return;
        }

        int index = 1;
        for (Task task : list) {
            System.out.println(index++ + " : " + task);
        }
    }
}