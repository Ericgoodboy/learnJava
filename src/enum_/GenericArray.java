package enum_;

import java.lang.reflect.Array;

public class GenericArray<T> {
    private T[] array;
    private int size;
    @SuppressWarnings("uncheck")
    public GenericArray(Class<T> type,int size){
        this.size=size;
        this.array = (T[]) Array.newInstance(type,size);//输入参数是类型
    }
    public void put(int index,T item){
        if (this.size>index){
            array[index]=item;
        }
    }
    public T get(int index){
        if (this.size>index){
            return array[index];
        }else {
            return null;
        }
    }
}
