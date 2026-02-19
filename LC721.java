import java.util.HashMap;
import java.util.List;

public class LC721 {
    class Solution {
        int[] parent ;
        int[] rank;
        static int components;
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            //giving unique id to emails
            HashMap<String, Integer> emailToId = new HashMap<>();
            // assign account name with emails
            HashMap<String, String> emailToName = new HashMap<>();

            int id = 0;
            for(List<String> acc : accounts){
                String name = acc.get(0);
                for(int i=1; i<acc.size(); i++){

                    String email = acc.get(i);
                    if(!emailToId.containsKey(email));
                    {
                        emailToId.put(email, id++);
                    }
                    emailToName.put(email,name);
                }
            }
            components = id;
            parent = new int[id];
            rank = new int[id];

            for(int i=0; i<id ; i++){
                parent[i] = i;
                rank[i] = 0;
            }

            // merge same account's mail

            for(List<String> acc : accounts){
                if(acc.size() <= 2) continue;

                int firstAccId = emailToId.get(acc.get(1));// email nikal ke uski id nikali (first acc id)
                for(int k =2; k<acc.size(); k++){// merge first account mail to all
                    unionRank(firstAccId , emailToId.get(acc.get(k)));
                }
            }
            //connection done

            // now returning part

            //add all connected mails
            HashMap<Integer, List<String>> groupToId = new HashMap<>();
            for(String email : emailToId.keySet()){
                int EmailId = emailToId.get(email);
                int root = find(EmailId);
                //if mail id nhi aaya the empty list bna ke add kr do wo mail ko
                if(!groupToId.containsKey(root)){
                    groupToId.put(root, new ArrayList<>());

                }
                // otherwise usi arraylist mei add kr denge
                groupToId.get(root).add(email);
            }

            //final
            List<List<String>> result = new ArrayList<>();
            for(Integer node : groupToId.keySet()){
                List<String> merge = groupToId.get(node);
                Collections.sort(merge);
                List<String> ans = new ArrayList<>();

                ans.add(emailToName.get(merge.get(0)));

                ans.addAll(merge);
                result.add(ans);
            }
            return result;
        }
        public int find(int x){
            if(x==parent[x]) return x;
            return parent[x]= find(parent[x]);
        }
        public boolean unionRank(int x, int y){
            int p_x = find(x);
            int p_y = find(y);
            if(p_x == p_y){
                return false;
            }
            if(rank[p_x]> rank[p_y]){
                parent[p_y] = p_x;
            }
            else if(rank[p_x]> rank[p_y]){
                parent[p_x] = p_y;
            }
            else{
                parent[p_x]=p_y;
                rank[p_y]++;
            }
            components--;
            return true;
        }
    }
}
