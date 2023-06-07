// 705. Design HashSet

class MyHashSet {
    private static final int NUM_BUCKETS = 1000;
    private List<List<Integer>> buckets;
    public MyHashSet() {
        buckets = new ArrayList<>(NUM_BUCKETS);
        for (int i = 0; i < NUM_BUCKETS; i++) 
        {
            buckets.add(new ArrayList<>());
        }
    }
    
    public void add(int key) {
        int hash = key % NUM_BUCKETS;
        List<Integer> bucket = buckets.get(hash);
        if (!bucket.contains(key)) 
        {
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int hash = key % NUM_BUCKETS;
        List<Integer> bucket = buckets.get(hash);
        bucket.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int hash = key % NUM_BUCKETS;
        List<Integer> bucket = buckets.get(hash);
        return bucket.contains(key);
    }
}
