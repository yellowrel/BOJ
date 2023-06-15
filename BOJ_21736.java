import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21736 {
    static int n,m,cnt=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x=0,y=0;

        char[][] campus = new char[n][m];
        String str;

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < m; j++) {
                campus[i][j] = str.charAt(j);
                if(campus[i][j] == 'I'){
                    x = i;
                    y = j;
                }
            }
        }
        walk(campus,x,y);

        if(cnt ==0){
            System.out.println("TT");
        }else{
            System.out.println(cnt);
        }
    }

    private static void walk(char[][] campus, int x, int y) {
        if(x<0|| y<0|| x>= n|| y >=m ) {
            return;
        }

        if(campus[x][y]=='X'){
            return;
        }

        if(campus[x][y] =='P'){
            cnt++;
        }

        campus[x][y] = 'X';

        walk(campus, x+1, y);
        walk(campus, x, y+1);
        walk(campus, x-1, y);
        walk(campus, x, y-1);

    }

}
