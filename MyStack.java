import java.util.*;


public class MyStack <T>  {
    private int top = -1;
    private T[] stack;
    private int size;


    public MyStack() {
        this.stack = (T[])  (new Object[size]);
        this.size = 0;
    }

    public void push(T value){
        int i = top + 2;
        stack = Arrays.copyOf(stack, i);
        stack[++top] = value;
        size++;
    }

    public void remove(int index){
//        int i = size - index - 1;
//        System.arraycopy(stack,index+1,stack,index,i);
//        stack[--size] = null;
//        return null;
        int i = top - index ;
        int s = index + 1;
        T [] s1 = Arrays.copyOf(stack,index);
        T [] s2 = (T[])  new Object[i];
        System.arraycopy(stack,s,s2,0,i);
        stack = (T[])  new Object[s2.length + s1.length];
        System.arraycopy(s1,0,stack,0,index);
        System.arraycopy(s2,0,stack,index,i);
        size--;
    }

    public void clear(){
        stack = (T[]) new Objects[0];
        size = 0;
    }

    public int size(){ return size;}

    public T peek(){
        int i = size;
        T result = stack[--i];
        if(size == 0){
            throw new EmptyStackException();
        }
        return result;
    }

    public T pop() {
        T result = stack[--size];
        if(size == 0){
            throw new EmptyStackException();
        }
        T [] a = Arrays.copyOf(stack,size);
        stack = Arrays.copyOf(a,a.length);
        return result;
    }
}

