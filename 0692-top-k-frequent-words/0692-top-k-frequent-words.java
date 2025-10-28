class Solution {
    class Word implements Comparable<Word> {
        private String word;
        private int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }

        public int compareTo(Word other) {
            if (this.count == other.count) {
                return this.word.compareTo(other.word);
            }
            return other.count - this.count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        List<Word> candidates = new ArrayList<>();
        for (var entry : cnt.entrySet()) {
            candidates.add(new Word(entry.getKey(), entry.getValue()));
        }

        Queue<Word> h = new PriorityQueue<>(candidates);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(h.poll().word);
        }
        return res;

    }
}