const solution = function(v) {

  const xSet = new Set();
  const ySet = new Set();
  for(const p of v){
    let x = p[0];
    let y = p[1];

    if(xSet.has(x)){
      xSet.delete(x);
    }else{
      xSet.add(x);
    }
    if(ySet.has(y)){
      ySet.delete(y);
    }else{
      ySet.add(y);
    }
  }

  let ax = 0;
  let ay = 0;
  for(let x of xSet.values()){
    ax = x;
  }
  for(let y of ySet.values()){
    ay = y;
  }
  return [ax,ay];
}

console.log(solution([[1, 4], [3, 4], [3, 10]]))
console.log(solution([[1, 1], [2, 2], [1, 2]]))
