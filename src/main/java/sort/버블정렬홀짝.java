package sort;

import java.util.ArrayList;
import java.util.Scanner;

public class 버블정렬홀짝 {

    /*
    4                    // 테스트 케이스의 수

1                    // N = 1, 테스트 케이스 #1

3

1                    // N = 1, 테스트 케이스 #2

2

4                    // N = 4, 테스트 케이스 #3

7 3 8 4

4                    // N = 4, 테스트 케이스 #4

7 4 8 4
     */
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 sample_input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 sample_input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		*/
        System.setIn(new java.io.FileInputStream("C:\\algorithm\\solution2input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		*/
        Scanner sc = new Scanner(System.in);

		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        int T = sc.nextInt();
        System.out.println("T :" + T);
        for (int test_case = 1; test_case <= T; test_case++)
        {
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			*/
            /////////////////////////////////////////////////////////////////////////////////////////////
            int N = sc.nextInt();
            ArrayList<Integer> arraylist = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                arraylist.add(sc.nextInt());
            }
            int count = 0;


            // 표준출력(화면)으로 답안을 출력합니다.
            System.out.println("#" + test_case + arraylist);
        }

        sc.close(); // 사용이 끝난 스캐너 객체를 닫습니다.
    }
}
