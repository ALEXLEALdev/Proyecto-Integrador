function llamada(){
    fetch('gestionCarta?op=1')
    .then(response => response.json())
    .then(data => pintarTabla(data))		
}
function verRojos(){
    fetch('gestionCarta?op=4')
    .then(response => response.json())
    .then(data => pintarTabla(data))		
}
function verAzules(){
    fetch('gestionCarta?op=5')
    .then(response => response.json())
    .then(data => pintarTabla(data))		
}
function verAmarillos(){
    fetch('gestionCarta?op=6')
    .then(response => response.json())
    .then(data => pintarTabla(data))		
}
function verVerdes(){
    fetch('gestionCarta?op=7')
    .then(response => response.json())
    .then(data => pintarTabla(data))		
}
function borrar(id){
		
		if(confirm("Seguro que quieres borrar")){
			fetch('gestionCarta?id='+id+'&op=3')
			.then(response => response.json())
			.then(data => pintarTabla(data))
		}else{
			
		}
	}
	
/*function pintarTabla(datos){

    let html = "<table border='2' >";
    
    for(let i=0;i<datos.length;i++){	
            html +="<tr><td>"+datos[i].id+"</td>";
            html +="<td>"+datos[i].nombre+"</td>";
            html += "<td>"+datos[i].color+"</td>";
            html+= "<td>"+datos[i].nivel+"</td>";
            html += "<td>"+datos[i].coste+"</td>";
            html += "<td>"+datos[i].costeDeDigi+"</td>";
            html += "<td>"+datos[i].poder+"</td>";
            html += "<td>"+datos[i].foto+"</td>";
            html += "<td><a href='crearCarta.html?id="+datos[i].id+"&op=2'>Editar</a></td><td><a href='javascript:borrar("+datos[i].id+")'>Borrar</a></td>";
            html +="</tr>";
    }
        
html +="</table>";
document.getElementById("listadoCartas").innerHTML = html;
}
*/
function pintarTabla(datos) {
    let html = "<section class='section2'>";

    for (let i = 0; i < datos.length; i++) {
        html += "<div class='carta'>";
        html += "<a href = 'carta.html'><img class='Imagen' src='img/cartas/" + datos[i].foto + "' alt='Imagen de la carta'></a>";
        html += "<div class='texto'><h2 class='titulo'>" + datos[i].nombre + "</h2></div>";
       /* html += "<div class='cartaColor'><p class='parrafoColor'>Color: " + datos[i].color + "</p></div>";
        html += "<div class='cartaStats'>";
        html += "<p class='parrafoStats'>Nivel: " + datos[i].nivel + "</p>";
        html += "<p class='parrafoStats'>Coste: " + datos[i].coste + "</p>";
        html += "<p class='parrafoStats'>C.de digievolucion: " + datos[i].costeDeDigi + "</p>";
        html += "<p class='parrafoStats'>DP: " + datos[i].poder + "</p>";
        html += "</div>";*/
        html += "</div>";
    }

    html += "</section>";
    document.getElementById("listadoCartas").innerHTML = html;
}

window.onload = function() {	
    llamada();
  }