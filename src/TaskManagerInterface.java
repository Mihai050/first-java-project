public interface TaskManagerInterface {
    void appendTask(Task createdTask);
    int showLength();
    boolean isFinished(int position);
    void showTasks();
    void deleteTask(int taskIndex);
    void finishTask(int taskIndex, float completionTime);
}
