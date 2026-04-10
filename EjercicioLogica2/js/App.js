// Función para convertir Celsius a Fahrenheit
function celciusToFahrenheit(celsius){
    return ((celsius * (9/5)) + 32);
}

// Función para convertir Celsius a Kelvin
function celsiusToKelvin(celsius){
    return (celsius + 273.15);
}

// Función para validar si el numero es un numero valido
function esNumeroValido(valor){
    // Convertir a numero
    const numero = parseFloat(valor);
    //Verificar si es un numero valido
    return !isNaN(numero) && isFinite(numero);
}

// Funcion principal para convertir y mostarr resultados
function convertirTemperatura(){
    // Obtener el valor del input
    const inputElement = document.getElementById('temperatura');
    const valorInput = inputElement.value.trim();

    //Limpiar mensajes anteriores
    const resultadoDiv = document.getElementById('resultado');
    const errorDiv = document.getElementById('error');
    resultadoDiv.classList.remove('show');
    errorDiv.classList.remove('show');
    resultadoDiv.innerHTML = '';

    //validar si el campo esta vacio
    if (valorInput === '') {
        mostrarError('Error: Por favor, ingresa una temperatura.');
        return;
    }

    //validar si es un numero valido
    if (!esNumeroValido(valorInput)) {
        mostrarError(`Error: "${valorInput}" no es un número válido: Por favor, Ingresa solo numeros`);
        return;
    }

    //Concertir a numero (puede ser entero o decimal)
    const celsius = parseFloat(valorInput);

    //Realizar conversion
    const fahrenheit = celciusToFahrenheit(celsius);
    const kelvin = celsiusToKelvin(celsius);

    //Mostrar resultados en consola
    console.log(`=== Convertir de ${celsius}°C ===`);
    console.log(`Grados kelvin: ${kelvin}`);
    console.log(`Grados fahrenheit: ${fahrenheit}`);

    //Mostrar resultados en el dom
    mostrarResultados(celsius, fahrenheit, kelvin);
}

// Función para mostrar resultados en el DOM
function mostrarResultados(celsius, fahrenheit, kelvin) {
    const resultadoDiv = document.getElementById('resultado');
    
    // Formatear números (mostrar con 2 decimales si es necesario)
    const formatNumber = (num) => {
        return Number.isInteger(num) ? num : num.toFixed(2);
    };
    
    resultadoDiv.innerHTML = `
        <h3> Resultados de la conversión:</h3>
        <p><strong> Temperatura ingresada:</strong> ${celsius}°C</p>
        <p><strong> Grados Fahrenheit:</strong> ${formatNumber(fahrenheit)}°F</p>
        <p><strong> Grados Kelvin:</strong> ${formatNumber(kelvin)}°K</p>
        <hr>
        <p><small> Conversión realizada correctamente</small></p>
    `;
    resultadoDiv.classList.add('show');
}

//funcion para mostrar mensaje de error
function mostrarError(mensaje){
    const errorDiv = document.getElementById('error');
    errorDiv.innerHTML = mensaje;
    errorDiv.classList.add('show');

    //Mostrar en consola
    console.log(mensaje)
}

//Agregrar funcionalidad para enviar con la tecla Enter
document.addEventListener('DOMContentLoaded', () =>{
    const input = document.getElementById('temperatura');
    if(input){
        input.addEventListener('keypress', (event) =>{
            if (event.key === 'Enter') {
                convertirTemperatura();
            }
        });
    }
});


