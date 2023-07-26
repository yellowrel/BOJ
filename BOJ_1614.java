import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1614 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int finger = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        long answer = 0;
        boolean odd = false;

        switch (finger) {
            case 1:
            case 5:
                answer = num * 8L;
                break;
            case 2:
            case 3:
            case 4:
                answer = (num / 2) * 8L;
                break;
            default:
                break;
        }
        answer = Math.max(answer, 0);
        if (num % 2 == 0) {
            odd = true;
        }

        switch (finger) {
            case 1:
                break;
            case 2:
                if (odd) {
                    answer += 1;
                } else {
                    answer += 7;
                }
                break;
            case 3:
                if (odd) {
                    answer += 2;
                } else {
                    answer += 6;
                }
                break;
            case 4:
                if (odd) {
                    answer += 3;
                } else {
                    answer += 5;
                }
                break;
            case 5:
                answer += 4;
                break;
            default:
                break;
        }

        System.out.println(answer);


    }
}
