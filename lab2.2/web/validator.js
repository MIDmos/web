let validX, validY, validR = false;

let user_r = 0;
let user_x = 0;
let user_y = 0;
let firstTime=true;

function chooseR(val) {

    firstTime=false;
    user_r=val;
    validR=true;

    drawZone('zoneCanvas',user_r);
    enable_button();
}

function choseX(val) {
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