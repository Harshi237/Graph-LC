public class LC_1791 {
    public int findCenter(int[][] edges) {
        int V = edges.length;
        int[] inDegree = new int[V+2];

        for(int[]e : edges){
            int u= e[0];
            int v = e[1];
            inDegree[u]++;
            inDegree[v]++;

        }
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i]==V)
                return i;
        }
        return -1;
    }
}
