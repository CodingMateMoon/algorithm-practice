/*
자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.
▣ 입력설명
첫 번째 줄은 정수 N(3<=N<=10)이 입력된다.
▣ 출력설명
첫째 줄에 출력한다.
▣ 입력예제 1
3
▣ 출력예제 1
1 2 3
* */

function recursive(n) {
    if(n === 1)
        return console.log(1);
    recursive(n-1);
    console.log(n);
}

//recursive(3);


/*
함수가 직접 또는 간접적으로 자기 자신을 호출하는 프로세스를 재귀함수라고 합니다. n = 3일때 1 2 3 순으로 출력하려면 어떻게 해야할지 먼저 생각합니다.
n=3일때 recursive(2)로 재귀호출을 하고 재귀호출이 끝난후에(return) 실행할 내용으로 log(2)를 출력합니다. n=2일때 recursive(1)을 호출하고 recursive(1)이 return된 이후에
실행할 내용으로 log(2)을 출력합니다.
n=1일 때 최종적으로 출력하는 것을 생각할 수 있는데 재귀 호출의 종료 지점에서 return하면서 recursive(1)- log(1) , recursive(2)-log(2), recursive(3)-log(3)순으로
출력합니다.
* */

function solutionRef(n){
    function DFS(L){
        if(L==0) return;
        else{
            /* 3, 2, 1 순으로 출력합니다.
           console.log(L);
           DFS(L-1);

            */

            /*
            DFS(3)->DFS(2)->DFS(1)->DFS(0) return은 반환, 종료를 의미합니다.
            DFS(0) , log(1), DFS(1), log(2), DFS(2), log(3) 결과적으로 1,2,3이 출력됩니다.
            D(3)이 호출되면 스택에 D(3)이 저장됩니다. 스택프레임은 D(3)의 매개변수 L = 3, 지역변수, 복귀주소 등 스택에 저장한 함수 호출 정보를 의미합니다.
            복귀주소는 자기가 일을 끝마치고 나면 스택프레임에서 사라지고 자신이 원래 호출되었던 복귀주소로 되돌아갑니다.
            D(3), D(2), D(1), D(0)이 호출되고 return을 통해 함수가 종료되면 D(0)은 자신을 호출했던 복귀주소 D(1)의 15번 라인 위치로 돌아갑니다.
            D(0)->D(1)->D(2)->D(3) 순으로 함수 호출 정보가 pop됩니다.
            * */
            DFS(L-1);
            console.log(L);
        }
    }
    DFS(n);
}

solutionRef(3);

/*

* */