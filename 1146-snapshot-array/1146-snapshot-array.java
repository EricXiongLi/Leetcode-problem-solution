class SnapshotArray {
    TreeMap<Integer, Integer>[] records;
    int snapId = 0;
    
    public SnapshotArray(int length) {
        //tc: O(n)
        //sc: O(n)
        records = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            records[i] = new TreeMap();
            records[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        //tc: O(logK)
        //sc: O(1)
        records[index].put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        //tc:O(logK)
        //sc:O(1)
        return records[index].floorEntry(snap_id).getValue();
    }
}

//tc: O(nlogk)
//sc: O(n)

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */