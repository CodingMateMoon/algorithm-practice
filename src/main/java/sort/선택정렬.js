/*
선택 정렬
N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
정렬하는 방법은 선택정렬입니다.
▣ 입력설명
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에
있습니다.
▣ 출력설명
오름차순으로 정렬된 수열을 출력합니다.
▣ 입력예제 1
6
13 5 11 7 23 15
▣ 출력예제 1
5 7 11 13 15 23
* */
function solution(n, arr) {
    for (let i = 0; i < n - 1; i++) {
        let minIndex = i;
        for (let j = i + 1; j < n; j++) {
            if (arr[minIndex] > arr[j]) {
                minIndex = j;
            }
        }
        console.log(arr[minIndex]);
        if (minIndex != i) {
            let temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    return arr;
}

console.log(solution(6, [13, 5, 11, 7, 23, 15]));


function solutionRef(arr){
    let answer=arr;
    for(let i=0; i<arr.length; i++){
        let idx=i;
        for(let j=i+1; j<arr.length; j++){
            if(arr[j]<arr[idx]) idx=j;
        }
        [arr[i], arr[idx]] = [arr[idx], arr[i]];
    }
    return answer;
}

console.log(solutionRef([13, 5, 11, 7, 23, 15]));