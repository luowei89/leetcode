public class LRUCache {
    private Integer[] keys;
    private int[] values;
    private int[] used;
    private int clock;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keys = new Integer[capacity];
        this.values = new int[capacity];
        this.used = new int[capacity];
        this.clock = 0;
    }
    
    public int get(int key) {
        int index = find(key);
        if(index != -1){
            used[index] = ++clock;
            return values[index];
        }
        return -1;
    }
    
    public void set(int key, int value) {
        int index = find(key);
        if(index == -1){
            index = 0;
            int leastUsed = used[0];
            for(int i = 1; i < this.capacity; i++){
                if(used[i] < leastUsed){
                    leastUsed = used[i];
                    index = i;
                }
            }
            this.keys[index] = key;
        }
        this.values[index] = value;
        this.used[index] = ++clock;
    }
    
    private int find(int key){
        int i = 0;
        while(i < this.capacity){
            if(keys[i] != null && keys[i] == key){
                break;
            }
            i++;
        }
        if(i < this.capacity){
            return i;
        }
        return -1;
    }
}