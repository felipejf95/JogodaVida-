package main;

public class tabuleiro {
	
	private celula[][] board;
	private int altura = 3;
	private int largura = 3;
	
	
	public tabuleiro (celula [][] board) {
		this.board = board;
		altura = largura = board.length;
	}
	
	
	public tabuleiro(int altura, int largura) {
		this.altura = altura;
		this.largura = largura;
		board = new celula[altura][largura];
		
		for(int i=0; i<board.length; i++)
			for(int j=0; j< board[i].length; j++) {
				board[i][j] = new celula();
				if(Math.random() <= 0.42) {
					board[i][j].setNovoEstado(true);
					board[i][j].atualizarEstado();
				}
			}
		
				
	}
	
	
	public celula[][] getTabuleiro(){
		return board;
	}
	
	public int getSize() {
		return largura;		
	}
	
	public int vizinhosVivos(int linha, int coluna){
		int cont =0;
		
		if(linha != 0 && coluna != 0)
			if(ehVivo(linha -1, coluna-1))
				cont++;
		
		
		if(linha != 0)
			if(ehVivo(linha-1, coluna))
				cont++;
		
		if(coluna != 0)
			if(ehVivo(linha, coluna-1))
				cont++;
		
		if(linha != 0 && coluna != largura-1)
			if(ehVivo(linha-1, coluna+1))
				cont++;
		
		if(coluna != largura-1)
			if(ehVivo(linha, coluna+1))
				cont++;
		
		if(linha != altura-1 && coluna != 0)
			if(ehVivo(linha+1, coluna-1))
				cont++;
		
		if(linha != altura-1)
			if(ehVivo(linha+1, coluna))
				cont++;
		
		if(linha != altura-1 && coluna != -1)
			if(ehVivo(linha+1, coluna+1))
				cont++;		
		
		
		
		return cont;
	}
	
	
	public boolean ehVivo(int linha, int coluna) {
		if(linha < altura && coluna < largura)
			return board[linha][coluna].getEstado();
		return false;
		
	}
	
	
	public void novaGeracao() {
		gerar();
		atualizarTabuleiro();
	}
	
	
	public void gerar() {
		
		for(int i=0; i<board.length; i++)
			for(int j=0; j<board[i].length; j++) {
				int vizinhos = vizinhosVivos(i,j);
				if(vizinhos < 2) {	board[i][j].setNovoEstado(false);	} //menos de 2 vizinhos vivos
				else if(vizinhos > 3) { board[i][j].setNovoEstado(false); } // mais de 3 vizinhos vivos
				else if(vizinhos == 3 ) { board[i][j].setNovoEstado(true); } // 3 vizinhos vivos
				else if(vizinhos == 2 ) { board[i][j].setNovoEstado(board[i][j].getEstado()); } // 2 vizinhos mantem o estado atual
			}		
	}
	
	public void atualizarTabuleiro() {
		
		for(int i=0; i<board.length; i++)
			for(int j=0; j< board[i].length; j++) {
				board[i][j].atualizarEstado();
			}
	}
	
	
	
	
	
	public void imprimir() {
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				System.out.print(" | ");
				if(board[i][j].getEstado() == true)
					System.out.print(" 1 ");
				else System.out.print(" 0 ");
			}
		System.out.println("\n");
		}
	}
	
	
}
