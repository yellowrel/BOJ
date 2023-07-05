import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070 {
    static int cnt = 0;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+2][n+2];

        for (int i = 0; i < n+2; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0]= 1;
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            arr[i][1]= 1;
        }
        arr[1][2] = 2;

        pipe(arr,n,n,3);

        System.out.println(cnt);

    }

    private static void pipe(int[][] arr, int x, int y, int p) { //이전 파이프 p : 1 세로 2가로 3대각선
        if(x < 1 || x > n || y < 1 || y > n || arr[x][y] == 1){
            return;
        }

        if(p==3){
            if(arr[x+1][y] == 1 || arr[x][y+1] == 1){
                return;
            }
        }

        if(arr[x][y] == 2 && p!=1){
            cnt++;
            return;
        }

        switch (p){
            case 1:
                pipe(arr,x-1,y,1);
                pipe(arr,x-1,y-1,3);
                break;
            case 2 :
                pipe(arr,x,y-1,2);
                pipe(arr,x-1,y-1,3);
                break;
            case 3 :
                pipe(arr,x-1,y,1);
                pipe(arr,x,y-1,2);
                pipe(arr,x-1,y-1,3);
                break;
            default:
                break;
        }

    }
}
