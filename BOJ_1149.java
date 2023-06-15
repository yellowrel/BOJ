import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0][0] = Integer.parseInt(st.nextToken());
        arr[0][1] = Integer.parseInt(st.nextToken());
        arr[0][2] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken()) + Math.min(arr[i-1][1],arr[i-1][2]);
            arr[i][1] = Integer.parseInt(st.nextToken()) + Math.min(arr[i-1][0],arr[i-1][2]);
            arr[i][2] = Integer.parseInt(st.nextToken()) + Math.min(arr[i-1][1],arr[i-1][0]);
        }

        System.out.println(Math.min(arr[n-1][0],Math.min(arr[n-1][1],arr[n-1][2])));

    }
}
