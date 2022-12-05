package main;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Qual o numero de iteracoes?");
		Scanner entrada = new Scanner(System.in);
		int iteracoes = entrada.nextInt();
		
		tabuleiro t = new tabuleiro(10,10);
		System.out.println("Geracao inicial");
		t.imprimir();		
		
		for(int i=0; i < iteracoes; i++) {
			System.out.println("Nova geracao");
			t.novaGeracao();
			t.imprimir();
		}

	
	
		
	
	}

}
