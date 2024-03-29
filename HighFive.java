class HighFive {
    // https://leetcode.com/problems/high-five/
    // 1086. High Five

    // 重写了最大堆
    public int[][] highFive(int[][] items) {
        List<int[]> _res = new ArrayList<>();
        if (items == null || items.length == 0 || items[0].length == 0) {
            return items;
        }
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int m = items.length; 
        for (int i = 0; i < m; i++) {
            map.putIfAbsent(items[i][0], new PriorityQueue<>((n1, n2) -> n2 - n1));
            map.get(items[i][0]).add(items[i][1]);
        }
        int[][] res = new int[map.size()][2];
        for (Integer id : map.keySet()) {
            PriorityQueue<Integer> curr = map.get(id);
            int sum = 0;
            if (curr.size() >= 5) {
                for (int i = 0; i < 5; i++) {
                    sum += curr.poll();
                }
                sum /= 5;
            } else {
                int size = curr.size();
                while(!curr.isEmpty()) {
                    sum += curr.poll();
                }
                sum /= size;
            }
            _res.add(new int[] {id, sum});
        }
        for (int i = 0; i < _res.size(); i++) {
            res[i] = _res.get(i);
        }
        return res;
    }

    //或者用最小堆，维持size 5, 大于5时poll 堆顶，最后就是5个最大的
    public int[][] highFiveII(int[][] items) {
        if (items == null || items.length == 0) {
            return new int[1][1];
        }
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            map.putIfAbsent(id, new PriorityQueue<>());
            map.get(id).add(score);
            if (map.get(id).size() > 5) {
                map.get(id).poll();
            }
        }
        
        int[][] res = new int[map.size()][2];
        int i = 0;
        for (int id : map.keySet()) {
            int sum = 0;
            int size = map.get(id).size();
            while (!map.get(id).isEmpty()) {
                sum += map.get(id).poll();
            }
            res[i++] = new int[] {id, sum/size};
        }
        return res;
    }
}