package ThreadTest;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import java.util.ArrayList;
import java.util.List;

public class ThreadList {
    private static ThreadGroup getRootThreadGroups(){
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (true){
            if(threadGroup.getParent()!=null){
                threadGroup=threadGroup.getParent();
            }else {
                break;
            }

        }
        return threadGroup;
    }
    public static List<String> getThreads(ThreadGroup threadGroup){
        List<String> threadList = new ArrayList<String>();
        Thread[] threads = new Thread[threadGroup.activeCount()];
        int count = threadGroup.enumerate(threads,false);//复制线程到线程数组
        for(Thread t:threads){
            threadList.add(""+threadGroup.getName()+":>"+t.getName());
        }
        return threadList;
    }
    public static List<String> getThreadGroups(ThreadGroup threadGroup){
        List<String> threadList = new ArrayList<String>();
        ThreadGroup[] threadGroups = new ThreadGroup[threadGroup.activeCount()];
        threadGroup.enumerate(threadGroups,false);
        for(ThreadGroup t : threadGroups){
            threadList.addAll(getThreads(t));
        }
        return threadList;
    }

}
