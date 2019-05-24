package leetcode;

import java.util.HashMap;
import java.util.Map;
//每次更新并记录最近的位置，并取上次最近的为最大值
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
    int now=0;
    int max=0;
    char[] ss = s.toCharArray();
    Map<Character,Integer> map=new HashMap<Character,Integer>();//记录没个字符最近出现的位置
    for(int i=0;i<ss.length;i++){
        if(map.containsKey(ss[i])){//查看新字符是否有冲突
            max=Math.max(now,max);
            now=Math.min(now+1,i-map.get(ss[i]));
            map.put(ss[i],i);
        }else {
            now++;
            map.put(ss[i],i);
        }
    }
    return max;
    }
    public static void main(String args[]){

    }
}
