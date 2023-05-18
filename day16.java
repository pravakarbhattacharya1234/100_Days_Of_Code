//1579. Remove Max Number of Edges to Keep Graph Fully Traversable

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int numRemoved = 0;
        
        // First, add all type-3 edges
        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1] - 1;
            int v = edge[2] - 1;
            if (type == 3) {
                if (!alice.union(u, v) || !bob.union(u, v)) {
                    numRemoved++;
                }
            }
        }
        
        // Then, add type-1 edges for Alice
        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1] - 1;
            int v = edge[2] - 1;
            if (type == 1) {
                if (!alice.union(u, v)) {
                    numRemoved++;
                }
            }
        }
        
        // Finally, add type-2 edges for Bob
        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1] - 1;
            int v = edge[2] - 1;
            if (type == 2) {
                if (!bob.union(u, v)) {
                    numRemoved++;
                }
            }
        }
        
        // Check if both Alice and Bob can traverse the graph
        if (alice.getNumSets() > 1 || bob.getNumSets() > 1) {
            return -1;
        }
        
        return numRemoved;
    }
}

class UnionFind {
    private int[] parent;
    private int numSets;
    
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        numSets = n;
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return false;
        }
        parent[px] = py;
        numSets--;
        return true;
    }
    
    public int getNumSets() {
        return numSets;
    }
}
