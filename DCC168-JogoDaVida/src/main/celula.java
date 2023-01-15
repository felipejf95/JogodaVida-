package main;

public class celula {
	
	private boolean estado = false;
	private boolean novoEstado;
	
	
	public void celula (boolean state) {
		this.estado = state;
	}
	
	public void setNovoEstado(boolean state)
	{
		this.novoEstado = state;
	}
	
	public void atualizarEstado() {
		estado = novoEstado;
	}
	
	public boolean getEstado() {
		return estado;
	}
	


}
