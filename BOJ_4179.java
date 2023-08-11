import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {

    static class Pos {
        int x, y, dist;

        public Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static class Fire {
        int x,y,d;

        public Fire(int x, int y,int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static int n,m;

    static char[][] maze;
    static int[][] fireMaze;

    private static final int[] DX = { 0, 1, 0, -1 };
    private static final int[] DY = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x=0,y=0;

        maze = new char[n][m];
        fireMaze = new int[n][m];
        String str;

        Queue<Fire> fire = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j);
                if(maze[i][j]=='J'){
                    x = i; y = j;
                }
                if(maze[i][j]=='F'){
                    fire.add(new Fire(i,j,1));
                    fireMaze[i][j] = 1;
                }
            }
        }

        fBfs(fire);

        int answer = bfs(x,y);

        if( answer == -1){
            System.out.println("IMPOSSIBLE");
        }else {
            System.out.println(answer);
        }
    }

    private static int bfs(int x, int y) {
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(x, y, 0));
        boolean[][] visitied = new boolean[n][m];

        visitied[x][y] = true;

        while (!que.isEmpty()) {

            Pos cur = que.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + DX[i];
                int nextY = cur.y + DY[i];
                int nextDist = cur.dist + 1;


                if (nextY < 0 || nextY >= m || nextX < 0 || nextX >= n) { //탈출
                    return nextDist;
                }

                if (maze[nextX][nextY] == '#' || maze[nextX][nextY] == 'F' || visitied[nextX][nextY]) { //벽 or 불에 닿으면 or 이미옴 or 이미 불남
                    continue;
                }

                if(nextDist+1>=fireMaze[nextX][nextY] && fireMaze[nextX][nextY] !=0){ //불체크
                    continue;
                }

                visitied[nextX][nextY] = true;
                que.add(new Pos(nextX, nextY, nextDist));
            }
        }
        return -1;
    }

    private static int fBfs(Queue<Fire> fire) {


        while (!fire.isEmpty()) {

            Fire cur = fire.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + DX[i];
                int nextY = cur.y + DY[i];
                int nextDist = cur.d + 1;

                if (nextY < 0 || nextY >= m || nextX < 0 || nextX >= n) { //벽 닿음
                    continue;
                }

                if (maze[nextX][nextY] == '#' || maze[nextX][nextY] == 'F' || fireMaze[nextX][nextY] != 0) { //벽 or 불에 닿으면
                    continue;
                }

                fireMaze[nextX][nextY] = nextDist;

                fire.add(new Fire(nextX, nextY, nextDist));
            }
        }
        return -1;
    }

}