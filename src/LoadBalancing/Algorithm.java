package LoadBalancing;

import java.util.ArrayList;
import java.util.Random;
public class Algorithm {
    double minArg,maxArg;
    public Algorithm(double minArg,double maxArg){
        this.minArg=minArg;
        this.maxArg=maxArg;
    }
    public double Cal(ArrayList<Server> servers,double wightPosition, double wightLoad){
        ArrayList<Server> requestList=new ArrayList<Server>();
        ArrayList<Server> normal=new ArrayList<Server>();
        ArrayList<Server> heavy=new ArrayList<Server>();
        double allDistance=0.0;
        int totalLoad=0;
        for(Server s : servers){
            totalLoad+=s.load;
        }
        double Lmin=Math.floor(this.minArg*totalLoad/servers.size());
        double Lmax=Math.ceil(this.maxArg*totalLoad/servers.size());
//        System.out.println("Lmin:"+Lmin);
//        System.out.println("Lmax:"+Lmax);
        for(Server s : servers){
           if(s.load<Lmin){//创建请求列队
               requestList.add(s);
           }else if (s.load>Lmax){
               heavy.add(s);
           }else {
               normal.add(s);
           }
        }
        for(Server s : heavy){
            while (s.load> Lmax){
                int length = requestList.size();
                Random r=new Random();
                if(requestList.size()<1){
                    break;//--------------------处理相对平衡
                }
                Server nearServer;
                if (requestList.size()==1){
                    nearServer = requestList.get(0);
                }else {
                    int index1 = r.nextInt(length);
                    int index2 = r.nextInt(length);
                    while (index1 == index2){
                        index1 = r.nextInt(length);
                        index2 = r.nextInt(length);
                    }
                    Server s1 = requestList.get(index1);
                    Server s2 = requestList.get(index2);
                    nearServer=this.choose(s1,s2,s,wightPosition,wightLoad);
                }
                double moven= move(s,nearServer,Lmax);
                allDistance+=moven;
                if (nearServer.load>Lmin){
                    requestList.remove(nearServer);
                }
                }
        }
        return allDistance;
    }
    private double move(Server heavyServer,Server requestServer,double Lmax){
        int l1 = (int)Lmax-requestServer.load;
        int l2 = heavyServer.load-(int)Lmax;
        int maxMove=l1>l2 ? l2:l1;
        requestServer.load+=maxMove;
        heavyServer.load-=maxMove;
        String a="dsada";

        return calDistance(heavyServer,requestServer);

    }
    private double calDistance(Server a,Server b){
        double dx = Math.pow(a.positionX-b.positionX,2);
        double dy = Math.pow(a.positionY-b.positionY,2);
        return Math.sqrt(dx+dy);
    }
    private Server choose(Server a,Server b,Server c,double wightPosition, double wightLoad){
        double d1=this.calDistance(a,c);
        double d2=this.calDistance(b,c);
        double td1=d1/(d1+d2);
        double td2=d2/(d1+d2);
        int l1 = a.load;
        int l2 = b.load;
        double tl1 = (double)l1/(l1+l2);
        double tl2 = (double)l2/(l1+l2);
        double distance1 = wightPosition*td1+wightLoad*tl1;
        double distance2 = wightPosition*td2+wightLoad*tl2;
        return distance1>distance2 ? b:a;
    }
}
