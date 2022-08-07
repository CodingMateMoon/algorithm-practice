package basic;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Building {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("숫자 입력 : ");
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] directionX = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] directionY = {1, 1, 0, -1, -1, -1, 0, 1};

        for (int i = 0; i < n; i++) {

            int eachN = Integer.parseInt(bufferedReader.readLine());
            String[] lines = new String[eachN];
//            boolean[][] checked = new boolean[eachN][eachN];
            for (int j = 0; j < eachN; j++) {
                lines[j] = bufferedReader.readLine();
            }
            int max = 0;
            for (int x = 0; x < eachN; x++) {
                for (int y = 0; y < eachN; y++) {
//                    System.out.print(lines[x].charAt(y));
                    boolean buildingOnlyExists = true;
                    for (int j = 0; j < directionX.length; j++) {
                        int nextX = x + directionX[j];
                        int nextY = y + directionY[j];
                        if (0 <= nextX && nextX < eachN && 0 <= nextY && nextY < eachN) {
                            char c = lines[nextX].charAt(nextY);
                            if (c == 'G') {

                                buildingOnlyExists = false;
                                break;
                            }
                        }
                    }
                    if (buildingOnlyExists) {
//                        System.out.println(x + " : " + y);
                        int count = 0;
                        for (int j = 0; j < eachN; j++) {
                            char c = lines[x].charAt(j);
                            if(c == 'B')
                                count++;
                        }
                        for (int j = 0; j < eachN; j++) {
                            char c = lines[j].charAt(y);
                            if(c == 'B')
                                count++;
                        }
                        count--;
                        max = Math.max(max, count);
                    }

                }

            }
            stringBuilder.append("#" + (i+1) + " " + max + "\n");
        }
        System.out.println(stringBuilder.toString());
    }
}
