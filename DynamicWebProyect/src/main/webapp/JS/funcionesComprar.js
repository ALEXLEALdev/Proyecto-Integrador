function llamada() {
	fetch('gestionCarta?op=1')
		.then(response => response.json())
		.then(data => pintarTabla(data))
}

function pintarTabla(datos) {
	let html = "<section class='section2'>";

	html += "<form class='listadoCartas'>";
    html += "<p>Nombre</p>";
    html += "<p>Color</p>";
    html += "<p>Nivel</p>";
    html += "<p>Coste</p>";
    html += "<p>Coste de Digi</p>";
    html += "<p>Poder</p>";
    html += "<p>Cantidad</p>";
    html += "<p>Compar</p>";
    html += "</form>";

	for (let i = 0; i < datos.length; i++) {
		html += "<form class='listadoCartas' name='formularioComprar' action='gestionCarta' method='post' id='formularioComprar'>";
		html += "<p>" + datos[i].nombre + "</p>";
		html += "<p>" + datos[i].color + "</p>";
		html += "<p>" + datos[i].nivel + "</p>";
		html += "<p>" + datos[i].coste + "</p>";
		html += "<p>" + datos[i].costeDeDigi + "</p>";
		html += "<p>" + datos[i].poder + "</p>";
		html += "<p><input  id='comprarCarta' type='number' min='1' max='9' step='1' value='0'></p>";
		html += "<div><button type='submit' title='Comprar' name='compar'>COMPRAR</button></div>";
		html += "</form>";
	}
	html += "</section>";

	document.getElementById("listadoCartas").innerHTML = html;
}

window.onload = function() {
	llamada();
}