class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxPile = 0;
        for (int i = 0; i < n; i++) {
            maxPile = Math.max(piles[i], maxPile);
        }
        // System.out.println("The Max Pile: " + maxPile);
        int left = 1;
        int right = maxPile;
        while (left < right) {
            int mid = (left + right) / 2;
            // System.out.println("Current Mid: " + mid);
            int hoursSpent = 0;
            for (int pile: piles) {
                hoursSpent += -Math.floorDiv(-pile, mid);
            }
            // System.out.println("The Hour spent to complete bananas with " + mid + " as speed: " + hoursSpent);
            if (hoursSpent <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}