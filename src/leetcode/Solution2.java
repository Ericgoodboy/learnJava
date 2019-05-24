package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<Integer>();
        long now = 1;//注意用int会溢出
        for(int i=0;i<=rowIndex;i++){
            ans.add((int)now);
            now=now*rowIndex-i;
            now=now/(i+1);
        }
        return ans;

    }
}
