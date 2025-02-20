import java.util.*;
import javafx.util.Pair;

class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        this.map = new HashMap<>();

    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair<>(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        // present
        List<Pair<String,Integer>> arr = map.get(key);
        int l = 0; 
        int r = arr.size()-1;

        while(l <= r){
            int mid = l + (r-l)/2;
            int midTime = arr.get(mid).getValue();

            if(midTime == timestamp) return arr.get(mid).getKey();
            else if(midTime < timestamp){
                l = mid + 1;
            }else{
                r = mid -1;
            }
        }
        return r < 0 ? "" : arr.get(r).getKey();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */