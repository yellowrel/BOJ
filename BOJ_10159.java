import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10159 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n+1][n+1];  // [작은값][큰값]
        StringTokenizer st;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = true;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(arr[i][j]){
                    for (int k = 1; k < n+1; k++) {
                        if(arr[j][k]){
                            arr[i][k] = true;
                        }
                        if(arr[k][i]){
                            arr[k][j] = true;
                        }
                    }
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            int cnt = n-1;
            for (int j = 1; j < n+1; j++) {
                if(i==j){
                    continue;
                }
                if(arr[j][i]){
                    cnt--;
                }

                if(arr[i][j]){
                    cnt--;
                }
            }
            System.out.println(cnt);
        }
    }
}
