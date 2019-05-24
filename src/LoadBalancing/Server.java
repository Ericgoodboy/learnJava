package LoadBalancing;

import java.util.ArrayList;

public class Server {
    double positionX,positionY;
    int load;
    int initLoad;
    ArrayList<Integer> loads;
    public Server( double positionX,double positionY,int load){
        this.positionX=positionX;
        this.positionY=positionY;
        this.load=load;
        this.initLoad=load;
    }
    public Server( double positionX,double positionY,ArrayList<Integer> loads){
        this.positionX=positionX;
        this.positionY=positionY;
        this.loads = loads;
        this.load=loads.get(0);
        this.initLoad=loads.get(0);
    }
    public void setNowIndex(int k)throws ArrayIndexOutOfBoundsException{
        this.load=loads.get(k);
        this.initLoad=loads.get(k);
    }
    public void Init(){
        this.load=this.initLoad;
    }
}
