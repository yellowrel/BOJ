import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int walk =0;
        int flag =0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if(arr[i]>0){
                flag = i;
                break;
            }
        }

        if(flag == 0){
            if(arr[0]<0){
                for (int i = 0; i < n; i += m) {
                    walk += arr[i] * 2;
                }
                walk -= arr[0];
                walk = -walk;
            }else{
                for (int i = n - 1; i >= 0; i -= m) {
                    walk += arr[i] * 2;
                }
                walk -= arr[n-1];
            }

        }else {

            for (int i = 0; i < flag; i += m) {
                walk -= arr[i] * 2;
            }

            for (int i = n - 1; i >= flag; i -= m) {
                walk += arr[i] * 2;
            }

            walk -= Math.abs(arr[0]) > Math.abs(arr[n - 1]) ? Math.abs(arr[0]) : Math.abs(arr[n - 1]);

        }
        System.out.println(walk);
    }
}
