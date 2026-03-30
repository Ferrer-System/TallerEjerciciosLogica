const readlineSync = require('readline-sync');
console.log("===== ORDENAR 3 NUMEROS =====");
//Solicitar los numeros 
const a = parseInt(readlineSync.question("Ingresa el primer numero del 1-100: "));
const b = parseInt(readlineSync.question("Ingresa el segundo numero del 1-100: "));
const c = parseInt(readlineSync.question("Ingresa el tercer numero del 1-100: "));

// validar numeros 
if (isNaN(a) || isNaN(b) || isNaN(c) || a < 1 || a > 100 || b < 1 || b > 100 || c < 1 || c > 100) {
    console.log("\n Error: Todos los números deben estar entre 1 y 100");
    process.exit(1);
}

console.log("\n" + "=".repeat(40));
console.log("Numeros ingresados:", a + ", " + b + ", " + c);
console.log("=".repeat(40) + "\n");

// verificar si todos son iguales 
if(a === b && b === c){
    console.log("Los tres numeros son iguales:", a);
    console.log("Orden de mayor a menor:", a + ", " + b +", " + c);
    console.log("Orden de menor a mayor:", a + ", " + b +", " + c);
}else{
    let mayor, centro, menor;
    if(a >= b && a >= c){
        mayor = a;
        if (b >= c) {
            centro = b;
            menor = c;
        }else{
            centro = c;
            menor = b;
        }
    }else if (b >= a && b >= c) {
        mayor = b;
        if (a >= c) {
            centro =  a;
            menor = c;
        }else{
            centro = c;
            menor = a;
        }
    }else {
        mayor = c;
        if (a >= b) {
            centro = a;
            menor = b;
        }else{
            centro = b;
            menor = a;
        }
    }
    //Mostrar los resultados
    console.log("Analisis de numeros:")
    console.log("Numero mayor:", mayor);
    console.log("Numero del centro:", centro);
    console.log("Numero menor:", menor);

    console.log("\nOrden de mayor a menor:", mayor + ", " + centro +", " + menor);
    console.log("Orden de menor a mayor:", menor + ", " + centro +", " + mayor);
}
console.log("\n" + "=".repeat(40));



