// Esperamos a que el DOM esté listo
document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('miFormulario');
    const selectPais = document.getElementById('country');
    const btnLimpiar = document.getElementById('btnLimpiar');

    // --- 1. Cargar países desde la API ---
    const cargarPaises = async () => {
        try {
            const respuesta = await fetch('https://restcountries.com/v3.1/all?fields=name,flags');
            if (!respuesta.ok) throw new Error('Error al obtener países');
            
            let paises = await respuesta.json();
            
            // Ordenar alfabéticamente
            paises.sort((a, b) => a.name.common.localeCompare(b.name.common));

            // Limpiar el select y agregar la opción inicial
            selectPais.innerHTML = '<option value="">Selecciona un país...</option>';

            paises.forEach(pais => {
                const opcion = document.createElement('option');
                opcion.value = pais.name.common;
                opcion.textContent = `${pais.name.common}`; 
                selectPais.appendChild(opcion);
            });
        } catch (error) {
            console.error(error);
            selectPais.innerHTML = '<option value="">Error al cargar países</option>';
        }
    };

    cargarPaises();

    // --- 2. Enviar el formulario (POST) ---
    form.addEventListener('submit', async (e) => {
        e.preventDefault();

        // Creamos el objeto FormData (form-data como en Postman)
        const formData = new FormData(form);

        try {
            const respuesta = await fetch('https://masksoft.com.mx/register', {
                method: 'POST',
                body: formData
            });

            const datos = await respuesta.json();

            if (respuesta.ok) {
                alert(`¡Éxito! Mensaje del servidor: ${datos.message}`);
                form.reset();
            } else {
                alert('Hubo un problema al registrar los datos.');
            }
        } catch (error) {
            alert('Error de conexión con el servidor.');
            console.error(error);
        }
    });

    // --- 3. Limpiar formulario ---
    btnLimpiar.addEventListener('click', () => {
        if(confirm('¿Seguro que quieres limpiar todos los campos?')) {
            form.reset();
        }
    });
});