var num = require('fs').readFileSync('/dev/stdin').toString();

for(var i=1; i<=num; i++){
  var s = "";
  for(var j=1; j<=i; j++){
    s = s+"*";
  }
  console.log(s);
}
