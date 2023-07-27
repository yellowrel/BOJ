import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1394 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String pw = br.readLine();
        double answer = 0;

        double[] arr = new double[1000001];

        HashMap<Character, Integer> map = new HashMap<>();
        int num = str.length();
        int pwnum = pw.length();
        for (int i = 0; i < num; i++) {
            map.put(str.charAt(i), i + 1);
        }

        arr[0] = 1;
        for (int i = 1; i <pwnum; i++) {
            arr[i]= (arr[i-1]*(num%900528))%900528;
        }

        for (int i = 0; i < pwnum; i++) {
            answer += (map.get(pw.charAt(i)) * arr[pwnum-1-i]);
            answer %= 900528;
        }
        System.out.println((int) answer % 900528);
    }
}

