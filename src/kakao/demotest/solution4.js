const solution = function(board){

  let rows = board.length;
  let sumMap = [];
  for(let i=0; i<=rows; i++){
    let cols = board[0].length;
    sumMap[i] = [];
    for(let j=0; j<=cols; j++){
      sumMap[i][j] = 0;
    }
  }
  for(let i=1; i<=rows; i++){
    let cols = board[0].length;
    for(let j=1; j<=cols; j++){
      sumMap[i][j] = sumMap[i-1][j] + sumMap[i][j-1] - sumMap[i-1][j-1] + board[i-1][j-1];
    }
  }

  let maxk = Math.min(rows, board[0].length);
  for(let k=maxk; k>=1; k--){
    // console.log(k);
    let ksize = 0;
    for(let i=1; i+k-1<=rows; i++){
      let cols = board[0].length;
      for(let j=1; j+k-1<=cols; j++){
        ksize = Math.max(ksize, sumMap[i+k-1][j+k-1] - sumMap[i+k-1][j-1] - sumMap[i-1][j+k-1] + sumMap[i-1][j-1]);
      }
    }
    if(ksize == k*k){
      return ksize;
    }
  }
  return 0;

}

console.log( solution([[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]]) )
console.log( solution([[0,0,1,1],[1,1,1,1]]) )
