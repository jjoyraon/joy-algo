function solution(land){

  let rows = land.length;
  let dy = [];
  for(let i=0; i<rows; i++){
    dy[i] = [0, 0, 0, 0]
  }
  dy[0] = land[0];

  for(let i=1; i<rows; i++){
    for(let j=0; j<4; j++){
      let max = 0;
      for(let k=0; k<4; k++){
        if(j!=k){
          if(max<dy[i-1][k]){
            max = dy[i-1][k];
          }
        }
      }
      dy[i][j] = land[i][j] + max;
    }
  }
  let max = 0;
  for(let i of dy[rows-1]){
    max = Math.max(max, i);
  }
  return max;

}

console.log(solution([[1,2,3,5],[5,6,7,8],[4,3,2,1]]))
console.log(solution([[1,2,3,5],[5,6,7,8],[4,3,2,1],[4,3,2,1]]))
console.log(solution([[99,1,1,1],[99,1,1,1],[99,1,1,1],[99,1,1,1],[99,1,1,1],[99,1,1,1],[99,1,1,1]]))
