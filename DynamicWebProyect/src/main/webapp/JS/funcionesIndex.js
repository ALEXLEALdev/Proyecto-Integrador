
function compararPassword(){
    var password = document.getElementById("contrasena");
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

function llamada(id, op){
			fetch('gestionUsuario?id='+id+"&op="+op)
			.then(response => response.json())
			.then(data => pintarFormulario(data))
		}
		
function pintarFormulario(datos){
			document.getElementById("id").value = datos.id;
			document.getElementById("nombre").value = datos.nombre;
			document.getElementById("apellido").value = datos.apellido;
			document.getElementById("nombreUsuario").value = datos.nombreUsuario;
			document.getElementById("contrasena").value = datos.contrasena;
			document.getElementById("mail").value = datos.mail;
			document.getElementById("permiso").value = datos.permiso;
		}
		
			/**
 			* Funci�n para otener el valor de un parametro en el GET 
 			*/
function getParameterByName(name) {
			name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
			var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
			results = regex.exec(location.search);
			return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
		}
		
/*function validarFormulario(){
			   
		    let nombre = document.getElementById('nombre').value;
			let color = document.getElementById('apellido').value;
   		    let nivel = document.getElementById('nombreUsuiario').value;
   		    let coste = document.getElementById('contrasena').value;
   		    let costeDeDigi = document.getElementById('mail').value;
   		    let poder = document.getElementById('permiso').value;

			let ok = true;
			if(nombre == ""){
				ok = false;
				document.getElementById('nombre').style.background = "red";
			}
			
			if(color == ""){
				ok = false;
				document.getElementById('color').style.background = "red";
			}
			
			if(nivel == ""){
				ok = false;
				document.getElementById('nivel').style.background = "red";
			}
			if(coste == ""){
				ok = false;
				document.getElementById('coste').style.background = "red";
			}
			if(costeDeDigi == ""){
				ok = false;
				document.getElementById('costeDeDigi').style.background = "red";
			}
			if(poder == ""){
				ok = false;
				document.getElementById('poder').style.background = "red";
			}
			if(foto == ""){
				ok = false;
				document.getElementById('foto').style.background = "red";
			}
			if(ok == true){
				
				//document.getElementById("Carta").submit();//
			}		
		}
*/	
window.onload = function(){
		let id = getParameterByName("id");
		let op = getParameterByName("op");
		llamada(id,op);
}