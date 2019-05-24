import java.util.ArrayList;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Random a = new Random();
        for(int i=0;i<100;i++) {
            System.out.println(a.nextInt(2));
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int mm = 5;
        mm -=0.3;
        System.out.println(mm);
        System.out.println("aksd".toCharArray());
    }
}
