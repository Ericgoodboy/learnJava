package ThreadTest;

import OperationSystem.CycLists;

import java.util.ArrayList;

public class CycThreadList {
    ArrayList<ArrayList<ControlThread>> cycList = new ArrayList<ArrayList<ControlThread>>();
    int nowPlace = 0;
    int cycLength;

    CycThreadList(int cycLength) {
        this.cycLength = cycLength;
        for (int i = 0; i < cycLength; i++) {
            cycList.add(new ArrayList<ControlThread>());
        }
    }
    public boolean add(ControlThread newAdd)
    {
        cycList.get(0).add(newAdd);
        return nowPlace != 0;
    }
    public boolean add(ArrayList<ControlThread> newAdds)
    {
        for(ControlThread newAdd:newAdds){
            System.out.printf("线程：%4s 进入\n",newAdd);
            cycList.get(0).add(newAdd);
        }
        boolean confict=(nowPlace != 0);
        nowPlace=0;
        return confict;
    }
    public boolean placeUp(){
    if (nowPlace==(cycLength-1))
    {
        return false;
    }
    nowPlace+=1;
    if(cycList.get(nowPlace).size()==0)
    {
        return placeUp();
    }
    return true;
    }
    public void placeBack(){
        nowPlace = 0;
    }
    public void append(int index,ControlThread c){
        cycList.get(index).add(c);
    }

    public ControlThread get(){
        if (cycList.get(nowPlace).size()==0){
            if(!placeUp()){
                return null;
            }
        }
        ControlThread temp=cycList.get(nowPlace).get(0);
        temp.cycIndex = nowPlace;
        System.out.printf("线程：%4s 进入,nowPlace:%3s\n",temp,nowPlace);
        cycList.get(nowPlace).remove(temp);
        return temp;
    }


}