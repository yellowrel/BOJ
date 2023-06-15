import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2141 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long sum =0;
        long flag =0;
        long[][] arr = new long[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
            sum += arr[i][1];
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Long.compare(o1[1], o2[1]);
            } else {
                return Long.compare(o1[0],o2[0]);
            }
        });


        for (int i = 0; i < n; i++) {
            flag += arr[i][1];
            if(flag >= (sum+1)/2){
                System.out.println(arr[i][0]);
                break;
            }
        }

    }
}
