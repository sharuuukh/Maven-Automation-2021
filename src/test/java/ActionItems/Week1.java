package ActionItems;

public class Week1 {

    public static void main(String[] args) {

        String[] zipCode;
        int[] streetNumber;

        zipCode = new String[4];
        zipCode[0] = "11218";
        zipCode[1] = "10305";
        zipCode[2] = "12345";
        zipCode[3] = "11267";

        streetNumber = new int[4];
        streetNumber[0] = 239;
        streetNumber[1] = 433;
        streetNumber[2] = 1005;
        streetNumber[3] = 986;

        for(int i = 0; i < zipCode.length; i++){

            System.out.println("My zip code is " + zipCode[i] + " and my street number is " + streetNumber[i] + ".");
        }

    }

}
