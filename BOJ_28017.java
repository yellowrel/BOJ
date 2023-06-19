import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_28017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[] weapon = new int[m];
        int minTime;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[0][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                weapon[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < m; j++) {
                minTime = 5000000;
                for (int k = 0; k < m; k++) {
                    if(k == j){
                        continue;
                    }
                    minTime = Math.min(arr[i-1][k],minTime);
                }
                arr[i][j] += weapon[j] + minTime;
            }

        }

        int timeAttack = arr[n-1][0];

        for (int i = 1; i < m; i++) {
            timeAttack = Math.min(arr[n-1][i],timeAttack);
        }

        System.out.println(timeAttack);

    }
}
