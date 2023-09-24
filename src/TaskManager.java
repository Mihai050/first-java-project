import java.util.ArrayList;

public class TaskManager {

    private final ArrayList activeTasks = new ArrayList<Task>();
    public void appendTask(Task createdTask) {
        activeTasks.add(createdTask);
    }

    public int showLength(){
        return activeTasks.size();
    }

    public boolean isFinished(int position) {
        if (position >= 0 && position < activeTasks.size()) {
            Task task = (Task) activeTasks.get(position);
            return task.getIsFinished();
        }
        return false;
    }
    public void showTasks(){
        System.out.println("Active Tasks:");
        for (int i = 0; i < activeTasks.size(); i++) {
            System.out.println((i + 1) + ". " + activeTasks.get(i));
        }
    }

    public void deleteTask(int taskIndex){
        try {
            if (taskIndex >= 0 && taskIndex < activeTasks.size()) {
                activeTasks.remove(taskIndex);
                System.out.println("Task at index " + taskIndex + 1 + " deleted.");
            } else {
                System.out.println("Invalid task index. No task deleted.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid task index. No task deleted.");
        }

    }

    public void finishTask(int taskIndex, float completionTime){
        try {
            if (taskIndex >= 0 && taskIndex < activeTasks.size()) {
                Task task = (Task) activeTasks.get(taskIndex);
                task.finish(completionTime);
                System.out.println("Task at index " + taskIndex + 1 + " finished.");
            } else {
                System.out.println("Invalid task index. No task finished.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid task index. No task finished.");
        }
    }

}
