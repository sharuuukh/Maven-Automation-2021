package ActionItems;

public class Week2Assignment2 {

    public static void main(String[] args) {

        String grade = "Z";

        switch (grade){

            case "A":
                System.out.println("Excellent.");
                break;
            case "B":
                System.out.println("Well Done.");
                break;
            case "C":
                System.out.println("Satisfactory.");
                break;
            case "D":
                System.out.println("Passed.");
                break;
            case "F":
                System.out.println("Fail.");
                break;
            default:
                System.out.println("Invalid Grade.");
        }
    }
}
