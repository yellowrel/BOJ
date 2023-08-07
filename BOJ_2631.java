import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2631 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] d = new int[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if(arr[j] < arr[i]){
                    max = Math.max(d[j],max);
                }
            }
            d[i]=++max;

            answer = Math.max(d[i],answer);
        }

        System.out.println(n-answer);

    }
}
