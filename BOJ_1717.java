import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a,b;
        int max,min;
        String op;

        int[][] arr = new int[n+1][2];

        for (int i = 1; i < n+1; i++) {
            arr[i][0] = i;
            arr[i][1] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            op = st.nextToken();
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            a=parentFind(a,arr);
            b=parentFind(b,arr);

            if(a>b){
                max = a;
                min = b;
            }else{
                max = b;
                min = a;
            }

            if(op.equals("0")){
                arr[max][1] = min;

            }else if(op.equals("1")){

                if(arr[a][1] == arr[b][1]){
                    System.out.println("yes");
                }else{
                    System.out.println("no");
                }
            }
        }

    }

    private static int parentFind(int x, int[][] arr) {
        if (x==arr[x][1]){
            return x;
        }
        else{
            int y = parentFind(arr[x][1],arr);
            arr[x][1] = y;
            return y;
        }
    }
}
