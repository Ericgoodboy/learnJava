package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class powString {
    public static String cal(String l1,String l2,String med){
        int n1,n2;
        try {
            n1=Integer.parseInt(l1);
        }catch(Exception e){
            return "输入错误";
        }

        try {
            n2=Integer.parseInt(l2);
        }catch(Exception e){
            return "输入错误";
        }
        if (med.equals("+")){
            return new String(""+(n1+n2));
        }else if (med.equals("-")){
            return new String(""+(n1-n2));
        }else if (med.equals("*")){
            return new String(""+(n1*n2));
        }else if (med.equals("/")){
            return new String(""+(n1/n2));
        } else {
            return "符号错误";
        }
    }
    public static class  Case{
        public String n1;
        public String n2;
        public String med;
        public Case(String n1,String n2,String med){
            this.n1 = n1;
            this.n2 = n2;
            this.med = med;
        }
    }
    public static void main(String a[]){
        ArrayList<Case> cases = new ArrayList<Case>();
        cases.add(new Case("1","1","+"));
        cases.add(new Case("haha","1","+"));
        cases.add(new Case("1","haha","+"));
        cases.add(new Case("1","2","o"));
        for(Case c:cases){
            System.out.println(powString.cal(c.n1,c.n2,c.med));
        }
    }
}
