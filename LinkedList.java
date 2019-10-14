public class LinkedList<T> implements List<T> {

    Node head = null;
    int size;


    //this class passes the runtime test about 60% of the time

    private class Node<T> {
        private T data;
        private Node next;

        public Node(T item){
            data = item;
            next = null;
        }
    }

    @Override
    public void add(T item) {
        if (head == null){
            head = new Node(item);
            size++;
        } else {
            Node previous = head;
            while (previous.next != null)
                previous=previous.next;
            Node current = new Node(item);
            previous.next = current;
            size++;
        }
    }

    @Override
    public void add(int position, T item) {
        if (position < 0 || position > size)
            throw new RuntimeException();

        if (position == 0){
            Node current = new Node(item);
            current.next=head;
            head=current;
            size++;
        } else {
            Node current = new Node(item);
            Node previous = head;
            for (int i = 0; i< position-1; i++) {
                previous=previous.next;
            }
            current.next = previous.next;
            previous.next = current;
            size++;
        }
    }

    @Override
    public T get(int position) {
        if (position < 0 || position >= size)
            throw new RuntimeException();
        Node previous = head;
        for (int i = 0; i < position; i++) {
            previous = previous.next;
        }
        return (T)previous.data;
    }

    @Override
    public T remove(int position) {
        if (position < 0 || position >= size)
            throw new RuntimeException();

        if (position == 0){
            T item = (T) head.data;
            head = head.next;
            size--;
            return item;
        } else {
            Node previous = head;
            for (int i = 0; i < position-1; i++){
                previous = previous.next;
            }
            Node current = previous.next;
            T item = (T) current.data;
            previous.next = current.next;
            size--;
            return item;
        }
    }

    @Override
    public int size() {
        return size;
    }
}