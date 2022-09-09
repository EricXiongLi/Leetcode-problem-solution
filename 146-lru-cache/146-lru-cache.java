class LRUCache {
    
    int capacity;
    Map<Integer, Node> map;
    DoubleLinkedList dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dll = new DoubleLinkedList();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        dll.remove(node);
        dll.add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        //1. put the pair into the map
        //2. put the node in the head of double linkedlist
           //if exceeds the size => delete tail, delete the pari in map;
            //
        boolean alreadyContains = false;
        if (dll.tail.prev.key == key) {
            alreadyContains = true;
        }
        if (map.containsKey(key)) {
            dll.remove(map.get(key));
        }
        Node node = new Node(key, value);
        map.put(key, node);
        dll.add(node);
        if (dll.size > capacity) {
            Node last = dll.removeLast();
            if (!alreadyContains) {
                map.remove(last.key);
            }
        }
    }
}

class DoubleLinkedList {
    int size;
    Node head;
    Node tail;
    
    public DoubleLinkedList() {
        size = 0;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        head.prev = tail;
        tail.next = head;
        tail.prev = head;
    }
    
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
    }
    
    public Node removeLast () {
        Node last = tail.prev;
        Node lastPrev = tail.prev.prev;
        lastPrev.next = tail;
        tail.prev = lastPrev;
        size--;
        return last;
    }
    
    public void add(Node node) {
        Node headNext = head.next;
        headNext.prev = node;
        node.next = headNext;
        node.prev = head;
        head.next = node;
        size++;
    }
}

class Node {
    Node prev;
    Node next;
    int val;
    int key;
    
    public Node(int key, int val) {
        this.val = val;
        this.key = key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */