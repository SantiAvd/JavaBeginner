import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

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

    public void saveToFile() {
        try (FileWriter writer = new FileWriter("tasks.txt")) {

            for (Task task : tasks) {
                String line = task.getTitle() + ";" +
                        (task.getDescription() == null ? "" : task.getDescription()) + ";" +
                        task.isDone();

                writer.write(line + "\n");
            }

            System.out.println("Задачи сохранены");

        } catch (IOException e) {
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("tasks.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                String title = parts[0];
                String description = parts[1].isEmpty() ? null : parts[1];
                boolean isDone = Boolean.parseBoolean(parts[2]);

                Task task = new Task(title, description);
                task.setDone(isDone);

                tasks.add(task);
            }

            System.out.println("Задачи загружены");

        } catch (IOException e) {
            System.out.println("Файл не найден, начинаем с пустого списка");
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
}