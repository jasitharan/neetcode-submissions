class TimeMap {

    private Map<String,List<Pair<Integer,String>>> timeMaps;

    public TimeMap() {
        timeMaps = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        timeMaps.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if (!timeMaps.containsKey(key)) {
            return "";
        }

        List<Pair<Integer, String>> list = timeMaps.get(key);
        int left = 0;
        int right = list.size() - 1;

        String result = "";

        while (left<=right) {
            int mid = left + (right - left)/2;

            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;

    }
}

class Pair<T,K> {
    T timestamp;
    K value;

    public Pair(T timestamp,K value) {
         this.timestamp = timestamp;
         this.value = value;
    }
}
