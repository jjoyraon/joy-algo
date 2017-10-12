function solution(sticker) {
  let len = sticker.length;
  let dy = []; // 0번째를 뜯은 경우
  let dn = []; // 0번째를 안뜯은 경우

  if(len==1) return sticker[0];
  if(len==2) return Math.max(sticker[0], sticker[1]);

  dy[0] = sticker[0];
  dy[1] = sticker[0];

  for(let i=2; i<len-1; i++){
    dy[i] = Math.max(dy[i-2]+sticker[i], dy[i-1]);
  }
  dy[len-1] = dy[len-2];

  dn[0] = 0;
  dn[1] = sticker[1];
  for(let i=2; i<len; i++){
    dn[i] = Math.max(dn[i-2]+sticker[i], dn[i-1]);
  }
  return Math.max(dy[len-1], dn[len-1]);

}


console.log(solution([14, 6, 5, 11, 3, 9, 2, 10]))
console.log(solution([1, 3, 2, 5, 4]))
console.log(solution([1, 9, 1, 9, 1]))
console.log(solution([3, 1, 1, 9, 10]))
