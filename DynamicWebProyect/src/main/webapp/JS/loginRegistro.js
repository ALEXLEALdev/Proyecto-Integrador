function alerta(){
    window.prompt("Hola");
}

function borrarElementos(){
    document.getElementById("formularioAlta").requestFullscreen();
}

function compararPassword(){
    var password = document.getElementById("password");
    var repPassword = document.getElementById("repPassword");
    var errorPassword = document.getElementById("errorPassword");

    if(password.value.length == 0 || repPassword.value.length == 0){
        errorPassword.innerHTML = "La contraseña no puede estar vacia";
        errorPassword.style.color = "blue";
    }else if(password.value != repPassword.value) { 
        errorPassword.innerHTML = "La contraseña tiene que ser igual";
        errorPassword.style.color = "red";
    } else if(password.value == repPassword.value){
        errorPassword.innerHTML = "La contraseña coincide";
        errorPassword.style.color = "green";
    }
}

