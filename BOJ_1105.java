import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String l = st.nextToken();
        String r = st.nextToken();
        int len;
        int cnt = 0;

        len = l.length() > r.length() ? l.length() : r.length();
        for (int i = l.length(); i < len; i++) {
            l = '0'+l;
        }
        for (int i = r.length(); i < len; i++) {
            r = '0'+r;
        }

        if(l.charAt(0) == '8' && r.charAt(0) =='8'){
            cnt++;
        }

        for (int i = 1; i < len; i++) {
            if(l.charAt(i) =='8' && r.charAt(i) =='8'){
                cnt++;
                if(l.substring(0,i).equals(r.substring(0,i))){
                    continue;
                }
                cnt--;
            }
        }

        System.out.println(cnt);

    }
}