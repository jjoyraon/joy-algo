var num = require('fs').readFileSync('/dev/stdin').toString();

var size = 1;
var edge = 0;

while(edge<num){
  edge += size;
  size++;
}
size--;
edge = edge - size;

var upValue = num - edge;
var downValue = num - edge;

if(size % 2 == 1){
  upValue = size - upValue + 1;
}
if(size % 2 == 0){
  downValue = size - downValue + 1;
}

console.log(upValue + '/' + downValue);
