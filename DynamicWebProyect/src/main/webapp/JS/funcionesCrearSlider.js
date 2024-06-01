function llamada(id, op){
			fetch('gestionSlider?id='+id+"&op="+op)
			.then(response => response.json())
			.then(data => pintarFormulario(data))
		}
		
function pintarFormulario(datos){
	document.getElementById("id").value = datos.id;
	document.getElementById("nombre").value = datos.nombre;
	document.getElementById("destino").value = datos.destino;
	document.getElementById("imagen").value = datos.imagen;
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
	let id = document.getElementById('id').value;
	let nombre = document.getElementById('nombre').value;
	let destino = document.getElementById('destino').value;
	let imagen = document.getElementById('imagen').value;
}

window.onload = function(){
		let id = getParameterByName("id");
		let op = getParameterByName("op");
		llamada(id,op);
}