package LoadBalancing;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileAnyance {
public ArrayList<Server>  readFile(String url) throws Exception {
    FileReader fr =new FileReader(url);
    BufferedReader bf = new BufferedReader(fr);
    ArrayList<ArrayList<Integer>> a =new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
    String temp;
    boolean start=true;
    while ((temp=bf.readLine())!=null){
        if(temp.startsWith("\"")) {
            String[] words = temp.split("\",\"");
            for(String w : words){
                ArrayList<Integer> tempArr=new ArrayList<Integer>();
                w=w.replace("\"","");
                w=w.replaceAll("\\(",",");
                w=w.replaceAll("\\)","");
                //System.out.printf("%9s",w);
                String[] t=w.split(",");
                tempArr.add(Integer.parseInt(t[0]));
                tempArr.add(Integer.parseInt(t[1]));
                tempArr.add(Integer.parseInt(t[2]));
                b.add(tempArr);
            }
            continue;
        };
        String[] words = temp.split(",");
        ArrayList<Integer> tempArr=new ArrayList<Integer>();
        for(String w : words){
            //System.out.printf("%9s",w);
            tempArr.add(Integer.parseInt(w.replaceAll(" ","")));
        }
        a.add(tempArr);
        //System.out.println();
    }
    ArrayList<Server> serverArrayList = new ArrayList<Server>();
    for(int i = 0;i<b.size();i++){
        ArrayList<Integer> tempheader=b.get(i);
        ArrayList<Integer> tempLoader =new ArrayList<Integer>();
        for(int j =0 ;j<a.size();j++){
            tempLoader.add(a.get(j).get(i));
        }
        // double positionX,double positionY,ArrayList<Integer> loads
        Server s=new Server(tempheader.get(1),tempheader.get(2),tempLoader);
        serverArrayList.add(s);
    }
    return serverArrayList;
}

public static void main(String args[]){
    FileAnyance f = new FileAnyance();
    try {
        f.readFile("F:\\2019\\learnJava\\src\\LoadBalancing\\IDdata.csv");
    }catch (Exception e){
e.printStackTrace();
    }
}
}
