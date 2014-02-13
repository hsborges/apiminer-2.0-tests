package br.unb.cbsoft2013;

/**
 * 
 * Credencial para acesso ao sistema do CBSoft
 * 
 * @author Hudson S. Borges
 *
 */
public class Credencial {
	
	private boolean autenticada;
	
	private Comunicador comunicador;
	
	/**
	 * 
	 */
	private Credencial(){
		this.autenticada = true;
		this.comunicador = Comunicador.obterInstancia();
	}
	
	/**
	 * @return
	 */
	public static Credencial obterInstancia(String usuario, String senha){
		return new Credencial();
	}

	/**
	 * @return
	 */
	public boolean estaAutenticada() {
		return autenticada;
	}

	/**
	 * @return
	 */
	public Comunicador obterComunicador() {
		return comunicador;
	}
	
	/**
	 * 
	 */
	public void renovarComunicador() {
		this.comunicador = Comunicador.obterInstancia();
	}
	
	/**
	 * 
	 */
	public void autenticar() {
		this.autenticada = true;
	}
	
	/**
	 * 
	 */
	public void desautenticar() {
		this.autenticada = false;
	}
	
	/**
	 * 
	 */
	public void reAutenticar() {
		this.autenticada = true;
	}
	
	/**
	 * @return
	 */
	public String informacoesDaCredencial() {
		return "Informations";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassA [var1=" + autenticada + ", var2=" + comunicador + "]";
	}
	
}
