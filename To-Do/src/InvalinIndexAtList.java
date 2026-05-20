public class InvalinIndexAtList extends Exception {
    public InvalinIndexAtList(int index) {
        System.out.println("Задачи под номером - " + index + " не существует");
    }
}
