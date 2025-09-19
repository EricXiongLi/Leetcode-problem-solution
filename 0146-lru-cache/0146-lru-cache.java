class LRUCache {
    DoubleLinkedList dll = new DoubleLinkedList();
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            dll.moveToHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            dll.moveToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            dll.addToHead(node);
        }
        checkAndUpdate();
    }

    public void checkAndUpdate() {
        if (dll.size > capacity) {
            int key = dll.removeLastNode();
            map.remove(key);
        }
    }

    public class DoubleLinkedList {
        Node head = new Node((int)1e5 + 1, -1);
        Node tail = new Node((int)1e5 + 1, -1);
        int size = 0;
        
        public DoubleLinkedList() {
            head.next = tail;
            tail.prev = head;
        }

        public void addToHead(Node node) {
            Node first = head.next;
            head.next = node;
            node.prev = head;
            node.next = first;
            first.prev = node;
            size++;
        }

        public int removeLastNode() {
            if (size > 0) {
                Node last = tail.prev;
                Node lastPrev = last.prev;
                lastPrev.next = tail;
                tail.prev = lastPrev;
                size--;
                return last.key;
            }
            return -1;
        }

        public void moveToHead(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
            addToHead(node);
        }
    }

    public class Node {
        int key;
        int val;

        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */