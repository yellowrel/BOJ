import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2667 {
    static int n, homeSize;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int cnt =0;

        ArrayList li = new ArrayList();

        char[][] jido = new char[n][n];
        String str;

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < n; j++) {
                jido[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(jido[i][j] == '1'){
                    cnt++;
                    homeSize =0;
                    homechk(jido,i,j);
                    li.add(homeSize);
                }
            }
        }

        System.out.println(cnt);
        li.sort(Comparator.naturalOrder());
        for (Object data: li) {
            System.out.println(data);
            
        }

    }

    private static void homechk(char[][] jido, int x, int y) {
        if(x<0|| y<0|| x>= n|| y >=n ) {
            return;
        }

        if(jido[x][y]=='0'){
            return;
        }

        jido[x][y] = '0';
        homeSize++;

        homechk(jido, x+1, y);
        homechk(jido, x, y+1);
        homechk(jido, x-1, y);
        homechk(jido, x, y-1);

    }

}
