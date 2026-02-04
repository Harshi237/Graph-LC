public class LC_997 {
    public int findJudge(int n, int[][] trust) {

        int[] indegree =  new int[n+1];
        if(n==1) return 1;
        // int[] outdegree = new int[n+1];
        for(int[]e: trust){
            int u = e[0];
            int v = e[1];
            indegree[v]++;
            //outdegree[u]++;
            indegree[u]--;
        }
        for(int i =1; i<=n; i++){
            if(indegree[i]==n-1){ // if we use outdegree also the: if(indegree[i]==n-1 && outdegree[i]==0)
                return i;
            }
        }
        return -1;
    }
}
