// https://www.welcomekakao.com/tryouts/1467/intro
const solution = function(num){
  let sum = 0;
  for(const n of num.toString().split('').map(function(val){ return Number(val.trim())})){
    sum = sum + Number(n);
  }

  return sum;
}
// console.log(solution(14));
// console.log(solution(123));
