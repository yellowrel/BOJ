import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_17267 {

    static class Pos {
        int r, c, right,left;
        public Pos(int r, int c, int right, int left) {
            this.r = r;
            this.c = c;
            this.right = right;
            this.left = left;

        }
    }

    private static final int[] DR = {1, -1, 0, 0};
    private static final int[] DC = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int lp  = Integer.parseInt(st.nextToken());
        int rp = Integer.parseInt(st.nextToken());
        int cnt=0;

        int x=0,y=0;
        char[][] ground = new char[n][m];
        boolean[][] visitied = new boolean[n][m];
        Queue<Pos> que = new LinkedList<>();

        String str;
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < m; j++) {
                ground[i][j] = str.charAt(j);
                if(ground[i][j] == '2'){
                    visitied[i][j]= true;
                    x=i; y=j;
                }
            }
        }

        que.add(new Pos(x,y,rp,lp));

        while(!que.isEmpty()){
            Pos cur = que.poll();

            loop:
            for (int i = 0; i < 2; i++) {
                int nextR = cur.r;
                int nextC = cur.c;
                while(true) {
                    nextR += DR[i];
                    int nextRp = cur.right;
                    int nextLp = cur.left;
                    if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m || visitied[nextR][nextC] || ground[nextR][nextC] == '1') {
                        continue loop;
                    }
                    visitied[nextR][nextC] = true;
                    que.add(new Pos(nextR, nextC, nextRp, nextLp));
                }
            }

            for (int i = 2; i < 4; i++) {
                int nextR = cur.r;
                int nextC = cur.c + DC[i];
                int nextRp = cur.right;
                int nextLp = cur.left;

                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= m || visitied[nextR][nextC] || ground[nextR][nextC] == '1'){
                    continue;
                }

                if(i == 2){
                    nextRp--;
                }else if(i == 3){
                    nextLp--;
                }

                if(nextLp < 0 || nextRp < 0){
                    continue;
                }

                que.add(new Pos(nextR,nextC,nextRp,nextLp));
                visitied[nextR][nextC] = true;

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(visitied[i][j]){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
}
