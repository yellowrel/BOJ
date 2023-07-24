import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_1071 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num=0;
        int[] arr = new int[1001];
        TreeSet<Integer> ts  = new TreeSet<>();
        int[] arr2= new int[1000];


        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(st.nextToken());
            arr[num]++;
            ts.add(num);
        }

        if(n == 1){
            System.out.println(num);
            System.exit(0);
        }


        Iterator iter = ts.iterator();	// Iterator 사용
        int j= 0;
        while(iter.hasNext()) {//값이 있으면 true 없으면 false
            arr2[j]= (int) iter.next();
            j++; // arr2 길이
        }

        System.out.println(Arrays.toString(arr2));

        for (int i = 1; i < j-1; i++) {
            arr2[i] = arr2[i+1];
        }

        int i = 0;
        while(j>0){
            for (int k = 0; k < arr[arr2[i]]; k++) {
                System.out.print(" "+ arr2[i]);
            }
            i+=2;

            for (int k = 0; k < arr[arr2[i]]; k++) {
                System.out.print(" "+ arr2[i]);
            }
            i--;

            for (int k = 0; k < arr[arr2[i]]; k++) {
                System.out.print(" "+ arr2[i]);
            }

            i+=2;

            j-=3;
        }



        /*
        맨뒤에는 두번째로 작은값을 넣고 제외

        앞에서부터 3개로나눠서 가장 작은값  3번째로 작은값 2번째로 작은값
        132 465 798
        이렇게 넣고 연속가능하면 무조건 연속
        */

    }
}
