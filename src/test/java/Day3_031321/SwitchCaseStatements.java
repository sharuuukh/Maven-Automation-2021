package Day3_031321;

public class SwitchCaseStatements {

    public static void main(String[] args) {

        /* Using Switch Case statements, print
        if milkType is oat milk, almond milk, or organic milk
        else milk type is not recognized
         */

        String milkType = "soy milk";

        switch (milkType){

            case "oat milk":
                System.out.println("Milk type is oat milk.");
                break; //break needed since switch is a loop and needs to be stopped
            case "almond milk":
                System.out.println("Milk type is almond milk.");
                break;
            case "organic milk":
                System.out.println("Milk type is organic milk.");
                break;
            default:
                System.out.println("Milk type " + milkType + " is not recognized.");
                //Any milk type not in our requirements will print out the default statement

        } //end of switch
    } //end of main
} //end of class
