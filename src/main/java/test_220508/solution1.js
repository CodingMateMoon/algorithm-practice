
/*
문제 설명
어떤 공장에서는 단기 알바생들에게 각자 다른 방식으로 임금을 지급하고 있습니다. 각 알바생이 지급받는 임금은 다음과 같은 요소에 의해 결정됩니다.

임금 지급 간격: 공장에서 임금을 지급하는 간격(일수)입니다.
1회 임금 비용: 한번에 지급받는 임금의 금액입니다.
예를 들어, 임금 지급 간격이 2일이고 1회 임금 비용이 150 달러인 알바생이 지급받는 금액은 다음 표와 같습니다.

일차	지급 금액	누적 지급 금액
1	0 USD	0 USD
2	150 USD	150 USD
3	0 USD	150 USD
4	150 USD	300 USD
...	...	...
당신은 이 공장의 관리자로, 공장을 특정 일수만큼만 가동한 뒤 중지하려고 합니다. 노동법을 준수하기 위해서, 마지막으로 임금을 지급받고(혹은 한번도 임금을 지급받지 않은 상태에서) 하루라도 일했던 사람들한테는 공장 가동을 중지할 때 1회 임금 비용만큼의 임금을 더 지급하기로 했습니다.

알바생들의 임금 정보를 나타내는 2차원 배열 salaries와 공장을 가동할 일수 days가 매개변수로 주어집니다. 모든 알바생들에게 지급할 총 임금(USD)을 return 하도록 solution 함수를 완성해주세요.

제한사항
salaries의 행의 길이는 1 이상 100 이하입니다.
salaries의 각 행은 [interval, single] 2개의 정수로 이루어져 있으며, 이는 각 알바생의 임금 지급 간격(일)과 1회 임금 비용(USD)을 의미합니다.
interval은 1 이상 365 이하입니다.
single은 1 이상 1,000 이하입니다.
days는 1 이상 3,650 이하입니다.
입출력 예
salaries	days	result
[[2,100],[3,120],[4,180],[7,250]]	6	1150
[[2,1],[3,2],[4,3],[5,4]]	1	10
[[1,1000],[1,1000]]	3650	7300000
입출력 예 설명
입출력 예 #1

주어진 임금 정보에 의해 지급될 임금을 나타낸 표는 다음과 같습니다.
일차	알바생 1 지급 금액	알바생 1 누적 금액	알바생 2 지급 금액	알바생 2 누적 금액	알바생 3 지급 금액	알바생 3 누적 금액	알바생 4 지급 금액	알바생 4 누적 금액	전체 누적 지급 금액
1	0 USD	0 USD	0 USD	0 USD	0 USD	0 USD	0 USD	0 USD	0 USD
2	100 USD	100 USD	0 USD	0 USD	0 USD	0 USD	0 USD	0 USD	100 USD
3	0 USD	100 USD	120 USD	120 USD	0 USD	0 USD	0 USD	0 USD	220 USD
4	100 USD	200 USD	0 USD	120 USD	180 USD	180 USD	0 USD	0 USD	500 USD
5	0 USD	200 USD	0 USD	120 USD	0 USD	180 USD	0 USD	0 USD	500 USD
6	100 USD	300 USD	120 USD	240 USD	0 USD	180 USD	0 USD	0 USD	720 USD
추가 정산	0 USD	300 USD	0 USD	240 USD	180 USD	360 USD	250 USD	250 USD	1150 USD
여기서 추가 정산은, 6일차를 마지막으로 공장이 가동을 중지하여 임금 체불이 발생한 알바생 3과 4를 위한 칸입니다. (본문에 서술된대로 이들한테 1회 임금 비용만큼을 추가적으로 지불해야 합니다.)
총 지불 임금은 1,150 USD 입니다.
입출력 예 #2

모든 알바생이 임금을 받기도 전에 공장이 가동을 중지하였으므로, 모든 알바생에게 1회 임금 비용만큼을 지불해야 합니다. 따라서, 총 지불 임금은 10 USD 입니다.
입출력 예 #3

두 알바생이 약 10년간 하루에 한번씩 1000 USD를 받았으므로, 총 지불 임금은 2 x 1,000 x 3,650 = 7,300,000 USD 입니다.
* */
function solution(salaries, days) {
    var answer = 0;
    for (let i = 0; i < salaries.length; i++) {
        let interval = salaries[i][0];
        let single = salaries[i][1];
        let mok = Math.floor(days / interval);
        let rest = days % interval;
        answer += single * mok;
        if(rest !== 0)
            answer += single;

    }
    return answer;
}

// console.log(solution([[2,100],[3,120],[4,180],[7,250]], 6));
// console.log(solution([[2,1],[3,2],[4,3],[5,4]], 1));
// console.log(solution([[1,1000],[1,1000]], 3650));
