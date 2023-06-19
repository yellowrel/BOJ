import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {

    static int Blue=0,White=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paperChk(arr,0,n,0,n);
        System.out.println(White);
        System.out.println(Blue);
    }

    private static void paperChk(int[][] arr, int x1, int x2, int y1, int y2) {

        int flag = arr[x1][y1]; // 2 혼합, 1 파랑, 0 하양

        loop:
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (flag != arr[i][j]) {
                    flag = 2;
                    break loop;
                }
            }
        }

        if (flag == 2) {
            paperChk(arr, x1, (x1 + x2) / 2,
                    y1, (y1 + y2) / 2);
            paperChk(arr, (x1 + x2) / 2, x2,
                    y1, (y1 + y2) / 2);
            paperChk(arr, x1, (x1 + x2) / 2,
                    (y1 + y2) / 2, y2);
            paperChk(arr, (x1 + x2) / 2, x2,
                    (y1 + y2) / 2, y2);
        } else if (flag == 1) {
            Blue++;
            return;
        } else if (flag == 0){
            White++;
            return;
        }
    }
}
