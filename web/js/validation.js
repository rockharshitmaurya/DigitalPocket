/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function verifyPassword() {
    var pw = document.getElementById("p").value;
    var cpw = document.getElementById("cp").value;
    if (pw.length < 8) {
        alert("Password minimum length should be 8 digit");
    } else if (pw.length > 15) {
        alert("Password max. length should be 15 digit");
    } else if (!pw.equals(cpw)) {
        alert("Password is Not Matched");
    }
}
function resetlogic(x, y, z) {

    var pwd = document.getElementById(x).value;
    var cpwd = document.getElementById(y).value;
    var email = document.getElementById(z).value;

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                alert(xhr.responseText);
                window.location.replace("http://localhost:8080/DigitalPocket/");
            } else {
                alert("request was unsucessful");
            }
        }
    };
    var url = "../fc/ResetPwd?pwd=" + pwd + "&email=" + email;
    xhr.open("get", url, true);
    xhr.send(null);
}
function registration() {
    var xhr = new XMLHttpRequest();
    var targetForm = $('#myForm');
    var urlWithParams = '../fc/Registration' + "?" + targetForm.serialize();
    xhr.open("get", urlWithParams, true);
    xhr.onload = function () {
        if (xhr.status == 200) {
            alert(xhr.responseText);
            location.reload();
        } else {
            alert(xhr.responseText);
            location.reload();
        }
    }
    alert(urlWithParams);
    xhr.send();
}


function forgetLogic(x, y) {
    var email = document.getElementById(x).value;
    var xhr = new XMLHttpRequest();
    var url = "../fc/Forget?email=" + email;
    var btn = document.getElementById("base");
    var value = btn.innerHTML;
    xhr.open("get", url, true);
    xhr.onprogress = function () {
        if (xhr.readyState <= 3) {

            btn.innerHTML = value + '<img src="https://media1.giphy.com/media/3oEjI6SIIHBdRxXI40/giphy.gif" id="img" alt="alt"/>';
        }
    };
    xhr.onload = function () {
        if (xhr.status == 200) {

            var str = xhr.responseText;
            str = str.substring(str.indexOf('@') + 1);
            console.log(str);
            document.getElementById(y).innerHTML = "<strong>Success ! </strong>we have sent you an link vie email, Use the the link to Rest Your Password";
            btn.innerHTML = value;
            console.log(value);
        } else {
            document.getElementById(y).innerHTML = "<strong>Error !</strong>";
        }
    };
    xhr.send(null);
}


