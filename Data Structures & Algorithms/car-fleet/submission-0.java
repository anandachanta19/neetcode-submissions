class Solution {

    class Car {
        int position;
        int speed;
        double timeTaken;

        public Car(int position, int speed, int target) {
            this.speed = speed;
            this.position = position;
            this.timeTaken = (double) (target - this.position) / (this.speed);
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length; //No of Cars.
        Car[] cars = new Car[n];
        // Making Easy for Sorting.
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i], target);
        }
        Arrays.sort(cars, (a, b) -> b.position - a.position);
        Stack<Double> reachTimes = new Stack<>();
        reachTimes.add(cars[0].timeTaken);
        int fleetCount = 1;
        for (int i = 1; i < n; i++) {
            if (cars[i].timeTaken > reachTimes.peek()) {
                fleetCount++;
                reachTimes.add(cars[i].timeTaken);
            }
        }
        return fleetCount;
    }
}