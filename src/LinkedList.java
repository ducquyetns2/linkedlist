public class LinkedList<T extends Comparable<T>> {
    private NodeA<T> head;
    private NodeA<T> tail;
    public int length;

    public LinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public void addFirst(T data) {
        length++;
        NodeA<T> node = new NodeA<>(data);
        node.next = head;
        head = node;
    }

    public void addLast(T data) {
        length++;
        NodeA<T> node = new NodeA<>(data);
        tail.next = node;
        tail = node;
    }

    public void addBefore(T data, T before) {
        length++;
        if (head.data.equals(data)) {
            addFirst(data);
            return;
        }
        ;
        NodeA<T> loop = head;
        NodeA<T> ahead = null;
        while (loop != null) {
            if (loop.data.equals(data)) {
                break;
            }
            ahead = loop;
            loop = loop.next;
        }
        if (loop == null || ahead == null) addLast(data);
        else {
            var newNode = new NodeA<>(data);
            newNode.next = ahead.next;
            ahead.next = newNode;
        }
    }

    public void addAt(T data, int k) {
        length++;
        if (k <= 0) {
            addFirst(data);
            return;
        }
        ;
        NodeA<T> newNode = new NodeA<>(data);
        NodeA<T> loop = head;
        int count = 0;
        while (loop != null) {
            count++;
            if (count == k) {
                newNode = loop;
                loop = loop.next;
                return;
            }
            loop = loop.next;
        }
        if (k >= count) {
            addLast(data);
        }

    }
    public void addMid(T data) {
        var node=findMidNode();
        if(length ==0 || node == null) addFirst(data);
        else {
            if(node.data.equals(tail.data)) {
                addLast(data);
                return;
            }
            var newNode=new NodeA<>(data);
            newNode.next=node.next;
            node.next=newNode;
        }
    }
    public T findMid() {
        var node=findMidNode();
        return (node != null) ? node.data : null;
    }
    private NodeA<T> findMidNode() {
        if(length ==0) return null;
        var loop = head;
        int count = 0;
        int mid = (this.length / 2 == 0) ? this.length / 2 : this.length / 2 + 1;
        while (loop != null) {
            count++;
            if (mid == count) return loop;
            loop = loop.next;
        }
        return loop;
    }

    private NodeA<T> findNode(T data) {
        NodeA<T> loop = head;
        while (loop != null) {
            if (loop.data.equals(data)) return loop;
            loop = loop.next;
        }
        return null;
    }

    public void show() {
        var loop = head;
        while (loop != null) {
            System.out.print(loop.data.toString() + "->");
            loop = loop.next;
        }
        System.out.println("-> null");
    }

    // create Node class
    static class NodeA<T> {
        private T data;
        private NodeA<T> next;

        public NodeA(T data) {
            this.data = data;
            this.next = null;
        }

        public void setNext(NodeA<T> next) {
            this.next = next;
        }
    }
}
