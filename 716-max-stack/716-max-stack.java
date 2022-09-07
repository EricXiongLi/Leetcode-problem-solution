class MaxStack {
    //5,4,3, 6, 5
    //3, 4, 5, 6
    //
    DoubleLinkedList dl;
    TreeMap<Integer, List<Node>> map;
    
    public MaxStack() {
        dl = new DoubleLinkedList();
        map = new TreeMap<>();
    }
    
    public void push(int x) {
        Node node = new Node(x);
        dl.add(node);
        map.computeIfAbsent(x, v -> new ArrayList<Node>()).add(node);
    }
    
    public int pop() {
        Node lastNode = dl.removeLast();
        int popVal = lastNode.val;
        List<Node> list = map.get(popVal);
        list.remove(list.size() - 1);
        if (list.isEmpty()) {
            map.remove(popVal);
        }
        return lastNode.val;
    }
    
    public int top() {
        return dl.tail.prev.val;
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int maxVal = map.lastKey();
        List<Node> list = map.get(maxVal);
        Node node = list.get(list.size() - 1);
        int sz = list.size();
        list.remove(sz - 1);
        if (list.isEmpty()) {
            map.remove(maxVal);
        }
        dl.remove(node);
        return maxVal;
    }
}

class Node {
    Node prev;
    Node next;
    int val;
    
    public Node(int val) {
        this.val = val;
    }
    
    
}

class DoubleLinkedList {
    Node head;
    Node tail;
    
    public DoubleLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        tail.next = head;
        head.prev = tail;
    }
    
    public void add(Node node) {
        node.next = tail;
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        tail.prev = node;
    }
    
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public Node removeLast() {
        Node prev = tail.prev;
        remove(prev);
        tail.prev = prev.prev;
        return prev;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */