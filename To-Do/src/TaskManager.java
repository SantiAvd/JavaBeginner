import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<String> arrMenu = new ArrayList<>();

    public  String taskMenu() {
        StringBuilder menu = new StringBuilder();

        arrMenu.add("1 - Добавить задачу");
        arrMenu.add("2 - Показать задачи");
        arrMenu.add("3 - Удалить задачу");
        arrMenu.add("4 - Отметить завершенную задачу");
        arrMenu.add("0 - Выход");

        for (String arr: arrMenu) {
          //  System.out.println(arr);
            menu.append(arr + "\n");
        }
        return menu.toString();
//
//
//        StringBuilder menu = new StringBuilder();
//        menu.append("\n1 - Добавить задачу\n");
//        menu.append("2 - Показать задачи\n");
//        menu.append("3 - Удалить задачу\n");
//        menu.append("4 - Отметить завершенную задачу\n");
//        menu.append("0 - Выход");
//        return ;
    }

    public List<Task> addTask(List<Task> list, String taskTitle) {
        list.add(new Task(taskTitle));
        System.out.println("Задача '" + taskTitle + "' добавлена.");
        return list;
    }

    public List<Task> addTask(List<Task> list, String taskTitle, String taskDescription)  {
        list.add(new Task(taskTitle, taskDescription));
        return list;
    }

    public List<Task> removeTask(List<Task> list, int index) {

        int i = index - 1;
        System.out.println("Задача " + list.get(i) + " удалена");
        list.remove(i);

        return list;
    }

    public List<Task> doneTask(List<Task> list, int index) {
        int i = index - 1;
        Task task = list.get(i);
        task.changeDone();
        return list;
    }
}
