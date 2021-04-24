package Day3_031321;

public class multipleCondition {

    public static void main(String[] args) {

        int a,b,c;
        a = 2;
        b = 3;
        c = 4;

        //verify a+b>c, a+b<c, a+b=c
        if(a+b > c) {
            System.out.print("a and b is greater than c.");
        }else if(a+b < c){
                System.out.println("a and b is less than c.");
        }else {
            System.out.println("a and b is equal to c.");
        }

    }
}
