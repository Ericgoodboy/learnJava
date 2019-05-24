package leetcode;

public class QuickSort {
    public void run(int sortArray[],int lowIndex,int heightIndex){
        int lo = lowIndex;
        int hi = heightIndex;
        int mid ;
        if(heightIndex>lowIndex){
            mid = sortArray[(heightIndex+lowIndex)/2];
            while (lo<=hi){
                while ((lo<heightIndex)&&(sortArray[lo]<mid))
                    ++lo;
                while ((hi>lowIndex)&&(sortArray[hi]>mid))--hi;
                if(lo<=hi){
                    swap(sortArray,lo,hi);
                    ++lo;
                    --hi;
                }
            }
            if(lowIndex<hi){
            run(sortArray,lowIndex,hi);
            }
            if(lo<heightIndex){
                run(sortArray,lo,heightIndex);
            }


        }

    }
    public void swap(int sortArray[],int lowIndex,int heightIndex){
        sortArray[lowIndex] = sortArray[lowIndex]+sortArray[heightIndex];
        sortArray[heightIndex] = sortArray[lowIndex]-sortArray[heightIndex];
        sortArray[lowIndex] = sortArray[lowIndex] - sortArray[heightIndex];
    }
}
