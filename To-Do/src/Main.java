
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

   private static final TaskManager taskManager = new TaskManager();
   private static final Scanner scanner = new Scanner(System.in);
   private static final MenuView menu = new MenuView();

    public static void main(String[] args) {

        if (taskManager.fileExist()) {
            try {
                taskManager.loadFromFile();
            } catch (IOException e) {
                System.out.println("Ошибка файл : " + e.getMessage());
            }
        } else {
            System.out.println("Начнем с пустого списка");
        }

        while (true) {
            System.out.println(menu.taskMenu());

            int choice = scanner.nextInt();
            scanner.nextLine();
            try {
                selectAction(choice);
            } catch (InvalinIndexAtList e) {
                System.out.println("Ошибка: " + e.getMessage());;
            } catch (IOException e) {
                System.out.println("Ошибка файла: " + e.getMessage());
            }
        }
    }

    public static void selectAction(int choice) throws IOException, InvalinIndexAtList {
        switch (choice) {
            case 0:
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
                menu.showTasks(taskManager.getTasks());
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