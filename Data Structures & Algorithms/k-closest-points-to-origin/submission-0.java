class Solution {
    public int squaredDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        int noOfPoints = points.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> squaredDistance(b) - squaredDistance(a)
        );
        for (int[] point: points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}