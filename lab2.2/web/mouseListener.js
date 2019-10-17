let click_x, click_y;

function sendRequest() {
    let http = new XMLHttpRequest();
    let url = "control";
    let params = "x="+click_x.toFixed(4)+"&y="+click_y.toFixed(4)+"&r="+user_r.toFixed(4);

    http.open('POST', url+'?'+params);
    http.onload = function(){
        document.location.href='index.jsp';
    };
    http.send(null);
}

function addListener(canvasID) {
    let canvas = document.getElementById(canvasID);
    canvas.addEventListener("mousedown", function(event) {
        if (validR) {
            showMessage("");
            let rect = canvas.getBoundingClientRect();

            click_x = event.clientX - rect.right + rect.width / 2;
            click_y = rect.bottom - event.clientY - rect.height / 2;
            click_x /= rect.height * 0.4;
            click_y /= rect.width * 0.4;
            console.log("X: " + click_x);
            console.log("Y: " + click_y);
            sendRequest();
        }else {
            showMessage("<p>Выберите радиус</p>");
        }
    });
}
function showMessage(messageHTML) {
    document.getElementById("error-message").innerHTML=messageHTML;
}
function clearMessage() {
    if(validR)showMessage('');
}


function drawPoint(rad,relX,relY,color) {
    if(firstTime || user_r === rad) {
        let canvas = document.getElementById("zoneCanvas");
        let context = canvas.getContext("2d");
        context.fillStyle = color;
        context.beginPath();
        context.arc(relX * 120 + 150, 150 - relY * 120, 4, 0, 2 * Math.PI);
        context.fill();
    }
}