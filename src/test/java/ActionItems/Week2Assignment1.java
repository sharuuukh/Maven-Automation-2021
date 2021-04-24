package ActionItems;

public class Week2Assignment1 {

    public static void main(String[] args) {

        int grade = 95;

        if(grade >= 90 && grade <= 100){
            System.out.println("My grade is an A.");
        }else if(grade >= 80 && grade < 90){
            System.out.println("My grade is a B.");
        }else if(grade >= 70 && grade < 80){
            System.out.println("My grade is a C.");
        }else if(grade >= 60 && grade < 70){
            System.out.println("My grade is a D.");
        }else if(grade < 60){
            System.out.println("My grade is a F.");
        }
    }
}
