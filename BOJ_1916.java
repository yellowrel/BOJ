import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1916 {

    static int[][] arr;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int e =  Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        int a, b, c;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            arr[a][b] = c;
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(v1, v2));

    }

    private static int dijkstra(int start, int end) {
        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; ++i) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[start] = 0;
        visited[start] = true;

        // 연결노드 distance갱신
        for (int i = 1; i < n + 1; ++i) {
            if (!visited[i] && arr[start][i] != 0) {
                distance[i] = arr[start][i];
            }
        }

        for (int i = 1; i < n + 1; i++) {

            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 1; j < n + 1; j++) {
                // 아직 방문하지 않았으면서, 최단 거리라면
                if (!visited[j] && min > distance[j]) {
                    index = j;
                    min = distance[j];
                }
            }

            if(index != -1) {
                visited[index] = true;
                for (int j = 1; j < n + 1; j++) {
                    // 아직 방문하지 않았으면서 경로가 존재하고, index까지의 거리 + index부터 j까지의 거리가 D[j]보다 작다면
                    if (!visited[j] && arr[index][j] != 0 && distance[index] != Integer.MAX_VALUE
                            && distance[index] + arr[index][j] < distance[j]) {
                        distance[j] = distance[index] + arr[index][j];
                    }
                }
            }
        }

        return distance[end];
    }
}
