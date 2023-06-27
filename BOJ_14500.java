import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = 0;
        int[][] arr = new int[n+3][m+3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int[][][] tetro = {
                {// -----
                        {0,0},
                        {1,0},
                        {2,0},
                        {3,0}
                },
                {// l
                        {0,0},
                        {0,1},
                        {0,2},
                        {0,3}
                },
                {// ㅁ
                        {0,0},
                        {1,0},
                        {0,1},
                        {1,1}
                },
                {//L
                        {0,0},
                        {0,1},
                        {0,2},
                        {1,2}
                },
                {//r
                        {0,0},
                        {1,0},
                        {2,0},
                        {0,1}
                },
                {//ㄱ
                        {0,0},
                        {1,0},
                        {1,1},
                        {1,2}
                },
                {//ㅢ
                        {0,1},
                        {1,1},
                        {2,1},
                        {2,0}
                },
                {//ㅢ
                        {1,0},
                        {1,1},
                        {0,2},
                        {1,2}
                },
                {//ㄴ
                        {0,0},
                        {0,1},
                        {1,1},
                        {2,1}
                },
                {//r
                        {0,0},
                        {0,1},
                        {1,0},
                        {0,2}
                },
                {//ㄱ
                        {0,0},
                        {1,0},
                        {2,0},
                        {2,1}
                },
                {//번개
                        {0,0},
                        {0,1},
                        {1,1},
                        {1,2}
                },
                {//번개 반전
                        {1,0},
                        {0,1},
                        {1,1},
                        {0,2}
                },
                {//Z
                        {0,0},
                        {1,0},
                        {1,1},
                        {2,1}
                },
                {//Z 반전
                        {1,0},
                        {2,0},
                        {0,1},
                        {1,1}
                },
                {//ㅜ
                        {0,0},
                        {1,0},
                        {2,0},
                        {1,1}
                },
                {//ㅗ
                        {1,0},
                        {0,1},
                        {1,1},
                        {2,1}
                },
                {//ㅓ
                        {1,0},
                        {1,1},
                        {0,1},
                        {1,2}
                },
                {//ㅏ
                        {0,0},
                        {0,1},
                        {1,1},
                        {0,2}
                }

        };

        for (int i = 0; i < 19; i++) {
            max = Math.max(max, tetroChk(arr,tetro,n,m,i));
        }

        System.out.println(max);

    }

    private static int tetroChk(int[][] arr, int[][][] tec, int n, int m, int t) {
        int max = 0;
        int sum;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m; j++) {
                sum =0;
                for (int k = 0; k < 4; k++) {
                    sum += arr[i+tec[t][k][0]][j+tec[t][k][1]];
                }
                max = Math.max(max,sum);
            }
        }
        return max;
    }
}