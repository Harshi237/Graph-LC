import java.util.ArrayList;
import java.util.List;

public class LC_1791 {
    public int findCenter(int[][] edges) {
        int V = edges.length+1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0; i<=V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[]e: edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i =1; i<=V; i++){
            if(adj.get(i).size() == V-1)
                return i;
        }
        return -1;
    }
}
