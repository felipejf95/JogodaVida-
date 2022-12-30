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
	
	// get tabuleiro
	public celula[][] getTabuleiro(){
		return board;
	}
	
	public int getSize() {
		return largura;		
	}
	
	// funcao que conta o numero de vizinhos vivos de um celula passadas suas coordenadas no tabuleiro
	public int vizinhosVivos(int linha, int coluna){
		int cont =0;
		
		// diagonal superior esquerda
		if(linha != 0 && coluna != 0)
			if(ehVivo(linha -1, coluna-1))
				cont++;		

		// vizinho acima
		if(linha != 0)
			if(ehVivo(linha-1, coluna))
				cont++;
		
		// vizinho a esquerda
		if(coluna != 0)
			if(ehVivo(linha, coluna-1))
				cont++;
		
		// vizinho diagonal superior direito
		if(linha != 0 && coluna != largura-1)
			if(ehVivo(linha-1, coluna+1))
				cont++;
		
		// vizinho a direita
		if(coluna != largura-1)
			if(ehVivo(linha, coluna+1))
				cont++;
		
		// vizinho diagonal inferior esquerdo
		if(linha != altura-1 && coluna != 0)
			if(ehVivo(linha+1, coluna-1))
				cont++;
		
		// vizinho inferior
		if(linha != altura-1)
			if(ehVivo(linha+1, coluna))
				cont++;
		
		// vizinho diagonal inferior direito
		if(linha != altura-1 && coluna != -1)
			if(ehVivo(linha+1, coluna+1))
				cont++;		
		
		
		
		return cont;
	}
	
	
	// funcao auxiliar que verifica se a celula e viva ou morta
	public boolean ehVivo(int linha, int coluna) {
		if(linha < altura && coluna < largura)
			return board[linha][coluna].getEstado();
		return false;
		
	}
	
	// funcao que faz uma nova jogada
	public void novaGeracao() {
		gerar();
		atualizarTabuleiro();
	}
	
	
	// funcao que percorre todo o tabuleiro e define um novo estado para cada celula 
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
	
	// funcao que atualiza as novas celulas com o novo estado e faz a geracao do estado atual
	public void atualizarTabuleiro() {
		
		for(int i=0; i<board.length; i++)
			for(int j=0; j< board[i].length; j++) {
				board[i][j].atualizarEstado();
			}
	}
	
	
	
	// funcao que imprime o tabuleiro
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
	
	
public static void main (String []args){
		
		tabuleiro t = new tabuleiro(3,3);
		System.out.println("Geracao inicial:");
		t.imprimir();
		int n = 4;
		for(int i=0; i <n; i++) {
			System.out.println("Proxima geracao:");
			t.novaGeracao();
			t.imprimir();
		}
		
	}
	
}

