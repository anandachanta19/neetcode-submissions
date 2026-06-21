class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int days = temperatures.length;
        int[] answer = new int[days];
        for (int currentDay = 0; currentDay < days; currentDay++) {
            int followingDay = currentDay + 1;
            boolean isWarmDay = false;
            while (followingDay < days) {
                if (temperatures[currentDay] < temperatures[followingDay]) {
                    answer[currentDay] = followingDay - currentDay;
                    isWarmDay = true;
                    break;
                } else {
                    followingDay++;
                }
            }
            if (isWarmDay) {
                continue;
            } else {
                answer[currentDay] = 0;
            }
        }
        return answer;
    }
}
