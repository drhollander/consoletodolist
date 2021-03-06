import java.time.LocalDate;

public class TaskItem {
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

    public TaskItem(String title, String description, String dueDate) {
        if(title.isBlank()) {
            throw new IllegalArgumentException("A task title must be at least 1 character long");
        }

        LocalDate d;
        try {
            d = LocalDate.parse(dueDate);
        } catch(java.time.format.DateTimeParseException e) {
            throw new IllegalArgumentException("WARNING: invalid due date; task not updated");
        }

        this.title = title;
        this.description = description;
        this.dueDate = d;
        this.completed = false;
    }

    public void update(String title, String description, String dueDate) {
        if(title.isBlank()) {
            throw new IllegalArgumentException("WARNING: title must be at least 1 character long; task not updated");
        }

        LocalDate d;
        try {
            d = LocalDate.parse(dueDate);
        } catch(java.time.format.DateTimeParseException e) {
            throw new IllegalArgumentException("WARNING: invalid due date; task not updated");
        }

        this.title = title;
        this.description = description;
        this.dueDate = d;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isComplete() {
        return completed;
    }

    public void complete(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %s", dueDate, title, description);
    }
}
