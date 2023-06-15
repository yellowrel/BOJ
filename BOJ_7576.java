import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static int n,m,day=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x=0,y=0;

        int[][] box= new int[n][m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                box[j][i] = Integer.parseInt(st.nextToken());
                if(box[j][i] == 1){
                    x = j;
                    y = i;
                }
            }
        }

        box[x][y] = 0;

        int cnt =0;
        cnt = ripe(box,x,y,cnt);

        System.out.println("cnt= "+cnt);

    }

    private static int ripe(int[][] box, int x, int y, int cnt) {
        if(x<0|| y<0|| x>= n|| y >=m ) {
            return cnt;
        }

        if(box[x][y]== 1 || box[x][y] == -1){
            return cnt;
        }

        box[x][y] = 1;

        ripe(box, x+1, y, cnt);
        ripe(box, x, y+1, cnt);
        ripe(box, x-1, y, cnt);
        ripe(box, x, y-1, cnt);

        return ++cnt;
    }

}
