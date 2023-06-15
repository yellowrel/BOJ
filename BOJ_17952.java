import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17952 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        int chk,idx,score=0;
        int[][] arr = new int[num][2];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            chk = Integer.parseInt(st.nextToken());
            if(chk == 0){
                continue;
            }
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }

        loop:
        for (int i = 0; i < num; i++) {
            idx = i;
            while(arr[idx][1] <= 0) {
                idx--;
                if (idx == -1) {
                    continue loop;
                }
            }
            arr[idx][1] -= 1;
            if(arr[idx][1] == 0){
                score += arr[idx][0];
            }
        }
        System.out.println(score);
    }
}
