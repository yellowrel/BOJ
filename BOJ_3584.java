import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3584 {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int a, b;

        for (int i = 0; i < n; i++) {
            arr = new int[2][10001]; //index 가 기본값이고 0 이 부모노드 1이 lev
            int m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m - 1; j++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                arr[0][b] = a;
            }
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            int aLev = parent(a); int bLev = parent(b); // 부모노드까지 lev 계산

            if(aLev< bLev){
                for (int j = 0; j < (bLev - aLev); j++) {
                    b = arr[0][b];
                }
            }else if(aLev > bLev){
                for (int j = 0; j < (aLev - bLev); j++) {
                    a = arr[0][a];
                }
            }
            while(a!=b){
                a= arr[0][a];
                b= arr[0][b];
            }
            System.out.println(a);
        }
    }

    private static int parent(int a) {
        if (arr[1][a] != 0)  // 렙 값이 이미 정해져있으면 그만돔
            return arr[1][a];
        if (arr[0][a] == 0) {// 부모 노드가 없으면
            arr[1][a] = 1;
            return 1;
        }

        arr[1][a] = parent(arr[0][a]) + 1;

        return arr[1][a];
    }
}