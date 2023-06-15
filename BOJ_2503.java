import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2503 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int k,k2;
        int num,s,b,cntS,cntB,answer=0;
        boolean[] chk = new boolean[1000];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            for (int j = 100; j < 988; j++){
                if(j%10==(j/10)%10||j%10 == (j/100)|| (j/10)%10==  (j/100)){
                    chk[j] = true;
                }
                if(j%10==0 || (j/10)%10==0){
                    chk[j] = true;
                }
            }

            for (int j = 100; j < 988; j++) {
                cntS = 0;
                cntB = 0;
                //true 체크
                if(chk[j] == true){
                    continue;
                }
                //스트라이크 체크
                k = num;
                k2 = j;
                while(k > 0 && k2 >0){
                    if(k%10 == k2%10){
                        cntS++;
                    }
                    k /= 10;
                    k2 /= 10;
                }
                //볼 체크
                k = num;
                while(k > 0){
                    k2 = j;
                    while(k2 >0){
                        if(k%10 == k2%10){
                            cntB++;
                        }
                        k2 /= 10;
                    }
                    k /= 10;
                }
                cntB -= cntS;
                if(!(cntS == s && cntB ==b)){
//                    System.out.println(num+ " " + j +" " +cntS + " " + cntB);
                    chk[j] = true;
                }
            }
        }
        for (int i = 100; i < 988; i++) {
            if(chk[i] == false){
                answer++;
            }

        }
        System.out.println(answer);


    }
}
