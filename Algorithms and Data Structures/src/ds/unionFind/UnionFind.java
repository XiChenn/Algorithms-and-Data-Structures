package ds.unionFind;

/**
 * Wighted quick-union with path compression (WQUPC), avoid tall trees. It keep
 * track of size of each tree and Balance by linking root of smaller tree to
 * root of larger tree.
 * 
 * For M union-find ops on N objects, in practice, WQUPC is linear although in
 * theory it is not.
 * 
 * Refer to Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne,
 * Addison-Wesley Professional, 2011, ISBN 0-321-57351-X
 * 
 * @author Xi Chen
 * 
 */
public class UnionFind {
    private int[] id; // id[i] is parent of i
    private int[] size; // size[i] track the size of tree at root i
    
    // O(n)
    public UnionFind(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i; // Initialize each id's parent to itself
            size[i] = 1;
        }
    }
    
    /*
     * O(log n) - Find the root of element i.
     * 
     * Path compression - after computing the root of i, set the id of each
     * examined node to point to that root
     */
    private int find(int i) {
        while (id[i] !=  i) {
            id[i] = id[id[i]]; // Points to its grandparent (halving path length)
            //int p = i;
            i = id[i];
            //id[p] = i;
        }
        return i;
    }
    
    // O(log n) - Find whether p and q are connected
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    
    // O(log n) - Connect p and q, link root of smaller tree to root of larger tree
    public void union(int p, int q) {
        int i = find(p); // p's root
        int j = find(q); // q's root
        
        if (i == j) { return; }
        
        if (size[i] < size[j]) {
            id[i] = j; // Connect p's root to q's root
            size[j] += size[i];
        } else {
            id[j] = i; // Connect q's root to p's root
            size[i] += size[j];
        }
    }
}
