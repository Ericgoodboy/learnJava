package stringOperat;
import java.text.NumberFormat;
import java.util.Locale;


/*
* 关键技术
*
* */
public class FormatString {
    public static void main(String [] args){
        NumberFormat formater = NumberFormat.getCurrencyInstance(Locale.CHINA);
        double money = 3.65;
        System.out.println("对"+money+"进行格式化");
        String a = formater.format(money);
        System.out.println("结果："+a);
    }

}
