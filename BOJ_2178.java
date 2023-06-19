import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_2178 {

    static class Pos {
        int r, c, dist;
        public Pos(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    private static final int[] DR = {1, 0, -1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] maze = new char[n][m];
        boolean[][] visitied = new boolean[n][m];
        Queue<Pos> que = new LinkedList<>();

        String str;
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j);
                if(maze[i][j] == '0'){
                    visitied[i][j]= true;
                }
            }
        }

        que.add(new Pos(0,0,1));
        visitied[0][0] = true;

        while(!que.isEmpty()){
            Pos cur = que.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + DR[i];
                int nextC = cur.c + DC[i];
                int nextDist = cur.dist + 1;

                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= m || visitied[nextR][nextC] || maze[nextR][nextC] == '0'){
                    continue;
                }

                if(nextR==n-1 && nextC == m-1){
                    System.out.println(nextDist);
                    return;
                }

                que.add(new Pos(nextR,nextC,nextDist));
                visitied[nextR][nextC] = true;

            }

        }
        System.out.println(-1);


    }
}
