package Day2_030721;

public class DynamicArray {

    public static void main(String[] args) {

        String[] countries;
        int[] streetNumber;

        countries = new String[4]; //define length of dynamic array
        countries[0] = "USA"; //assign each variable a value
        countries[1] = "Spain";
        countries[2] = "Bangladesh";
        countries[3] = "India";

        streetNumber = new int[4];
        streetNumber[0] = 222;
        streetNumber[1] = 333;

        System.out.println("Country is " + countries[0]);

    }

}
