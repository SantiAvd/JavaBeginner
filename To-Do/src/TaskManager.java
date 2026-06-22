import java.io.*;
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

    public void removeTask(int index) throws InvalinIndexAtList {
        int i = index - 1;

        if (i < 0 || i >= tasks.size()) {
            throw new InvalinIndexAtList(i);
        }

        System.out.println("Удалена: " + tasks.get(i));
        tasks.remove(i);
    }


    public void markTaskAsDone(int index) throws InvalinIndexAtList {
        int i = index - 1;

        if (i < 0 || i >= tasks.size()) {
            throw new InvalinIndexAtList(i);
        }

        tasks.get(i).setDone(true);
        System.out.println("Задача отмечена как выполненная");
    }

    public void saveToFile() throws IOException {
        try (FileWriter writer = new FileWriter("tasks.txt")) {

            for (Task task : tasks) {
                String line = task.getTitle() + ";" +
                        (task.getDescription() == null ? "" : task.getDescription()) + ";" +
                        task.isDone();

                writer.write(line + "\n");
            }

            System.out.println("Задачи сохранены");

        }
    }

    public void loadFromFile() throws IOException, MyExceptionFileNotFound {
        File file = new File("tasks.txt");
        if (!file.exists()) {
            throw new MyExceptionFileNotFound("Файл tasks.txt не найден");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

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

        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
}