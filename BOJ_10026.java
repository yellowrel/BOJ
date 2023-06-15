import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026 {

    static int num;
    static char color;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        char[][] floor = new char[num][num];
        char[][] floor_RGBlind = new char[num][num];
        int cnt =0,cntBRB = 0;
        String str;

        for (int i = 0; i < num; i++) {
            str = br.readLine();
            for (int j = 0; j < num; j++) {
                floor[j][i] = str.charAt(j);
                floor_RGBlind[j][i] = str.charAt(j);
            }
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(floor_RGBlind[j][i] == 'G'){
                    floor_RGBlind[j][i] = 'R';
                }
            }
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(floor[j][i] != 'X'){
                    cnt++;
                    color = floor[j][i];
                    floorChk(floor,j,i);
                }
            }
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(floor_RGBlind[j][i] != 'X'){
                    cntBRB++;
                    color = floor_RGBlind[j][i];
                    floorChk(floor_RGBlind,j,i);
                }
            }
        }

        System.out.println(cnt+" "+cntBRB);

    }

    private static void floorChk(char[][] floor, int j, int i) {
        if(j < 0|| i < 0 || i>=num || j>= num){
            return;
        }

        if(floor[j][i] == 'X' || floor[j][i] != color){
            return;
        }

        floor[j][i] = 'X';

        floorChk(floor,j+1,i);
        floorChk(floor,j,i+1);
        floorChk(floor,j-1,i);
        floorChk(floor,j,i-1);
    }
}
