public class Task {

    private String title;
    private String description;
    private boolean isDone;

    public Task(String title) {
        this.title = title;
        this.isDone = false;
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.isDone = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }

    @Override
    public String toString() {
        String status = isDone ? "[✓]" : "[ ]";

        if (description != null && !description.isEmpty()) {
            return title + " " + status + "\n" + description;
        }

        return title + " " + status;
    }
}