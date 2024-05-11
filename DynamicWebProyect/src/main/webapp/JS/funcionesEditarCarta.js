function llamada() {
	fetch('gestionCarta?op=1')
		.then(response => response.json())
		.then(data => pintarTabla(data))
}
function borrar(id) {

	if (confirm("Seguro que quieres borrar")) {
		fetch('gestionCarta?id=' + id + '&op=3')
			.then(response => response.json())
			.then(data => pintarTabla(data))
	} else {

	}
}

function pintarTabla(datos) {

	let html = "<table border='2' >";


	html += "<tr>";
	html += "<th>ID</th>";
	html += "<th>Nombre</th>";
	html += "<th>Color</th>";
	html += "<th>Nivel</th>";
	html += "<th>Coste</th>";
	html += "<th>Coste de Digi</th>";
	html += "<th>Poder</th>";
	html += "<th>Foto</th>";
	html += "<th>Accion 1</th>";
	html += "<th>Accion 2</th>";
	html += "</tr>"

	for (let i = 0; i < datos.length; i++) {
		html += "<tr><td>" + datos[i].id + "</td>";
		html += "<td>" + datos[i].nombre + "</td>";
		html += "<td>" + datos[i].color + "</td>";
		html += "<td>" + datos[i].nivel + "</td>";
		html += "<td>" + datos[i].coste + "</td>";
		html += "<td>" + datos[i].costeDeDigi + "</td>";
		html += "<td>" + datos[i].poder + "</td>";
		html += "<td>" + datos[i].foto + "</td>";
		html += "<td><a href='crearCarta.html?id=" + datos[i].id + "&op=2'>Editar</a></td><td><a href='javascript:borrar(" + datos[i].id + ")'>Borrar</a></td>";
		html += "</tr>";
	}

	html += "</table>";
	document.getElementById("listadoCartas").innerHTML = html;
}

window.onload = function() {
	llamada();
}