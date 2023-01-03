package main;

public class tabuleiro {
	
	private celula[][] board;
	private int altura;
	private int largura;
	
	
	public tabuleiro (celula [][] board) {
		this.board = board;
		altura = largura = board.length;
	}
	
	// cria o tabuleiro com as dimensoes passadas por parametros
	// e inicia as celulas aleatoriamente
	public tabuleiro(int altura, int largura) {
/*1.1.1*/		this.altura = altura;
/*1.1.1*/		this.largura = largura;
/*1.1.1*/		board = new celula[altura][largura];
		
/*1.1.1*/		for(int i=0; i<board.length; i++)
/*1.1.2*/			for(int j=0; j< board[i].length; j++) {
/*1.1.3*/				board[i][j] = new celula();
/*1.1.3*/				if(Math.random() <= 0.42) {
/*1.1.4*/					board[i][j].setNovoEstado(true);
/*1.1.4*/					board[i][j].atualizarEstado();
/*1.1.5*/				}
/*1.1.6*/			}				
/*1.1.6*/	}
	
	// get tabuleiro
	public celula[][] getTabuleiro(){
		return board;
	}
	
	public int getSize() {
		return largura;		
	}
	
	public int vizinhosVivos (int linha, int coluna) {
		
/*2.1.3.1*/		int cont = 0;
/*2.1.3.1*/		for(int i=linha-1; i <= linha+1; i++)
/*2.1.3.2*/			for(int j=coluna-1; j <= coluna+1; j++)
/*2.1.3.3*/				if(i >=0 && i <=altura && j >=0 && j <= largura) {
/*2.1.3.4*/					if(i == linha) {
/*2.1.3.5*/						if(j != coluna)
/*2.1.3.6*/							if(ehVivo(i,j))
/*2.1.3.7*/								cont++;
/*2.1.3.8*/					}
/*2.1.3.8*/					else {
/*2.1.3.9*/						if(i != linha)
/*2.1.3.10*/							if(ehVivo(i,j))
/*2.1.3.11*/								cont++;
/*2.1.3.12*/					}									
/*2.1.3.12*/				}
		
/*2.1.3.13*/		return cont;
		
	}
	
	
	// funcao auxiliar que verifica se a celula e viva ou morta
	public boolean ehVivo(int linha, int coluna) {
/*2.1.3.2.1*/		if(linha < altura && coluna < largura)
/*2.1.3.2.2*/			return board[linha][coluna].getEstado();
/*2.1.3.2.3*/		return false;
		
	}
	
	// funcao que faz uma nova jogada
	public void novaGeracao() {
/*2.1*/		gerar();
/*2.1*/		atualizarTabuleiro();
	}
	
	
	// funcao que percorre todo o tabuleiro e define um novo estado para cada celula 
	public void gerar() {
		
/*2.1.1*/		for(int i=0; i<board.length; i++)
/*2.1.2*/			for(int j=0; j<board[i].length; j++) {
/*2.1.3*/				int vizinhos = vizinhosVivos(i,j);
/*2.1.3*/				if(vizinhos < 2)	
/*2.1.4*/					board[i][j].setNovoEstado(false);	 //menos de 2 vizinhos vivos
/*2.1.5*/				else if(vizinhos > 3)
/*2.1.6*/					board[i][j].setNovoEstado(false); // mais de 3 vizinhos vivos
/*2.1.7*/				else if(vizinhos == 3 )
/*2.1.8*/					board[i][j].setNovoEstado(true); // 3 vizinhos vivos
/*2.1.9*/				else if(vizinhos == 2 )
/*2.1.10*/					board[i][j].setNovoEstado(board[i][j].getEstado()); // 2 vizinhos mantem o estado atual
/*2.1.11*/			}		
/*2.1.12*/	}
	
	// funcao que atualiza as novas celulas com o novo estado e faz a geracao do estado atual
	public void atualizarTabuleiro() {
		
/*2.2.1*/		for(int i=0; i<board.length; i++)
/*2.2.2*/			for(int j=0; j< board[i].length; j++)
/*2.2.3*/				board[i][j].atualizarEstado();
/*2.2.4*/	}
	
	
	
	// funcao que imprime o tabuleiro
	public void imprimir() {
		
/*1.2.1*/		for(int i=0; i<board.length; i++) {
/*1.2.2*/			for(int j=0; j<board[i].length; j++) {
/*1.2.3*/				System.out.print(" | ");
/*1.2.3*/				if(board[i][j].getEstado() == true)
/*1.2.4*/					System.out.print(" 1 ");
/*1.2.5*/				else System.out.print(" 0 ");
/*1.2.6*/			}
/*1.2.7*/		System.out.println("\n");
/*1.2.8*/		}
/*1.2.8*/	}
	
	
public static void main (String []args){
		
/*1*/		tabuleiro t = new tabuleiro(3,3);
/*1*/		System.out.println("Geracao inicial:");
/*1*/		t.imprimir();
		    //int n = 4;
/*1*/		for(int i=0; i <4; i++) {
/*2*/			System.out.println("Proxima geracao:");
/*2*/			t.novaGeracao();
/*2*/			t.imprimir();
/*3*/		}
/*3*/		
/*3*/	}
	
}

