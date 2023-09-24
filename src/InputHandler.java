import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    public String readData(String props){
        System.out.print(props);
        return scanner.nextLine();
    }

}
