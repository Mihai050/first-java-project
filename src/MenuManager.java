public class MenuManager {

    //service , intelligent

    private final InputHandler inputHandler;
    private final InputValidator inputValidator;
    private final TaskManagerInterface taskManager;




    public MenuManager(InputHandler inputHandler, InputValidator inputValidator, TaskManagerInterface taskManager) {
        this.inputHandler = inputHandler;
        this.inputValidator = inputValidator;
        this.taskManager = taskManager;
    }

    public void initialize(){
        while(true) {
            showMenuOptions();
            String selected = inputHandler.readData("Your choice: ");
            while (!inputValidator.isNumberOnMenu(selected, 1, 4)) {
                System.out.println("You should chose a menu option!");
                showMenuOptions();
                selected = inputHandler.readData("Your choice: ");
            }
            switch (selected) {
                case "1":
                    this.viewTasks();
                    break;
                case "2":
                    this.addTask();
                    break;
                case "3":
                    this.finishTask();
                    break;
                case "4":
                    this.deleteTask();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + selected);
            }
        }


    }

    private void showMenuOptions(){
        System.out.println("1. View tasks");
        System.out.println("2. Add task");
        System.out.println("3. Finish task");
        System.out.println("4. Delete task");

    }


    private void viewTasks(){
        taskManager.showTasks();
        if(taskManager.showLength() == 0){
            System.out.println("There are no tasks yet!");
        }
    }

    private void addTask(){
        String name = inputHandler.readData("Please enter a name: ");
        while(!inputValidator.isNameCorrect(name)){
            System.out.println("Name should be at least 4 characters long!");
            name = inputHandler.readData("Please enter a name: ");
        }

        String type = inputHandler.readData("Please enter a type (Work, Hobby, School or Home): ");
        while(!inputValidator.isTypeCorrect(type)){
            System.out.println("Type is not valid!");
            type = inputHandler.readData("Please enter a type (Work, Hobby, School or Home): ");
        }

        String description = inputHandler.readData("Please enter a description: ");
        while(!inputValidator.isDescriptionCorrect(description)){
            System.out.println("Description is not valid! Make sure it's at least 10 characters long!");
            description = inputHandler.readData("Please enter a description: ");
        }

        String estimatedTime = inputHandler.readData("Please enter an estimated time: ");
        while(!inputValidator.isTimeCorrect(estimatedTime)){
            System.out.println("Time is not valid! Make sure it's above 0!");
            estimatedTime = inputHandler.readData("Please enter an estimated time: ");
        }

        System.out.println("Enter the deadline time:");
        String year = inputHandler.readData("Enter the year: ");
        String month = inputHandler.readData("Enter the month (as a number): ");
        String day = inputHandler.readData("Enter the day (as a number): ");

        while(!inputValidator.isDateCorrect(year, month, day)){
            System.out.println("Please try again! The date should be valid and not in the past!");
            year = inputHandler.readData("Enter the year: ");
            month = inputHandler.readData("Enter the month (as a number): ");
            day = inputHandler.readData("Enter the day (as a number): ");
        }

        Task createdTask = new Task(name, type,description, Float.parseFloat(estimatedTime),
                Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

        taskManager.appendTask(createdTask);

        System.out.println("Task created successfully!");

    }

    private void finishTask(){
        String taskNumber = inputHandler.readData("Please enter the task number that you want to finish: ");
        while(!inputValidator.isNumberInteger(taskNumber)){
            System.out.println("Number should be an integer greater than 0!");
            taskNumber = inputHandler.readData("Please enter the task number that you want to finish!");
        }
        int parsedTaskNumber = Integer.parseInt(taskNumber) - 1;

        if(parsedTaskNumber > taskManager.showLength()){
            System.out.println("Task is not on the list!");
            return;
        }

        if(taskManager.isFinished(parsedTaskNumber)){
            System.out.println("Task is already finished!");
            return;
        }

        String taskCompletionTime = inputHandler.readData("Please enter the task completion time: ");
        while(!inputValidator.isTimeCorrect(taskCompletionTime)){
            System.out.println("Number should be greater than 0!");
            taskCompletionTime = inputHandler.readData("Please enter the task completion time: ");
        }

        float parsedTaskCompletionTime = Float.parseFloat(taskCompletionTime);
        taskManager.finishTask(parsedTaskNumber, parsedTaskCompletionTime);
    }

    private void deleteTask(){
        String taskNumber = inputHandler.readData("Please enter the task number that you want to delete: ");
        while(!inputValidator.isNumberInteger(taskNumber)){
            System.out.println("Number should be an integer greater than 0!");
            taskNumber = inputHandler.readData("Please enter the task number that you want to delete!");
        }
        int parsedTaskNumber = Integer.parseInt(taskNumber) - 1;

        if(parsedTaskNumber > taskManager.showLength()){
            System.out.println("Task is not on the list!");
            return;
        }

        if(taskManager.isFinished(parsedTaskNumber)){
            System.out.println("You can't delete a finished task!");
            return;
        }

        taskManager.deleteTask(parsedTaskNumber - 1);

    }

}
