class ProductOfNumbers {
    List<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            list.clear();
            list.add(1);
        } else {
            int sz = list.size();
            list.add(list.get(sz - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        int sz = list.size();
        if (sz - 1 < k) {
            return 0;
        }
        return list.get(sz - 1) / list.get(sz - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */