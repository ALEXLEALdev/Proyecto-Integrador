function llamada(id, op){
	fetch('gestionCarta?id='+id+"&op="+op)
	.then(response => response.json())
	.then(data => pintarFormulario(data))		
}

window.onload = function(){
	let id = getParameterByName("id");
	let op = getParameterByName("op");
	llamada(id,op);
}