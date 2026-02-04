public class LC_1791 {
    public int findCenter(int[][] edges) {
        int V = edges.length;
        int a = edges[0][0];
        int b = edges[0][1];
        int c = edges[1][0];
        int d = edges[1][1];

        if(a==c || a==d)
            return a;
        return b;


    }
}
