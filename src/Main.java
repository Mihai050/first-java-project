
public class Main {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();

        InputValidator inputValidator = new InputValidator();

        TaskManager taskManager = new TaskManager();

        MenuManager menuManager = new MenuManager(inputHandler, inputValidator, taskManager);

        menuManager.initialize();
    }
}