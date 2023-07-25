import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {

    static int[] arr;
    static int a1,a2,min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        a1=0; a2=n-1; min=Math.abs(arr[0]+arr[n-1]);

        sch(0,n-1);
        System.out.println(arr[a1]+" "+arr[a2]);

    }

    private static void sch(int v1, int v2) {

        if(v1==v2){
            return;
        }
        if(Math.abs(arr[v1]+arr[v2])<min){
            a1=v1; a2=v2;
            min=Math.abs(arr[v1]+arr[v2]);
        }

        if(Math.abs(arr[v1+1]+arr[v2]) <= Math.abs(arr[v1]+arr[v2-1])){
            sch(++v1,v2);
        }else{
            sch(v1,--v2);
        }
    }
}
