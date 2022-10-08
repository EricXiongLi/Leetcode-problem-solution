class MyHashMap {
    
    static final int SIZE = 100007;
    static final int MUL = 199997;
    ListNode[] data;
    
    int hash(int key) {
        return (int)((long) SIZE * MUL % SIZE);
    }
    public MyHashMap() {
        data = new ListNode[SIZE];
    }
    
    public void put(int key, int value) {
        remove(key);
        int h = hash(key);
        ListNode newNode = new ListNode(key, value, data[h]);
        data[h] = newNode;
    }
    
    public int get(int key) {
        int h = hash(key);
        ListNode ptr = data[h];
        while (ptr != null) {
            if (ptr.key == key) {
                return ptr.val;
            }
            ptr = ptr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int h = hash(key);
        ListNode ptr = data[h];
        if (ptr == null) return;
        if (ptr.key == key) {
            data[h] = ptr.next;
            return;
        }
        while (ptr != null && ptr.next != null && ptr.next.key != key) {
            ptr = ptr.next;
        }
        if (ptr == null || ptr.next == null) return;
        ptr.next = ptr.next.next;
        return;
    }
}

class ListNode {
    int key;
    int val;
    ListNode next;
    
    public ListNode(int key, int val, ListNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


