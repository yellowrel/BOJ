import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        String str = "";
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = 1;
        for (int i = 0; i < n; i++) {
            arr[i][0] = i; // 숫자
            arr[i][1]= Integer.parseInt(st.nextToken()); // 숫자의 가격
        }
        int m = Integer.parseInt(br.readLine());
        int minValue=50,minIdx=0;
        for (int i = 0; i < n; i++) {
            if(minValue>arr[i][1]){
                minValue = arr[i][1];
                minIdx = arr[i][0];
            }
        }
        boolean zero = false;

        int minValue2=50,minIdx2=0;
        if(minIdx == 0){ // 첫글자
            for (int i = 1; i < n; i++) {
                if(minValue2>arr[i][1]){
                    minValue2 = arr[i][1];
                    minIdx2 = arr[i][0];
                }
            }
            str += minIdx2;
            m -= minValue2;
            if(m<0){ // 0만 나올경우
                System.out.println("0");
                System.exit(0);
            }
            zero = true;
        }else{
            str += minIdx;
            m -= minValue;
        }

        while(m>=minValue){ // 자리수 채우기
            str += minIdx;
            m -= minValue;
            len++;
        }

        char[] answer = str.toCharArray();
        int idx=0;

        loop:
        for (int i = n-1; i > minIdx; i--) { //앞자리 부터 큰수로 대체
            if(zero){ // 최소값이 0이었을 경우
                if(m>=(arr[i][1]-minValue2)){
                    answer[idx] = (char) (i + '0');
                    m -= (arr[i][1]-minValue2);
                    idx++;
                    if(idx>=len){
                        break loop;
                    }
                    zero = false;
                    i = n;
                }
            }else {
                while (m >= (arr[i][1] - minValue)) {
                    answer[idx] = (char) (i + '0');
                    m -= (arr[i][1] - minValue);
                    idx++;
                    if (idx >= len) {
                        break loop;
                    }
                }
            }
        }

        for (int i = 0; i < len; i++) {
            System.out.print(answer[i]);
        }

    }
}
