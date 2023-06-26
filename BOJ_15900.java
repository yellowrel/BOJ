import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15900 {

    static int move = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        int x,y;

        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList();
        }



        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        dfs(list,visited,1, -1);

        if(move%2 == 1){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }

    private static void dfs(ArrayList<Integer>[] list, boolean[] visited, int k, int cnt) {

        visited[k] = true;
        boolean leaf=false;

        cnt++;

        for (Integer item : list[k]){
            if(visited[item] == false) {
                leaf = true;
                dfs(list, visited, item, cnt);
            }
        }

        if(!leaf){
            move += cnt;
        }
    }
}
