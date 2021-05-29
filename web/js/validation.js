/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function verifyPassword() {  
  var pw = document.getElementById("p").value;  
  var cpw=document.getElementById("cp").value;
  if(pw.length < 8) {  
      alert("Password minimum length should be 8 digit");  
  }  
  else if(pw.length > 15) {  
        alert("Password max. length should be 15 digit");   
  } else if(!pw.equals(cpw)) {  
            alert("Password is Not Matched");  
  }  
}  
function resetlogic(x, y) {
    var pwd = document.getElementById(x).value;
    var cpwd = document.getElementById(y).value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                alert(xhr.responseText);
            } else {
                alert("request was unsucessful");
            }
        }
    };
    var url="fc/Forget?password="+eval(pwd)+"&repassword="+eval(cpwd);
    xhr.open("get", url, true);
    xhr.send(null);
    alert(pwd);
}
function forgetLogic(x){
    var email=document.getElementById(x).value;
     var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                alert(xhr.responseText);
            } else {
                alert("request was unsucessful");
            }
        }
    };
    var url="../fc/Forget?email="+email;
    xhr.open("get", url, true);
    xhr.send(null);
    alert(url);
}
  

