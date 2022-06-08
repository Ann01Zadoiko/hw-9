import java.util.*;


public class MyStack <T>  {
    private int top = -1;
    private T[] stack;
    private int size;


    public MyStack(int size) {
        this.stack = (T[])  (new Object[size]);
        this.size = size;
    }

    public void push(T value){
//        if (top == stack.length)
//        {
//            T [] copy = Arrays.copyOf(stack, stack.length);
//        }
//        top++;
//        stack[top]= value;
        int i = top + 2;
        stack = Arrays.copyOf(stack, i);
        stack[++top] = value;
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
    }

    public void clear(){
        stack = (T[]) new Objects[0];
    }

    public int size(){ return ++top;}

    public T peek(){
        if (top == 0)
            throw new EmptyStackException();

        T result = stack[top];
        return result;
    }

    public T pop() throws EmptyStackException{
        if (top == 0)
            throw new EmptyStackException();
        T result = stack[top];
        int i = stack.length-1;
        T [] a = (T[]) new Object[i];
        System.arraycopy(stack,0,a, 0, i);
        stack = Arrays.copyOf(a, top);
        return result;

    }
}

