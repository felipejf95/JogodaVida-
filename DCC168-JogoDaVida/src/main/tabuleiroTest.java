package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class tabuleiroTest {

	/**
	 * Teste de caminho simples 1
	 */
	@Test
	public void testeEhVivoCaminhoUm(){
		tabuleiro tab = new tabuleiro(6,6);
		boolean saidaEsperada = true;
		boolean saidaObtida = tab.ehVivo(1, 1);
		assertEquals(saidaEsperada, saidaObtida);
	}
	
	/**
	 * Test de caminho simples 2
	 */
	@Test
	public void testeEhVivoCaminhoDois(){
		tabuleiro tab = new tabuleiro(6,6);
		boolean saidaEsperada = false;
		boolean saidaObtida = tab.ehVivo(1, 1);
		assertEquals(saidaEsperada, saidaObtida);
	}
	/**
	 * Só será possível testar o caminho simples 1, uma vez que,
	 * para entrar nas condicionais, é necessário da geração automática
	 * feita por outras funções
	 */
	@Test
	public void testeVizinhosVivosCaminhoUm(){
		tabuleiro tab = new tabuleiro(6,6);
		int saidaEsperada = 2;
		int saidaObtida = tab.vizinhosVivos(0, 0);
		assertEquals(saidaEsperada, saidaObtida);
	}
	
	/**
	 * Teste de caminho simples 1, atribuindo o tabuleiro com dimensão 0X0 
	 */
	@Test
	public void testeAtualizarTabuleiroCaminhoUm(){
		tabuleiro tab = new tabuleiro(0,0);
		boolean saidaEsperada = true;
		boolean saidaObtida = tab.atualizarTabuleiro();
		assertEquals(saidaEsperada, saidaObtida);
	}
	
	/**
	 * Teste de caminho simples 2, atribuindo o tabuleiro com dimensão 6X6 
	 */
	@Test
	public void testeAtualizarTabuleiroCaminhoDois(){
		tabuleiro tab = new tabuleiro(6,6);
		boolean saidaEsperada = true;
		boolean saidaObtida = tab.atualizarTabuleiro();
		assertEquals(saidaEsperada, saidaObtida);
	}
	
	/**
	 * Teste de caminho simples 1, atribuindo o tabuleiro com dimensão 0X0 
	 */
	@Test
	public void testeGerarCaminhoCaminhoUm(){
		tabuleiro tab = new tabuleiro(0,0);
		boolean saidaEsperada = true;
		boolean saidaObtida = tab.gerar();
		assertEquals(saidaEsperada, saidaObtida);
	}
	/**
	 * Teste de caminho simples 2, atribuindo o tabuleiro com dimensão 6X6 
	 */
	@Test
	public void testeGerarCaminhoCaminhoDois(){
		tabuleiro tab = new tabuleiro(6,6);
		boolean saidaEsperada = true;
		boolean saidaObtida = tab.gerar();
		assertEquals(saidaEsperada, saidaObtida);
	}
	
	/**
	 * Teste de caminho simples 1, atribuindo o tabuleiro com dimensão 0X0 
	 */
	@Test
	public void testeImprimirCaminhoUm(){
		tabuleiro tab = new tabuleiro(0,0);
		boolean saidaEsperada = true;
		boolean saidaObtida = tab.imprimir();
		assertEquals(saidaEsperada, saidaObtida);
	}
	/**
	 * Teste de caminho simples 2, atribuindo o tabuleiro com dimensão 6X6 
	 */
	@Test
	public void testeGerarImprimirCaminhoDois(){
		tabuleiro tab = new tabuleiro(6,6);
		boolean saidaEsperada = true;
		boolean saidaObtida = tab.imprimir();
		assertEquals(saidaEsperada, saidaObtida);
	}
	
	@Test
	public void testeGerar(){
		tabuleiro tab = new tabuleiro(6,6);
		assertEquals(true, tab.gerar());
	}
}