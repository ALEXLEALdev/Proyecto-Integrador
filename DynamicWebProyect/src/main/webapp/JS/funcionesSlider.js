window.addEventListener("DOMContentLoaded", function(){

    let sliderPrincipal = document.getElementById("sliderPrincipal");
    let flechaIzq = document.getElementById("flechaIzq");
    let flechaDer = document.getElementById("flechaDer");

    let rutas = ["img/sliders/slider1.jpg", "img/sliders/slider2.jpg", "img/sliders/slider3.jpg"];
    let posicionActual = 0;

    flechaIzq.addEventListener("click", retroceder);
    flechaDer.addEventListener("click", avanzar);

    function retroceder() {
        posicionActual--;
        if (posicionActual < 0) {
            posicionActual = rutas.length - 1;
        }
        cambiarSlider();
    }

    function avanzar() {
        posicionActual++;
        if (posicionActual >= rutas.length) {
            posicionActual = 0;
        }
        cambiarSlider();
    }

    function cambiarSlider() {
        sliderPrincipal.src = rutas[posicionActual];
    }

    // Función para avanzar automáticamente cada 4 segundos
    setInterval(avanzarAutomaticamente, 4000);

    function avanzarAutomaticamente() {
        avanzar();
    }
    
});
