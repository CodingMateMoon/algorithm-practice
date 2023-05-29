package basic;

class TriangleSnail {
    public int[] solution(int n) {

        int[][] arr = new int[n][n];
        int y = 0;
        int x = 0;
        int v = 1;

        while(true) {


            while (true) {

                arr[y][x] = v++;
                if ((y + 1) == n || arr[y + 1][x] != 0) {
                    break;
                }
                y++;
            }
            if ((x + 1) == n || arr[y][x + 1] != 0) break;
            x++;

            while (true) {
                arr[y][x] = v++;
                if ((x + 1) == n || arr[y][x + 1] != 0) break;
                x++;
            }

            if (arr[y - 1][x - 1] != 0) break;
            x--;
            y--;

            while (true) {
                arr[y][x] = v++;
                if(arr[y - 1][x - 1] != 0) break;
                x--;
                y--;
            }

            if ((y + 1) == n || arr[y + 1][x] != 0) break;
            y++;
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }
        System.out.println();

        int[] answer =  new int[v - 1];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = arr[i][j];
            }
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }

        return answer;
    }
}