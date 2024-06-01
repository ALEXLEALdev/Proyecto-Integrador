function llamada() {
	fetch('gestionSlider?op=1')
		.then(response => response.json())
		.then(data => pintarTabla(data))
}
function borrar(id) {

	if (confirm("Seguro que quieres borrar")) {
		fetch('gestionSlider?id=' + id + '&op=3')
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
	html += "<th>Destino</th>";
	html += "<th>Imagen</th>";
	html += "<th>Accion 1</th>";
	html += "<th>Accion 2</th>";
	html += "</tr>"

	for (let i = 0; i < datos.length; i++) {
		html += "<tr><td>" + datos[i].id + "</td>";
		html += "<td>" + datos[i].nombre + "</td>";
		html += "<td>" + datos[i].destino + "</td>";
		html += "<td>" + datos[i].imagen + "</td>";
		html += "<td><a href='crearSlider.html?id=" + datos[i].id + "&op=2'>Editar</a></td><td><a href='javascript:borrar(" + datos[i].id + ")'>Borrar</a></td>";
		html += "</tr>";
	}

	html += "</table>";
	document.getElementById("listadoSliders").innerHTML = html;
}

window.onload = function() {
	llamada();
}