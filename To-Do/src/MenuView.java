import java.util.List;
import java.util.Scanner;

public class MenuView {

    private Scanner scanner = new Scanner(System.in);

    public String taskMenu() {
        return """
                
                1 - Добавить задачу
                2 - Показать задачи
                3 - Удалить задачу
                4 - Отметить завершенную задачу
                0 - Выход
                
                """;
    }

    public void showTasks(List<Task> list) {
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
}
