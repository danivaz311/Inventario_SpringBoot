// Aseguramos que el código se ejecute después de que el DOM esté completamente cargado
document.addEventListener('DOMContentLoaded', () => {
    
    // Capturamos los elementos del DOM usando sus IDs
    const btnSaludo = document.getElementById('btn-saludo');
    const btnColor = document.getElementById('btn-color');

    // 1. Evento para mostrar una alerta con un saludo
    btnSaludo.addEventListener('click', () => {
        alert('¡Hola!');
    });

    // 2. Evento para cambiar el color de fondo de la página al azar
    btnColor.addEventListener('click', () => {
    
        const colorAleatorio = '#' + Math.floor(Math.random() * 16777215).toString(16).padStart(6, '0');
        
        // Aplica el nuevo color a la propiedad backgroundColor del body
        document.body.style.backgroundColor = colorAleatorio;

    });

});