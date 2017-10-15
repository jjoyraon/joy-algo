function solution(strs, t) {

  let len = t.length;
  let dy = [];

  for(let i=1; i<=len; i++){
    dy[i] = 20001;
  }
  dy[0] = 0;

  for(let i=1; i<=len; i++){
    for(let s of strs){
      let b = i-s.length;
      if(b>=0 && t.substring(b, b+s.length) == s){
        dy[i] = Math.min(dy[b]+1, dy[i]);
      }
    }
  }
  if(dy[len]>20000){
    return -1;
  }

	return dy[len];
}

console.log(solution(["ba","na","n","a"], "banana"));
console.log(solution(["app","ap","p","l","e","ple","pp"], "apple"));
console.log(solution(["ba","an","nan","ban","n"], "banana"));
