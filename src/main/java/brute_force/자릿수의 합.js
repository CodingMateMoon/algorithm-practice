/*
자릿수의 합
N개의 자연수가 입력되면 각 자연수의 자릿수의 합을 구하고, 그 합이 최대인 자연수를 출력
하는 프로그램을 작성하세요. 자릿수의 합이 같은 경우 원래 숫자가 큰 숫자를 답으로 합니다.
만약 235 와 1234가 동시에 답이 될 수 있다면 1234를 답으로 출력해야 합니다.
▣ 입력설명
첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
각 자연수의 크기는 10,000,000를 넘지 않는다.
▣ 출력설명
자릿수의 합이 최대인 자연수를 출력한다.
▣ 입력예제 1
7
128 460 603 40 521 137 123
▣ 출력예제 1
137

 */

function solution(n, numbers){
    const arr = numbers.split(' ');
    let maxNumber = "0";
    let max = 0;
    for(let number of arr) {
        let numberSum = 0;
        for (let i = 0; i < number.length; i++) {
            numberSum += parseInt(number.charAt(i));
        }
        console.log(`max : ${max} , maxNumber : ${maxNumber}, number : ${number}`);
        if(numberSum > max) {
            maxNumber = number;
            max = numberSum;
        } else if (numberSum === max) {
            if (parseInt(number) > parseInt(maxNumber)) {
                maxNumber = number;
            }
        }
    }
    return maxNumber;
}

console.log(solution(7, "128 460 603 40 521 137 123"));

function solutionUseNumberVariable(n, arr){

}

/*
N(3<=N<=100)개의 자연수중에서 자릿수의 합이 최대인 경우. 최대인 경우가 여러 개인 경우에는 원래 숫자가 큰 숫자를 구해야합니다. 235, 1234 모두 자릿수의 합은 10인데
235 < 1234 이므로 1234를 출력해야합니다. 배열의 길이는 최소 3에서 최대 100입니다. 자릿수의 합을 계산하기 위해서 자연수를 문자열로 보고 각 자릿수에 대해 number 변환한 후
 합을 구하는 것이 필요합니다. 자릿수의 합이 가장 큰 숫자와, 자릿수의 합 각각을 maxNumber, max 변수에 저장하고 자릿수의 합이 더 큰 경우에는 각 변수의 값을 바꾸어줍니다.
 자릿수의 합이 같은 경우에는 maxNumber와 신규 숫자의 크기를 서로 비교해서 더 큰 값을 넣어줍니다.
 */