import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_9019 {

    static class op {
        int x;
        String str;

        public op(int x, String str) {
            this.x = x;
            this.str = str;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int a,b,d,s,l,r,x;
        String strd,strs,strl,strr,str;

        Queue<op> que = new LinkedList<>();

        loop:
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            que.clear();

            boolean[] check = new boolean[10000];

            check[a]= true;
            que.add(new op(a,""));

            while(!que.isEmpty()){
                op dslr = que.poll();
                x = dslr.x;
                str = dslr.str;

                s = (x+9999)%10000;
                strs =str+"S";
                if(s == b) {
                    System.out.println(strs);
                    continue loop;
                }
                if(!check[s]){
                    check[s] = true;
                    que.add(new op(s,strs));
                }


                if(x ==0 ){
                    continue ;
                }

                d = (x*2)%10000;
                strd =str+"D";
                if(d == b) {
                    System.out.println(strd);
                    continue loop;
                }

                if(!check[d]){
                    check[d] = true;
                    que.add(new op(d,strd));
                }


                l = ((x*10)%10000) + x/1000;
                strl =str+"L";
                if(l == b) {
                    System.out.println(strl);
                    continue loop;
                }
                if(!check[l]){
                    check[l] = true;
                    que.add(new op(l,strl));
                }



                r = (x/10) + ((dslr.x%10) *1000);
                strr =str+"R";
                if(r == b) {
                    System.out.println(strr);
                    continue loop;
                }
                if(!check[r]){
                    check[r] = true;
                    que.add(new op(r,strr));
                }

            }

        }

    }
}
