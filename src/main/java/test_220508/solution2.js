function solution(scores) {
    const infoArray = Array.from(Array(scores.length), ()=> new Array(3));
    let exam1total = 0;
    let exam2total = 0;
    for (let i = 0; i < scores.length; i++) {
        // 응시자별 1번 문제 점수 총합
        exam1total += scores[i][0];
        // 응시자별 2번 문제 점수 총합
        exam2total += scores[i][1];
        // 응시자별 점수
        let eachTotal = scores[i][0] + scores[i][1];

        // 0번 인덱스에 응시자별 점수 합계 저장. 응시자가 i
        infoArray[i][0] = eachTotal;
        // 2번 인덱스에 응시자별 id 저장
        infoArray[i][2] = i + 1; // id
    }
    let hardIndex = -1; // 각 문제 총점이 동일한 경우
    if(exam1total < exam2total) {
        hardIndex = 0; // 1번째 문제
    } else if (exam1total > exam2total) {
        hardIndex = 1; // 2번째 문제
    }

    for (let i = 0; i < scores.length; i++) {
        infoArray[i][1] = 0;
        // 어려운 문제가 존재하는 경우
        if(hardIndex != -1) {
            // 1번 인덱스에 응시자별 어려운 문제 점수 저장
            infoArray[i][1] = scores[i][hardIndex];
        }
    }
    console.log(infoArray);

    for (let i = 0; i < infoArray.length - 1; i++) {
        let maxIndex = i;
        for (let j = i + 1; j < infoArray.length; j++) {
            if (infoArray[maxIndex][0] < infoArray[j][0]) { //응시자 총점 비교
                maxIndex = j;
            } else if (infoArray[maxIndex][0] === infoArray[j][0] ) {
                if(hardIndex != -1) {
                    // 어려운 문제 점수가 높은 경우
                    if (infoArray[maxIndex][1]< infoArray[j][1]) {
                        maxIndex = j;
                        //어려운 문제 점수가 동일한 경우
                    } else if (infoArray[maxIndex][1]== infoArray[j][1]) {
                        // 응시자 id가 빠른 경우
                        if (infoArray[maxIndex][2] > infoArray[j][2]) {
                            maxIndex = j;
                        }
                    }
                } else {
                    // 응시자 id가 빠른순
                    if (infoArray[maxIndex][2] > infoArray[j][2]) {
                        maxIndex = j;
                    }
                }
            }
        }
        // 더 점수가 높은 경우가 있어서 기준 index가 바뀐 경우
        if(maxIndex != i) {
            //console.log("maxArray : " + maxArray);
            let temp = infoArray[i];
            infoArray[i] = infoArray[maxIndex];
            infoArray[maxIndex] = temp;
            //console.log("i : " + i + "/ infoArray[" + maxIndex + "]");
        }

    }
    var answer = new Array(scores.length);
    for (let i = 0; i < infoArray.length; i++) {
        answer[infoArray[i][2] -1] = i+1;
    }
    //console.log("------result------");
    //console.log(infoArray);
    return answer;
}

console.log(solution([[85, 90], [65, 67], [88, 87], [88, 87], [73, 81], [65, 89], [99, 100], [80, 94]]));
console.log(solution([[85, 90], [91, 87], [88, 87]]));
