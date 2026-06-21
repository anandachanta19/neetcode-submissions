class TimeMap {
    HashMap<String, List<valueTimeSet>> map;

    class valueTimeSet {
        String value;
        int timeStamp;
        
        public valueTimeSet(String value, int timestamp) {
            this.value = value;
            this.timeStamp = timestamp;
        }
    }

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!this.map.containsKey(key)) {
            List<valueTimeSet> vtList = new ArrayList<>();
            vtList.add(new valueTimeSet(value, timestamp));
            this.map.put(key, vtList);
        } else {
            List<valueTimeSet> newvtList = this.map.get(key);
            newvtList.add(new valueTimeSet(value, timestamp));
            this.map.put(key, newvtList);
        }

    }
    
    public String get(String key, int timestamp) {
        if (!this.map.containsKey(key)) {
            return "";
        }
        List<valueTimeSet> currentList = this.map.get(key);
        int n = currentList.size();
        int left = 0;
        int right = n - 1;
        String result = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            valueTimeSet pair = currentList.get(mid);
            if (pair.timeStamp <= timestamp) {
                result = pair.value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */