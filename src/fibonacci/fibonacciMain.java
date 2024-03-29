package fibonacci;

import java.util.InputMismatchException;
import java.util.Scanner;

public class fibonacciMain {

	public static void main(String[] args) {
		int limit = input();
		System.out.println();
		System.out.println("Rekursiv:");
		System.out.println("Fibonacci-Folge bis Grenze "+limit+" = "+fibonacciRek(limit));
		System.out.println("Endrekursiv:");
		System.out.println("Fibonacci-Folge bis Grenze "+limit+" = "+fibonacciEndRek(1, 0, limit, 2));
	}
	
	public static int input() {
		int input = 0;
		boolean inputOk;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("Geben Sie eine Grenze N ein: ");
			try {
				input = sc.nextInt();
				inputOk = true;
				if (input < 0) {
					System.out.println("Die Zahl muss positiv sein!");
					inputOk = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("Sie m�ssen eine Zahl eingeben!");
				inputOk = false;
			}
		} while (!inputOk);
		return input;
		
	}
	public static int fibonacciRek(int limit) {
		if (limit == 0) {
			return 0;
		}
		else if (limit == 1) {
			return 1;
		}
		else {
			return fibonacciRek(limit - 1) + fibonacciRek(limit - 2);
		}
	}
	public static int fibonacciEndRek(int lastNumber, int numberBeforeLastNumber, int limit, int counter) {
		if (limit == 0) {
			return 0;
		}
		if (limit == 1) {
			return 1;
		}
		if (counter >= limit) {
			return (lastNumber + numberBeforeLastNumber);
		}
		else {
			return fibonacciEndRek(lastNumber + numberBeforeLastNumber, lastNumber, limit, counter + 1);
		}
	}
}
