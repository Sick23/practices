
package Practice7;
import java.util.Scanner;
public class Matrix {
static int[][] matriz = new int[4][4];
static int sumaDeFila(int fila) {
	int suma = 0;
	for (int col = 0; col < matriz[fila].length; col++)
		suma += matriz[fila][col];
	return suma;
}
 
static int sumaDeColumna(int col) {
	int suma = 0;
	for (int fila = 0; fila < matriz.length; fila++)
		suma += matriz[fila][col];
	return suma;
}
 
static int sumaDiagonalPrincipal() {
	int suma = 0;
	for (int i = 0; i < matriz.length; i++)
		suma += matriz[i][i];
	return suma;
}

static int sumaDiagonalInversa() {
	int suma = 0;
	int fila = matriz.length-1;
	int col = 0;
	while (fila >= 0 && col < matriz[0].length) {
		suma += matriz[fila][col];
		fila--;
		col++;
	}
	return suma;
}
 
static int mediaMatriz() {
	int suma = 0;
	for (int fila = 0; fila < matriz.length; fila++)
		for (int col = 0; col < matriz[0].length; col++)
			suma += matriz[fila][col];
	return suma / (matriz.length * matriz[0].length);
}
 
static void mostrarMenu() {
	System.out.println("\nMatriz creada");
	System.out.println("------ ------");
	for (int fila = 0; fila < matriz.length; fila++) {
		for (int col = 0; col < matriz[0].length; col++)
			System.out.print(matriz[fila][col] + " ");
		System.out.println();
}
	System.out.println("\nOPCIONES");
	System.out.println("--------");
	System.out.println("(1) Sumar fila");
	System.out.println("(2) Sumar Columna");
	System.out.println("(3) Sumar diagonal principal");
	System.out.println("(4) Sumar diagonal inversa");
	System.out.println("(5) Obtener media matriz");
	System.out.println("(9) Acabar programa");
 
}

public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	System.out.println("Introduce valores para la matriz:");
	for (int fila = 0; fila < matriz.length; fila++) {
		for (int col = 0; col < matriz[0].length; col++) {
			System.out.print("\nPosicion " + fila + "," + col + ": ");
			matriz[fila][col] = teclado.nextInt();
		}
	}
	int opcion = 0;
	while (opcion != 9) {
		mostrarMenu();
		System.out.print("Elije opcion: ");
		opcion = teclado.nextInt();
		switch (opcion) {
		case 1:
			System.out.print("\nIndica que fila quieres sumar: ");
			int fila = teclado.nextInt();
			System.out.println("La suma es: " + sumaDeFila(fila));
			break;
		case 2:
			System.out.print("\nIndica que columna quieres sumar: ");
			int col = teclado.nextInt();
			System.out.println("La suma es: " + sumaDeColumna(col));
			break;
		case 3:
			System.out.println("\nSuma de diagonal es: " + sumaDiagonalPrincipal());
			break;
		case 4:
			System.out.println("\nSuma de diagonal inversa es: " + sumaDiagonalInversa());
			break;
		case 5:
			System.out.println("\nLa media es: " + mediaMatriz());
			break;
		case 9:
			System.out.println("\nFIN DE PROGRAMA");
			break;
		default:
			System.out.println("Opción incorrecta\n");
		}
	}
	teclado.close();
}
 
}