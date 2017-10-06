// https://www.welcomekakao.com/tryouts/1467/intro
const solution = function(arr) {

  let table = []
  for(let i=0; i<=arr.length; i++){
    table[i] = 0;
  }
  for(let i of arr){
    if(i>arr.length || table[i]!=0){
      return false;
    }
    table[i] = i;
  }
  return true;
}

// console.log(solution([1, 2, 3]));
// console.log(solution([3, 1, 2, 4]));
// console.log(solution([4, 2, 3]));
