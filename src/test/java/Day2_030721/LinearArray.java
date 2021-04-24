package Day2_030721;

public class LinearArray {

    public static void main(String[] args) {
        //declare the variables
        String[] cities;
        int[] streetNumber, houseNumber;

        //assign the declared variables with values
        cities = new String[]{"Brooklyn", "Queens", "Manhattan", "Bronx", "Staten Island"};
        streetNumber = new int[]{222,345,567,888,1000};
        houseNumber = new int[]{239,565,756,999,6778};

        //print Queens and street number 222
        System.out.println("My city is " + cities[1] + " and my street number is " + streetNumber[0]);
        System.out.println("My house number is " + houseNumber[0]);


    }//end of main method




}//end of java class