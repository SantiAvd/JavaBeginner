import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks = new ArrayList<>();

    public String taskMenu() {
        return """
                1 - Добавить задачу
                2 - Показать задачи
                3 - Удалить задачу
                4 - Отметить завершенную задачу
                0 - Выход
                """;
    }

    public void addTask(String title) {
        tasks.add(new Task(title));
        System.out.println("Задача добавлена");
    }

    public void addTask(String title, String description) {
        tasks.add(new Task(title, description));
        System.out.println("Задача добавлена");
    }

    public void removeTask(int index) {
        int i = index - 1;

        if (i < 0 || i >= tasks.size()) {
            System.out.println("Неверный индекс");
            return;
        }

        System.out.println("Удалена: " + tasks.get(i));
        tasks.remove(i);
    }

    public void markTaskAsDone(int index) {
        int i = index - 1;

        if (i < 0 || i >= tasks.size()) {
            System.out.println("Неверный индекс");
            return;
        }

        tasks.get(i).setDone(true);
        System.out.println("Задача отмечена как выполненная");
    }

    public List<Task> getTasks() {
        return tasks;
    }
}