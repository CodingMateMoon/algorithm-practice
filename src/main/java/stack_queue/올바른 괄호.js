/*
올바른 괄호
괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
▣ 입력설명
첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
▣ 출력설명
첫 번째 줄에 YES, NO를 출력한다.
▣ 입력예제 1
(()(()))(()
▣ 출력예제 1
NO
 */

function solution(line) {
    let stack = [];
    for (let i = 0; i < line.length; i++) {
        if (line.charAt(i) === "(") {
            stack.push(1);
        } else {
            if (stack.length === 0) {
                return "NO";
            }
            console.log(stack.pop());
        }
    }
    if(stack.length > 0)
        return "NO";
    return "YES";
}

function solutionRef(s){
    let answer="YES";
    let stack=[];
    for(let x of s){
        if(x==='(') stack.push(x);
        else{
            if(stack.length===0) return "NO";
            stack.pop();
        }
    }
    if(stack.length>0) return "NO";
    return answer;
}

console.log(solution("(()(()))(()"));
console.log(solution("(())()"));
console.log(solution("(()()))"));
console.log(solutionRef("(())()"));
console.log(solutionRef("(()()))"));
/*
좌괄호가 입력된 후에는 거기에 맞는 우괄호가 입력되어야 올바른 괄호가 될 수 있습니다. 예를 들어 (()))( 괄호의 경우
좌괄호와 우괄호의 개수는 각각 3개로 같으나 5번째 우괄호가 나왔을 때 거기에 매핑되는 좌괄호가 없기 때문에 올바르지 않습니다.
따라서 올바른 괄호가 되려면 좌괄호가 먼저 나오고 이후에 거기에 맞는 우괄호가 있는지 체크해야합니다. 가장 마지막의 n번째 좌괄호 다음에는 거기에 맞는
우괄호가 나와야합니다. 그리고 그 다음에는 n-1번째의 좌괄호에 매핑되는 우괄호가 나와야합니다. 마지막에 입력된 좌괄호가 가장 먼저 우괄호와 매핑되는 구조.
스택의 자료구조를 활용할 경우 좌괄호가 나왔을 때 stack에 push를 하고 우괄호가 나왔을 때 pop을 한다면 예시로 든 5번째 괄호의 경우 stack에 입력된 값이 없을 때
pop을 하는 상황으로 오류가 발생해서 올바르지 않은 것을 확인할 수 있습니다.
 */