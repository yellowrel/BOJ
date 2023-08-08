import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1987 {

    static char[][] board;
    static int r,c,max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        String str;
        boolean[] alpha = new boolean[26];
        max = 0;
        for (int i = 0; i < r; i++) {
            str = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i] = str.toCharArray();
            }
        }

        dfs(0,0,alpha,0);

        System.out.println(max);
    }

    private static void dfs(int x, int y, boolean[] alpha,int d) {
        if(x < 0 || y < 0 || x >= r || y >= c){
            max = Math.max(max,d);
            return;
        }
        if((alpha['Z'-(board[x][y])])){
            max = Math.max(max,d);
            return;
        }
        alpha['Z'-(board[x][y])] = true;
        d++;

        dfs(x+1,y,alpha,d);
        dfs(x-1,y,alpha,d);
        dfs(x,y+1,alpha,d);
        dfs(x,y-1,alpha,d);

        alpha['Z'-(board[x][y])] = false;
    }
}