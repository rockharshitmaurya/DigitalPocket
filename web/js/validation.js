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
  

