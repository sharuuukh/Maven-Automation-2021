package Day2_030721;

public class whileLoop {

    public static void main(String[] args) {

        String[] cities;

        cities = new String[4];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Manhattan";
        cities[3] = "Staten Island";

        int i = 0; //set the initializer i
        while (i <= 3){ //set the gate keeper or end point

            System.out.println("My city is " + cities[i]);

        i = i + 2; //set the count
        } //end of loop
    }
}
