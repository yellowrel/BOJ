import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225 {
    static long[] arr = new long[201];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(m==1){
            System.out.println(1);
        } else if (m == 2) {
            System.out.println(n+1);
        }else{
            long sum=0;

            for (int i = 0; i <= n; i++) {
                arr[i] = i+1;
            }

            dp(n,m-2);

            for (int i = 0; i <= n; i++) {
                sum += arr[i];
            }
            sum %= 1000000000;
            System.out.println(sum);
        }

    }

    private static void dp(int n, int m) {

        if(m<=1){
            return;
        }
        for (int i = n; i >= 0; i--) {
            long sum = 0;
            for (int j = i; j >=0 ; j--) {
                sum += arr[j];
            }
            sum %= 1000000000;
            arr[i] = sum;
        }
        dp(n,--m);

    }
}
