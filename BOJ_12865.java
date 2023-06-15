import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[101][100001];
        int[] w = new int[101];
        int[] v = new int[101];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {

                if (w[i] > j)
                    arr[i][j] = arr[i - 1][j];
                else
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - w[i]] + v[i]);
            }
        }

        System.out.println(arr[n][k]);

    }
}
