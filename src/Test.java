public class Test {
public double average(int score[]){
    double aver=-1;
    int i=0,n1=0,n2=0,sum=0;
    while (score[i]!=-1&&n1<50){
        n1+=1;
        if (score[i]>0&&score[i]<100){
            sum+=score[i];
            n2+=1;
        }
        i++;
    }
    if (n2>0){
        aver=sum/n2;
    }
    return aver;
}
}
