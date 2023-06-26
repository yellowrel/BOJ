import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9081 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] word = new char[100];
        int wordlen;
        char tmp;

        loop:
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            wordlen = str.length();
            for (int j = 0; j < wordlen; j++) {
                word[j] = str.charAt(j);
            }

            for (int j = wordlen-2; j >= 0 ; j--) { // 기준점

                for (int k = wordlen-1; k > j; k--) { //비교군
                    if(word[j] < word[k]){
                        tmp = word[j];
                        word[j] =word[k];
                        word[k] = tmp;
                        Arrays.sort(word,j+1,wordlen);
                        for (int l = 0; l < wordlen; l++) {
                            System.out.print(word[l]);
                        }
                        System.out.println();
                        continue loop;
                    }
                }
            }
            System.out.println(str);
        }
    }
}
