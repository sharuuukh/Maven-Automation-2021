package Day7_032721;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayListExample {

    public static void main(String[] args) {

        ArrayList<String> cities = new ArrayList<String>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        cities.add("Bronx");
        cities.add("Staten Island");

        //have to use cities.size here instead of cities.length. there is no definite length here.
        for (int i=0; i< cities.size(); i++) {
            System.out.println("My city is " + cities.get(i) + ".");
        }

    }
}
