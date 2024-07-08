class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        StringBuilder sb = new StringBuilder();
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        for (char c : searchWord.toCharArray()) {
            sb.append(c);
            List<String> suggestion = getSuggestion(products, sb.toString());
            res.add(suggestion);
        }
        
        return res;
    }
    
    public List<String> getSuggestion(String[] products, String word) {
        //<, <, <, =, =, >, >, >
        int n = products.length;
        int l = 0, r = n - 1;
        
        List<String> res = new ArrayList<>();
        while (l <= r) {
            int mid = l + r >> 1;
            if (products[mid].compareTo(word) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        for (int i = l; i < l + 3; i++) {
            if (i < n && products[i].startsWith(word)) {
                res.add(products[i]);
            }
        }
        return res;
        //
    }
}