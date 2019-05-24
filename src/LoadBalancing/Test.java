package LoadBalancing;

import java.util.ArrayList;
import java.util.Random;

public class Test {
public static void main(String args[]){
    ArrayList<Server> serverList=new ArrayList<Server>();
    FileAnyance f = new FileAnyance();
    try {
        serverList=f.readFile("F:\\2019\\learnJava\\src\\LoadBalancing\\IDdata.csv");
    }catch (Exception e){
        e.printStackTrace();
    }
    int caseLength = serverList.get(0).loads.size();
//    int base=500;//基础值
//    int changeRound=100;//波动范围
//    Random r = new Random();
//    for (int i=0;i<300;i++){
//        for(int j=0;j<300;j++){
//            int randomLoad = r.nextInt(changeRound);
//            Server temp=new Server(i,j,base+randomLoad);
//            serverList.add(temp);
//        }
//    }
    for(int k=0;k<caseLength;k++){
        for(int i=0;i<serverList.size();i++){
            serverList.get(i).setNowIndex(k);
        }
        Algorithm algorithm =new Algorithm(0.975,1.025);

        int frequence=1;
        System.out.printf("time:%3s\n",k);
        System.out.println("wp: 0.5,wl:0.5");
        int a=(int)cal(frequence,algorithm,serverList,0.5,0.5);
        System.out.println("wp: 1,wl:0");
        int b=(int)cal(frequence,algorithm,serverList,1,0);
        System.out.println("wp: 0,wl:1");
        int c=(int)cal(frequence,algorithm,serverList,0,1);
        //System.out.printf("time:%3s wp=0.5,wl=0.5:%4s wp=1,wl=0.0:%4s wp=0,wl=1:%4s\n",k,a,b,c);

    }




}
public static double cal(int frequence,Algorithm algorithm,ArrayList<Server> serverList,double wp,double wl){
    double temp=0.0;
    for(int i=0;i<frequence;i++){
        temp+=algorithm.Cal(serverList,wp,wl);
        for(int j=0;j<serverList.size();j++){
            Server s = serverList.get(j);
            System.out.printf("id:%6s,load:%6s,initload:%6s\n",j,s.load,s.initLoad);
            serverList.get(j).Init();        }
    }
    return temp/frequence;
}
}
