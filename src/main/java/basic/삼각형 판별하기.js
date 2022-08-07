 /*삼각형 판별하기
길이가 서로 다른 A, B, C 세 개의 막대 길이가 주어지면 이 세 막대로 삼각형을 만들 수 있
으면 “YES"를 출력하고, 만들 수 없으면 ”NO"를 출력한다.
▣ 입력설명
첫 번째 줄에 100이하의 서로 다른 A, B, C 막대의 길이가 주어진다.
▣ 출력설명
첫 번째 줄에 “YES", "NO"를 출력한다.
▣ 입력예제 1
6 7 11
▣ 출력예제 1
YES
▣ 입력예제 1
13 33 17
▣ 출력예제 1
NO
삼각형의 세 변의 길이를 a,b,c라고 할때 c가 가장 긴 변일 경우 a + b > c가 성립해야합니다. (나머지 두 변의 길이의 합이 가장 긴 변의 길이보다 길다)
a+ b - c > 0 역시 성립해야합니다.
*/

 function distinguishTriangle(a,b,c){
   let total = a + b + c;
   let max = a;
   if (max < b)
     max = b;
   if (max < c)
     max = c;
   if((total - max - max) > 0)
     return "YES"+ max;
   return "NO" + max;
 }

 console.log(distinguishTriangle(6, 7, 11));
 console.log(distinguishTriangle(13, 33, 17));