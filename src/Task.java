import java.time.LocalDate;

public class Task {
    private final String name;
    private final TaskTypes type;

    private final String description;

    private final float estimatedTime;

    private float completionTime;

    private boolean isFinished;

    private final LocalDate deadline;

    private LocalDate finishedAt;

    private final LocalDate createdAt;


    public Task(String name, String type, String description, float estimatedTime, int year, int month, int day) {
        this.name = name;
        this.type = convertStringToTaskType(type);
        this.description = description;
        this.estimatedTime = estimatedTime;
        this.isFinished = false;
        this.deadline = LocalDate.of(year, month, day);
        this.createdAt = LocalDate.now();
    }

    public Task(String name, TaskTypes type, String description, float estimatedTime, float completionTime, boolean isFinished, LocalDate deadline, LocalDate finishedAt, LocalDate createdAt) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.estimatedTime = estimatedTime;
        this.completionTime = completionTime;
        this.isFinished = isFinished;
        this.deadline = deadline;
        this.finishedAt = finishedAt;
        this.createdAt = createdAt;
        // todo read from db
    }

    private TaskTypes convertStringToTaskType(String type) {
        return switch (type.toUpperCase()) {
            case "WORK" -> TaskTypes.WORK;
            case "HOME" -> TaskTypes.HOME;
            case "HOBBY" -> TaskTypes.HOBBY;
            case "SCHOOL" -> TaskTypes.SCHOOL;
            default -> throw new IllegalArgumentException("Invalid task type: " + type);
        };
    }

    public void finish(float completionTime){
        this.isFinished = true;
        this.completionTime = completionTime;
        this.finishedAt = LocalDate.now();
    }

    public boolean getIsFinished() {
        return isFinished;
    }


    @Override
    public String toString() {
        return "Task:\n" +
                "Name of the task: '" + name + "'\n" +
                "Task type: " + type + "\n" +
                "Description: '" + description + "'\n" +
                "Estimated time of completion (in hours): " + estimatedTime + "\n" +
                "Actual time of completion (in hours): " + completionTime + "\n" +
                "Is the task finished: " + isFinished + "\n" +
                "Deadline: " + deadline + "\n" +
                "Finished at: " + (isFinished ? finishedAt : "Not finished yet") + "\n" +
                "Created at: " + createdAt + "\n" +
                "--------------------------------------------";
    }
}
