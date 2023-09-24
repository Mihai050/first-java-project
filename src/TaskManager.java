import java.util.ArrayList;

public class TaskManager implements TaskManagerInterface {


    private final ArrayList<Task> taskInMemory = new ArrayList<Task>();

    @Override
    public void appendTask(Task createdTask) {
        taskInMemory.add(createdTask);
    }

    @Override
    public int showLength(){
        return taskInMemory.size();
    }

    @Override
    public boolean isFinished(int position) {
        if (position >= 0 && position < taskInMemory.size()) {
            Task task = taskInMemory.get(position);
            return task.getIsFinished();
        }
        return true;
    }

    @Override
    public void showTasks(){
        System.out.println("Active Tasks:");
        for (int i = 0; i < taskInMemory.size(); i++) {
            System.out.println((i + 1) + ". " + taskInMemory.get(i));
        }
    }


    @Override
    public void deleteTask(int taskIndex){
        try {
            if (taskIndex >= 0 && taskIndex < taskInMemory.size()) {
                taskInMemory.remove(taskIndex);
                System.out.println("Task at index " + taskIndex + 1 + " deleted.");
            } else {
                System.out.println("Invalid task index. No task deleted.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid task index. No task deleted.");
        }

    }


    @Override
    public void finishTask(int taskIndex, float completionTime){
        try {
            if (taskIndex >= 0 && taskIndex < taskInMemory.size()) {
                Task task = taskInMemory.get(taskIndex);
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
