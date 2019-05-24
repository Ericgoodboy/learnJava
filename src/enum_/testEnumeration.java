package enum_;

import java.util.Enumeration;
import java.util.Vector;

public class testEnumeration {
    public static void main(String a[]){
        Vector<Integer> vector =new Vector<Integer>();
        for(int i = 0;i<=3;i++){
            vector.add(i);
            System.out.println("added:"+i);
        }
        Enumeration<Integer> e = vector.elements();
        while (e.hasMoreElements()){
            System.out.println("outed: "+e.nextElement());
        }
    }
}
