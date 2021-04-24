package Day3_031321;

public class LoopWConditionalStatement {

    public static void main(String[] args) {

        String[] countries = new String[4];
        countries[0] = "USA";
        countries[1] = "Canada";
        countries[2] = "Bangladesh";
        countries[3] = "India";

        for(int i = 0; i < countries.length; i++){

            if (countries[i] == "USA"){
                System.out.println("Country is " + countries[i]);
            } else if (countries[i] == "Canada"){
                System.out.println("Country is " + countries[i]);
            }//end of conditional
        }//end of for loop

    }//end of main
}//end of class
