package Day2_030721;

public class forLoop {

    public static void main(String[] args) {

        String[] cities;

        cities = new String[4];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Manhattan";
        cities[3] = "Staten Island";

        //set your iteration to loop through all the cities
        //can use i <= 3, i < 4, i < cities.length
        for(int i = 0; i < cities.length; i++){

            System.out.println("My city is " + cities[i]);
        }
    }
}
