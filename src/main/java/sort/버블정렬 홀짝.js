
/*
4
7 4 8 4
5
4 1 3 5 1
10
3 5 2 6 7 4 2 1 2 1
11
5 6 8 3 3 8 2 6 1 9 3
10
9 1 3 4 10 9 8 4 10 3
11
18 18 5 10 13 1 14 12 9 3 11
 */

function solution(n, array){

    let sortCount = 0;

    for (let i = 0; i < n - 1; i++) {
        let standard = array[i] % 2;
        if ((array[i + 1] % 2) === standard) {
            let differIndex = -1;
            for (let j = i + 2; j < n; j++) {
                if (array[j] % 2 !== standard) { // 이전값이 홀수일 경우에는 나머지가 0 짝수여야하고 짝수일 경우에는 나머지가 1 홀수여야합니다.
                    differIndex = j;
                    break;
                }
            }
            if (differIndex === -1) { // 나머지 다른 경우를 못찾은 경우 -1 리턴
                return -1;
            }

            for (let j = differIndex; j >= i+2; j--) {

                /*
                 예시 3 5 2 6 7 4 2 1 2 1)
                 i= 3일때 i=4가 나머지가 같으므로 i=5부터 나머지가 다른 경우를 탐색합니다. i=5를 찾았으므로 i=5와 i=4를 바꿉니다.
                 i=6에서 찾았을 경우 i=6과 5를 바꾸고 i=5와 i =4를 바꿉니다.
                 */
                let temp = array[differIndex];
                array[differIndex] = array[j -1];
                array[j - 1] = temp;
                sortCount++;
            }

        }
    }
    console.log(array);
    console.log(sortCount);
    return sortCount;
}

console.log(solution(10, [3, 5, 2, 6, 7, 4, 2, 1, 2, 1]));