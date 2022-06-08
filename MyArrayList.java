import java.io.Serializable;
import java.util.*;

public class MyArrayList<T> extends AbstractList<T> implements List<T>, RandomAccess, Cloneable, Serializable {
    private int size = 0;
    private T [] arrayList = (T[]) new Object[size];

    public MyArrayList() {
        this.arrayList = arrayList;
        this.size = size;
    }



    public boolean add(T value){
   arrayList = Arrays.copyOf(arrayList, ++size);
   arrayList[--size] = value;
        size++;
        return true;
    }

    public T remove(int index){
        int i = size - index - 1;
        int q = index + 1;
        T [] ar1 = Arrays.copyOf(arrayList,index);
        T [] ar2 = (T[])  new Object[i];
        System.arraycopy(arrayList,q,ar2,0,i);
        arrayList = (T[])  new Object[--size];
        System.arraycopy(ar1,0,arrayList,0,index);
        System.arraycopy(ar2,0,arrayList,index,i);
        return null;
    }

    public void clear(){
        arrayList = (T[]) new Object[0];
    }

    public int size(){
        return size;
    }

    public T get(int index){
        return arrayList[index];
    }

}


