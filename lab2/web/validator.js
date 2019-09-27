let validX, validY, validR = false;

let user_r = [];
let user_x = 0;
let user_y = 0;
let firstTime=true;

function putR(val) {

    firstTime=false;
    let new_val = true;
    for(let i = 0; i < user_r.length; i++){
        if ( user_r[i] === val) {
            user_r.splice(i, 1);
            new_val=false;
        }
    }
    if(new_val)user_r.push(val);
    validR = user_r.length>0;
    if(user_r.length>1 || !validR)drawZone('zoneCanvas','R');
    else drawZone('zoneCanvas',user_r[0]);
    enable_button();
}

function choseX(val) {
    document.getElementById("lastX").value=val;
    user_x=val;
    validX=true;
    enable_button();
}

function validateY() {
    let input_field = document.getElementById("Y_input");

    let text = input_field.value;

    let match = text.match(/^-?[0-2]([,.]\d+)?$|^-?3([,.]0+)?$/);

    if (match == null) {
        input_field.classList.remove("valid_field");
        input_field.classList.add("invalid_field");
        validY = false;
    } else {
        input_field.classList.remove("invalid_field");
        input_field.classList.add("valid_field");
        user_y = parseFloat(text.replace(",", "."));
        validY = true;
    }
    enable_button();
}

function enable_button() {
    document.getElementById("submit").disabled = !(validX && validY && validR);
}