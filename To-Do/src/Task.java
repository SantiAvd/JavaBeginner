public class Task {
    private String title;
    private String description;
    private boolean isDone;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Task(String title) {
        this.title = title;
    }

    public String toString() {
        if (description != null) {
            return title + "\n" + description;
        } else {
            return title;
        }
    }

    public boolean isDone() {
        return isDone;
    }

    public void changeDone() {
        this.isDone = true;
    }
}
