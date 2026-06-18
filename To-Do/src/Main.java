
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

   private static TaskManager taskManager = new TaskManager();
   private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            taskManager.loadFromFile();
        } catch (MyExceptionFileNotFound e) {
            System.out.println("Начнем с пустого списка");
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        while (true) {
            System.out.println(taskManager.taskMenu());

            int choice = scanner.nextInt();
            scanner.nextLine();
            try {
//                if (choice == 2) {
//                    showTasks(taskManager.getTasks());
//                }
                selectAction(choice);

            } catch (InvalinIndexAtList e) {
                System.out.println("Ошибка: " + e.getMessage());;
            } catch (IOException e) {
                System.out.println("Ошибка файла: " + e.getMessage());;
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
        System.out.println("\n0 - Выход");
        int choice = scanner.nextInt();
        scanner.nextLine();

    }

    public static void selectAction(int choice) throws IOException, InvalinIndexAtList {
        switch (choice) {
            case 0:
//                taskManager.saveToFile();
                System.out.println("Выход...");
                System.exit(0);

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

                taskManager.saveToFile();
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
                System.out.println("В списке выбора действий нет пункта - " + choice + ", максимум - 4");
                System.out.println("Попробуйте ещё раз");
        }
    }
}