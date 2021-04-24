package Day4_031421;

public class SplitCommand {

    public static void main(String[] args) {

        String message = "My name is Sharukh.";
        String[] arrayMessage = message.split(" ");

        System.out.println("Result is " + arrayMessage[3]);
    }
}
