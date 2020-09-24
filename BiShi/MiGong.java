//package BiShi;
//
//import java.util.Scanner;
//public class MiGong {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int T = scanner.nextInt();
//        scanner.nextLine();
//        String str1 = scanner.nextLine();
//        int M = str1.charAt(0) - '0';
//        System.out.println(M);
//        int N = str1.charAt(2) - '0';
//        char[][] str2 = new char[N][M];
//        for (int k = 0; k < T; k++) {
//            for (int i = 0; i < N; i++) {
//                String str3 = scanner.nextLine();
//                for (int j = 0; j < M; j++) {
//                    str2[i][j] = str3.charAt(j);
//                }
//            }
//        }
//        int ret = foot(str2);
//    }
//
//    public static int foot(char[][] str) {
//        int N = str.length;
//        int M = str[0].length;
//        int count = 0;
//        System.out.println(N + M);
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (str[i][j] == '@') {
//                    if (i == N - 1 || j == M - 1) {
//                        return 0;
////                    }else if(){
////
////                    }
//                    }
//                }
//            }
//            return -1;
//        }
//    }
//}
