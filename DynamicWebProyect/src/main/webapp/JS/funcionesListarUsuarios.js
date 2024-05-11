function llamada() {
	fetch('gestionUsuario?op=1')
		.then(response => response.json())
		.then(data => pintarTabla(data))
}

function borrar(id) {

	if (confirm("Seguro que quieres borrar")) {
		fetch('gestionUsuario?id=' + id + '&op=3')
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
	html += "<th>Apellido</th>";
	html += "<th>Nombre de Usuario</th>";
	html += "<th>Contraseña</th>";
	html += "<th>Email</th>";
	html += "<th>Accion 1</th>";
	html += "</tr>"
	
	for (let i = 0; i < datos.length; i++) {
		html += "<tr><td>" + datos[i].id + "</td>";
		html += "<td>" + datos[i].nombre + "</td>";
		html += "<td>" + datos[i].apellido + "</td>";
		html += "<td>" + datos[i].nombreUsuario + "</td>";
		html += "<td>" + datos[i].contrasena + "</td>";
		html += "<td>" + datos[i].mail + "</td>";
		html += "<td><a href='javascript:borrar(" + datos[i].id + ")'>Borrar</a></td>";
		html += "</tr>";
	}

	html += "</table>";
	document.getElementById("listadoUsuarios").innerHTML = html;
}

/*function pintarTabla(datos) {

	let html = "<section class='section2'>";

	for (let i = 0; i < datos.length; i++) {
		html += "<div class ='carta'>"
		html += "<img class='Imagen' src='img/cartas/" + datos[i].foto + "'alt='Imagen de la carta'>"
		html += "<div class='texto'><h2 class='titulo'>" + datos[i].nombre + "</h2>""</div>"
		html += "<div class="cartaColor"><p class="parrafoColor">+datos[i].color+"</p></div>"
		html += "<div class="cartaStats">
			<p class="parrafoStats">+datos[i].nivel+"</p>"
			<p class="parrafoStats">+datos[i].coste+"</p>"
			<p class="parrafoStats">+datos[i].costeDeDigi+"</p>"
			<p class="parrafoStats">+datos[i].poder+"</p>"
		html += "</div>"
		html += "</div>"
	}

	html += "</section>";
	document.getElementById("listadoCartas").innerHTML = html;
}
*/
window.onload = function() {
	llamada();
}