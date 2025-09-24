class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        //<stop, [bus contains this stop]>
        Map<Integer, List<Integer>> stopToBus = new HashMap<>();
        if (source == target) return 0;

        for (int bus = 0; bus < routes.length; bus++) {
            int[] route = routes[bus];
            for (int stop : route) {
                stopToBus.computeIfAbsent(stop, v -> new ArrayList<Integer>()).add(bus);
            }
        }

        //add all the stops of those bus who contains the source
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        //add all stops who share the same bus with the source
        List<Integer> sourceBuses = stopToBus.getOrDefault(source, new ArrayList<Integer>());
        
        List<Integer> targetBuses = stopToBus.getOrDefault(target, new ArrayList<Integer>());
        if (sourceBuses.size() == 0 || targetBuses.size() == 0) return -1;
        int level = 1;

        for (int bus : sourceBuses) {
            for (int stop : routes[bus]) {
                if (stop == target) return level;
                if (!visited.contains(stop)) {
                    visited.add(stop);
                    queue.offer(stop);
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            
            for (int i = 0; i < size; i++) {
                int curStop = queue.poll();
                //choose neighbors

                List<Integer> buses = stopToBus.getOrDefault(curStop, new ArrayList<Integer>());

                for (int bus : buses) {
                    for (int stop : routes[bus]) {
                        if (stop == target) return level;
                        if (!visited.contains(stop)) {
                            
                            queue.offer(stop);
                            visited.add(stop);
                        }
                    }
                }
            }
        }

        return -1;
    }
}