package stringOperat;
import java.text.DecimalFormat;//用于数字转换大小写
public class Currency {
    public static void main(String args[]){

    }
    public static String convert(double money){
        DecimalFormat df = new DecimalFormat("#0.###");
        String strNum = df.format(money);
        return "";
    }
}
