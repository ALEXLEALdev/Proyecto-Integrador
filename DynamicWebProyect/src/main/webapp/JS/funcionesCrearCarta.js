function llamada(id, op){
			fetch('gestionCarta?id='+id+"&op="+op)
			.then(response => response.json())
			.then(data => pintarFormulario(data))
		}
		
function pintarFormulario(datos){
			document.getElementById("id").value = datos.id;
			document.getElementById("nombre").value = datos.nombre;
			document.getElementById("color").value = datos.color;
			document.getElementById("nivel").value = datos.nivel;
			document.getElementById("coste").value = datos.coste;
			document.getElementById("costeDeDigi").value = datos.costeDeDigi;
			document.getElementById("poder").value = datos.poder;
			document.getElementById("foto").value = datos.foto;
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
		
function validarFormulario(){

	let nombre = document.getElementById('nombre').value;
	let color = document.getElementById('color').value;
   	let nivel = document.getElementById('nivel').value;
   	let coste = document.getElementById('coste').value;
   	let costeDeDigi = document.getElementById('costeDeDigi').value;
   	let poder = document.getElementById('poder').value;
   	let foto = document.getElementById('foto').value;


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
		
window.onload = function(){
		let id = getParameterByName("id");
		let op = getParameterByName("op");
		llamada(id,op);
}