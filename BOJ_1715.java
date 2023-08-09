import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();

        int answer = 0;
        int temp;
        for (int i = 0; i < n; i++) {
            priorityQueue1.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < n-1; i++) {
            temp = priorityQueue1.poll() + priorityQueue1.poll();
            priorityQueue1.add(temp);
            answer += temp;
        }

        System.out.println(answer);
    }

}
