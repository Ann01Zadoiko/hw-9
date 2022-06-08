

public class MyLinkedList <E>  {

    private static class Node<E> {
        public Node<E> next;
        public Node<E> prev;
        public E value;

        public Node() {
            next= prev= this;
        }

        public Node(E value) {
            this.value= value;
        }

        public Node(E value, Node<E> nextNode) {
            this(value);
            this.next= nextNode;
            this.prev= nextNode.prev;
            nextNode.prev.next= this;
            nextNode.prev= this;
        }

        public void remove() {
            this.next.prev= this.prev;
            this.prev.next= this.next;
            this.next= this.prev= this;
        }
    }

    private Node<E> header;
    private int size;

    public MyLinkedList() {
        this.header = new Node<>();
        this.size = 0;
    }

    public boolean add(E value) {
        new Node<E>(value, header);
        ++size;
        return true;
    }

    public void clear() {
        header= new Node<E>();
        size= 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        Node<E> node= getNode(index);
        return node.value;
    }

    private Node<E> getNode(int index) {
        Node<E> node= header.next;
        for (int i= 0; i < index; i++)
            node= node.next;
        return node;
    }

    public E remove(int index) {
        Node<E> node= getNode(index);
        node.remove();
        --size;
        return node.value;
    }
}

