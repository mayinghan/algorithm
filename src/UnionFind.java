public class UnionFind {
    int[] parent;
    int count;

    public UnionFind(int count) {
        parent = new int[count];
        this.count = count;
        for(int i = 0; i < count; i++) {
            parent[i] = i;
        }
    }

    // find parent
    public int find(int p) {
        // path compression
        if(p != parent[p]) {
            parent[p] = find(parent[p]);
        }

        return parent[p];
    }

    // union
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        parent[pRoot] = qRoot;
    }

    // check if two elements are connected
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
