import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_16236 {

    static class Pos {
        int c, r, dist;

        public Pos(int c, int r, int dist) {
            this.c = c;
            this.r = r;
            this.dist = dist;
        }
    }

    static int n, size = 2, time;

    private static final int[] DC = {1, 0, -1, 0};
    private static final int[] DR = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int x = 0, y = 0;
        int feed = 0;
        Pos cur;

        int[][] sea = new int[n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) {
                    x = i;
                    y = j;
                    sea[i][j] = 0;
                }
            }
        }

        while(true) {
            cur = bfs(x, y, sea); // 먹이 먹은위치 반환
            x = cur.c;
            y = cur.r;
            sea[x][y] = 0;
            time += cur.dist;
            feed++;
            if (feed == size) {
                size++;
                feed = 0;
            }

            if(cur.dist == 0){
                System.out.println(time);
                System.exit(0);
            }
        }

    }

    private static Pos bfs(int x, int y, int[][] sea) {
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(x, y, 0));
        int[][] range = new int[n][n];
        boolean[][] visitied = new boolean[n][n];
        visitied[x][y] = true;
        int min = n*n;

        while (!que.isEmpty()) {
            Pos cur = que.poll();
            for (int i = 0; i < 4; i++) {
                int nextC = cur.c + DC[i];
                int nextR = cur.r + DR[i];
                int nextDist = cur.dist + 1;

                if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n || visitied[nextC][nextR] || sea[nextC][nextR] > size) {
                    continue;
                }

                if (sea[nextC][nextR] < size && sea[nextC][nextR] > 0) { //먹이 먹은 거리 테이블을 저장
                    range[nextC][nextR] = nextDist;
                }

                que.add(new Pos(nextC, nextR, nextDist));
                visitied[nextC][nextR] = true;

            }
        }

        Pos feed = new Pos(x,y,0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(range[i][j] < min && range[i][j]!=0){
                    min = range[i][j];
                    feed = new Pos(i,j,min);
                }
            }
        }

        return feed;
    }

}
