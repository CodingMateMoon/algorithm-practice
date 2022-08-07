function selectMinTest(a, b, c){
    let answer = a
    if (answer > b) {
        answer = b;
    }
    if(answer > c) {
        answer = c;
    }
    return answer;
}