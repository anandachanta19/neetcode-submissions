class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stoneWeight: stones) {
            maxHeap.add(stoneWeight);
        }
        while (maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if (x == y) {
                continue;
            } else {
                maxHeap.add(Math.abs(y - x));
            }
        }
        return maxHeap.size() == 1 ? maxHeap.poll() : 0;
    }
}