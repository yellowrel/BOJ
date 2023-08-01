import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14442 {

    static class Pos {
        int x, y, dist,brCnt;

        public Pos(int x, int y, int dist, int brCnt) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.brCnt = brCnt;
        }
    }
    static int n,m,k;

    static char[][] maze;

    private static final int[] DX = { 0, 1, 0, -1 };
    private static final int[] DY = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        maze = new char[n][m];
        String str;

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(0, 0, 1,0));
        int[][] visitied = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visitied[i][j] = k+1;
            }
        }
        visitied[0][0] = 0;

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

                if(nextX==n-1&&nextY==m-1){
                    return nextDist;
                }
                if (nextY < 0 || nextY >= m || nextX < 0 || nextX >= n) { //외곽 벽
                    continue;
                }
                if(maze[nextX][nextY] == '1' ){ //벽에 닿으면
                    if(brCnt >= k){
                        continue;
                    }
                    brCnt++;
                }
                if(visitied[nextX][nextY] <= brCnt){ // 벽부순 횟수적을때도 못갔음
                    continue;
                }

                que.add(new Pos(nextX, nextY, nextDist,brCnt));
                visitied[nextX][nextY] = brCnt;
            }
        }
        return -1;
    }

}