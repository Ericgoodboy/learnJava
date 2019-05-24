package leetcode;

/*
* 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。

选取一个删除索引序列，对于 A 中的每个字符串，删除对应每个索引处的字符。

比如，有 A = ["babca","bbazb"]，删除索引序列 {0, 1, 4}，删除后 A 为["bc","az"]。

假设，我们选择了一组删除索引 D，那么在执行删除操作之后，最终得到的数组的行中的每个元素都是按字典序排列的。

清楚起见，A[0] 是按字典序排列的（即，A[0][0] <= A[0][1] <= ... <= A[0][A[0].length - 1]），A[1] 是按字典序排列的（即，A[1][0] <= A[1][1] <= ... <= A[1][A[1].length - 1]），依此类推。

请你返回 D.length 的最小可能值
*
* */


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution4 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int count =0;
        for(int i = 0; i<nums.length;i++){
            count+=nums[i];
        }
        if (count%k!=0){return false;}
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int now = map.get(nums[i]);
                map.replace(nums[i],now+1);
            }else {
                map.put(nums[i],1);
            }
        }
        int i=0;
        while (map.size()>=0){
            Set<Integer> keys=map.keySet();
        }
        return true;
    }

}
