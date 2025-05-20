class LFUCache {
    int size;
    int min;
    int cap;
    Map<Integer, Node> nodeMap;
    Map<Integer, DLL> countMap;
    public LFUCache(int capacity) {
        cap = capacity;
        size = 0;
        min = 0;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        update(key);
        return nodeMap.get(key).val;
    }
    
    public void put(int key, int value) {
         if (cap == 0) return;
        Node node = nodeMap.getOrDefault(key, null);
        if (node != null) {
            update(key);
            node.val = value;
        } else {
            if (size == cap) {
                evict();
            }
            Node newNode = new Node(key, value);
            countMap.computeIfAbsent(1, v -> new DLL()).add(newNode);
            nodeMap.put(key, newNode);
            min = 1;
            size++;
        }

        
    }

    public void update(int key) {
        Node node = nodeMap.get(key);

        DLL oldList = countMap.get(node.count);
        oldList.remove(node);
        if (min == node.count && oldList.size == 0) {
            min++;
        }

        node.count++;

        countMap.computeIfAbsent(node.count, v -> new DLL()).add(node); 
    }

    public void evict() {
        Node node = countMap.get(min).removeLast();
        nodeMap.remove(node.key); 
        size--;
    }
}


class Node {
    int key, val, count;
    Node prev, next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.count = 1;
    }
}

class DLL {
    Node head, tail;
    int size = 0;

    public DLL() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    public void add(Node node) {
        Node next = head.next;
        node.next = next;
        node.prev = head;
        next.prev = node;
        head.next = node;
        size++;
    }

    public Node removeLast() {
        if (size == 0) return null;
        Node last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;
        size--;
        return last;
    }

    public Node remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
        return node;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

