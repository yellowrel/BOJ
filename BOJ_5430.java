import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean flag; //  정방향 true 역방향 false
        String op;
        int num;
        String inputArr = "";

        Deque<String> deque = new LinkedList<>();
        loop:
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            flag = true;
            op = br.readLine();
            num = Integer.parseInt(br.readLine());
            inputArr = br.readLine();
            inputArr = inputArr.substring(1,inputArr.length()-1);
            String[] arr = inputArr.split(",");
            for (int j = 0; j < num; j++) {
                deque.add(arr[j]);
            }
            for (int j = 0; j < op.length(); j++) {
                switch (op.charAt(j)){
                    case 'R':
                        flag = !flag;
                        break;
                    case 'D' :
                        if(deque.isEmpty()){
                            System.out.println("error");
                            continue loop;
                        }else if(flag){
                            deque.pollFirst();
                        }else{
                            deque.pollLast();
                        }
                        break;
                    default:
                        break;
                }
            }


            while(!deque.isEmpty()){

                if(flag){
                    sb.append(deque.pollFirst());
                }else{
                    sb.append(deque.pollLast());
                }
                if(deque.isEmpty())
                    break;
                sb.append(",");
            }
            sb.append("]");
            System.out.println(sb);

        }
    }
}
