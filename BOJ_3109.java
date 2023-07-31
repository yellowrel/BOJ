import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {

    static int n, m, cnt = 0;
    static char[][] pipe;
    static char[][] visited;
    static boolean flag, flag2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str;

        n = Integer.parseInt(st.nextToken()); // 세로 길이
        m = Integer.parseInt(st.nextToken()); // 가로 길이

        pipe = new char[n][m];
        visited = new char[n][m];
        int[][] past = new int[m][2];
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < m; j++) {
                pipe[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            flag2 = false;
            if (pipe[i][0] != 'x') {
                pipeConn(i, 0, past);
            }
        }

        System.out.println(cnt);
    }

    private static void pipeConn(int y, int x, int[][] past) {
        if (x + 1 >= m) {
            flag = true;
            flag2 = true;
            cnt++;
            return;
        }

        if (!flag2) {
            for (int k = -1; k < 2; k++) {
                if (y + k < 0 || y + k >= n) {
                    continue;
                }

                if (pipe[y + k][x + 1] != 'x' && visited[y + k][x + 1] != 'x') {
                    // 스택에 쌓는 과정
                    past[x][0] = y + k;
                    past[x][1] = x + 1;
                    pipeConn(y + k, x + 1, past);
                    if (flag) {
                        for (int i = 0; i < m - 1; i++) {
                            pipe[past[i][0]][past[i][1]] = 'x';
                        }
                        flag = false;
                        break;
                    }
                } else {
                    for (int i = 0; i < x; i++) {
                        visited[past[i][0]][past[i][1]] = 'x';
                    }
                }
            }
        }
    }
}