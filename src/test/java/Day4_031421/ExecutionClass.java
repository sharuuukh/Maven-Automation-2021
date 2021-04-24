package Day4_031421;

public class ExecutionClass {

    public static void main(String[] args) {

        //this is where you can call your reusable method to be executed, inside main method
        //ReusableMethods.addTwoNumbers(20,30);
        //ReusableMethods.addTwoNumbers(60,30);
        //ReusableMethods.addTwoNumbers(70,30);
        //ReusableMethods.addTwoNumbers(20,10);

        //call subtract method and store the result
        int c = ReusableMethods.subtractTwoNumbers(20,10);
        System.out.println("New result is " + (c-5));


    }
}
