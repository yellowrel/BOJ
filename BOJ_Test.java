public class BOJ_Test {

    public static void main(String[] args) {

        int x = 10 ; int y = 20;
        int[] arr2 = new int[3];

        for (int i = 0; i < 10; i++) {
            func(arr2);
            System.out.println(arr2[0]);
        }
    }

    private static void func(int[] arr2) {
        arr2[0]++;
        return;
    }
}
