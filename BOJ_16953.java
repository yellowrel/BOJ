import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cnt = 1;

        while(a!=b) {

            if(b%10 == 1) {
                b /=10;
            }else if(b%2 ==1 || b<=0 ){
                cnt = -1;
                break;
            } else {
                b /= 2;
            }
            cnt++;

        }
        System.out.println(cnt);

    }
}