import java.util.Arrays;

public class MyQueue <T>  {
    int size = 0;
    T [] queue = (T[]) new Object[size];

    public MyQueue() {
        this.queue = queue;
        this.size = size;
    }

    public boolean add(T value){
        queue = Arrays.copyOf(queue, ++size);
        queue[--size] = value;
        size++;
        return true;
    }

    public void remove(int index){
//        int i = size - index - 1;
//        System.arraycopy(queue,index+1,queue,index,i);
//        queue[--size] = null;
//        size--;
        int i = size - index - 1;
        int q = index + 1;
        T [] q1 = Arrays.copyOf(queue,index);
        T [] q2 = (T[])  new Object[i];
        System.arraycopy(queue,q,q2,0,i);
        queue = (T[])  new Object[--size];
        System.arraycopy(q1,0,queue,0,index);
        System.arraycopy(q2,0,queue,index,i);
    }

    public void clear(){queue = (T[]) new Object[0];}

    public int size(){ return size;}

    public T peek(){
        return queue[0];
    }

    public T poll(){
        T z = queue[0];
        int i = queue.length-1;
        T [] a = (T[]) new Object[i];
        System.arraycopy(queue,1,a, 0, i);
        queue = Arrays.copyOf(a, a.length);
        size--;
        return z;
    }
}

