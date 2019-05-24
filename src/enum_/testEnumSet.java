package enum_;

import java.util.EnumSet;

public class testEnumSet {
    public static void main(String a[]){
        EnumSet<Weeks> weeks = EnumSet.noneOf(Weeks.class);
        //System.out.println(Weeks.class.getDeclaredMethods());
        weeks.add(Weeks.MONDAY);
        System.out.println("Element int EnumSet: "+weeks);
        weeks.remove(Weeks.MONDAY);
        System.out.println("Element int EnumSet: "+weeks);
        weeks.addAll(EnumSet.complementOf(weeks));//添加week集合的补集
        System.out.println("Element int EnumSet: "+weeks);
        System.out.println("Element int EnumSet: "+EnumSet.range(Weeks.FRIDAY,Weeks.SUNDAY));//返回范围值

    }
}
