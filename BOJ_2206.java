import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {

    static class Pos {
        int x, y, dist,brCnt;

        public Pos(int x, int y, int dist, int brCnt) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.brCnt = brCnt;
        }
    }
    static int n,m;

    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][] maze = new char[n][m];
        String str;

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs(maze));
    }

    private static int bfs(char[][] maze) {
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(0, 0, 1,0));
        boolean[][] visitied = new boolean[n][m];
        boolean[][] visitiedBreak = new boolean[n][m];
        visitied[0][0] = true;
        visitiedBreak[0][0] = true;

        if(n==1&&m==1){
            return 1;
        }
        while (!que.isEmpty()) {
            Pos cur = que.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + DX[i];
                int nextY = cur.y + DY[i];
                int nextDist = cur.dist + 1;
                int brCnt = cur.brCnt;

                if (nextY < 0 || nextY >= m || nextX < 0 || nextX >= n ) {
                    continue;
                }

                if(brCnt == 1){ // 벽 못뚫음
                    if(maze[nextX][nextY] == '1' || visitiedBreak[nextX][nextY]){
                        continue;
                    }
                    if(nextX==n-1&&nextY==m-1){
                        return nextDist;
                    }
                    que.add(new Pos(nextX, nextY, nextDist,brCnt));
                    visitiedBreak[nextX][nextY] = true;
                }else{ // 벽뚫는 기회있음
                    if(visitied[nextX][nextY]){
                        continue;
                    }
                    if(maze[nextX][nextY] == '1' ){ //벽에 닿으면
                        brCnt++;
                    }
                    if(nextX==n-1&&nextY==m-1){
                        return nextDist;
                    }
                    que.add(new Pos(nextX, nextY, nextDist,brCnt));
                    visitied[nextX][nextY] = true;
                }
            }
        }
        return -1;
    }

}
