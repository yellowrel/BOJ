import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1802 {

    static String str;
    static boolean chk;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int strlen;

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            chk = true;
            mirror_chk(0,str.length()-1);

            if(chk){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }

    private static void mirror_chk(int idx, int idx2) {

        if(idx == idx2){
            return;
        }
        int i = idx;
        int i2 = idx2;

        while(i!=i2){
            if(str.charAt(i) == str.charAt(i2)){
                chk = false;
            }
            i++;
            i2--;
        }
        mirror_chk(idx,((idx+idx2)/2)-1);
        mirror_chk(((idx+idx2)/2)+1,idx2);
    }
}
