import java.util.Scanner;
public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero;

        while (true) { 
            System.out.print("Ingrese un número entero positivo: ");

            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                if (numero < 0) {
                    System.out.println("Por favor, ingrese un número entero positivo.");
                    continue;
                } else {
                    break;
                }
            } else {
                System.out.println("Por favor, ingrese un número entero positivo.");
                sc.next(); // Limpiar el buffer
                  
            }
        }

        long factorial = calcularfactorial(numero);
        System.out.println("El factorial de " + numero + " es: " + factorial);
        sc.close();

    }
    public static long calcularfactorial(int n) {
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

}
