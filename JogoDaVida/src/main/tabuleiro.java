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
/*1.1*/		this.altura = altura;
/*1.1*/		this.largura = largura;
/*1.1*/		board = new celula[altura][largura];
		
/*1.2*/		for(int i=0; i<board.length; i++)
/*1.3*/			for(int j=0; j< board[i].length; j++) {
/*1.4*/				board[i][j] = new celula();
/*1.5*/				if(Math.random() <= 0.42) {
/*1.6*/					board[i][j].setNovoEstado(true);
/*1.6*/					board[i][j].atualizarEstado();
/*1.7*/				}
/*1.7*/			}				
/*1.7*/	}
	
	// get tabuleiro
	public celula[][] getTabuleiro(){
		return board;
	}
	
	public int getSize() {
		return largura;		
	}
	
	public int vizinhosVivos (int linha, int coluna) {
		
/*5.1.3.1*/		int cont = 0;
/*5.1.3.1*/		for(int i=linha-1; i <= linha+1; i++)
/*5.1.3.2*/			for(int j=coluna-1; j <= coluna+1; j++)
/*5.1.3.3*/				if(i >=0 && i <=altura && j >=0 && j <= largura) {
/*5.1.3.4*/					if(i == linha) {
/*5.1.3.5*/						if(j != coluna)
/*5.1.3.6*/							if(ehVivo(i,j))
/*5.1.3.7*/								cont++;
/*5.1.3.8*/					}
/*5.1.3.8*/					else {
/*5.1.3.9*/						if(i != linha)
/*5.1.3.10*/							if(ehVivo(i,j))
/*5.1.3.11*/								cont++;
/*5.1.3.12*/					}									
/*5.1.3.12*/				}
		
/*5.1.3.13*/		return cont;
		
	}
	
	
	// funcao auxiliar que verifica se a celula e viva ou morta
	public boolean ehVivo(int linha, int coluna) {
/*5.1.3.2.1*/		if(linha < altura && coluna < largura)
/*5.1.3.2.2*/			return board[linha][coluna].getEstado();
/*5.1.3.2.3*/		return false;
		
	}
	
	// funcao que faz uma nova jogada
	public void novaGeracao() {
/*5.1*/		gerar();
/*5.2*/		atualizarTabuleiro();
	}
	
	
	// funcao que percorre todo o tabuleiro e define um novo estado para cada celula 
	public void gerar() {
		
/*5.1.*/		for(int i=0; i<board.length; i++)
/*5.1.2*/			for(int j=0; j<board[i].length; j++) {
/*5.1.3*/				int vizinhos = vizinhosVivos(i,j);
/*5.1.3*/				if(vizinhos < 2)	
/*5.1.4*/					board[i][j].setNovoEstado(false);	 //menos de 2 vizinhos vivos
/*5.1.5*/				else if(vizinhos > 3)
/*5.1.6*/					board[i][j].setNovoEstado(false); // mais de 3 vizinhos vivos
/*5.1.7*/				else if(vizinhos == 3 )
/*5.1.8*/					board[i][j].setNovoEstado(true); // 3 vizinhos vivos
/*5.1.9*/				else if(vizinhos == 2 )
/*5.1.10*/					board[i][j].setNovoEstado(board[i][j].getEstado()); // 2 vizinhos mantem o estado atual
/*5.1.11*/			}		
	}
	
	// funcao que atualiza as novas celulas com o novo estado e faz a geracao do estado atual
	public void atualizarTabuleiro() {
		
/*5.2.1*/		for(int i=0; i<board.length; i++)
/*5.2.2*/			for(int j=0; j< board[i].length; j++) {
/*5.2.3*/				board[i][j].atualizarEstado();
/*5.2.4*/			}
	}
	
	
	
	// funcao que imprime o tabuleiro
	public void imprimir() {
		
/*2.1*/		for(int i=0; i<board.length; i++) {
/*2.2*/			for(int j=0; j<board[i].length; j++) {
/*2.3*/				System.out.print(" | ");
/*2.3*/				if(board[i][j].getEstado() == true)
/*2.4*/					System.out.print(" 1 ");
/*2.5*/				else System.out.print(" 0 ");
/*2.6*/			}
/*2.7*/		System.out.println("\n");
/*2.8*/		}
/*2.8*/	}
	
	
public static void main (String []args){
		
/*1*/		tabuleiro t = new tabuleiro(3,3);
/*2*/		System.out.println("Geracao inicial:");
/*3*/		t.imprimir();
		    //int n = 4;
/*4*/		for(int i=0; i <4; i++) {
/*5*/			System.out.println("Proxima geracao:");
/*5*/			t.novaGeracao();
/*5*/			t.imprimir();
/*6*/		}
/*6*/		
/*7*/	}
	
}

