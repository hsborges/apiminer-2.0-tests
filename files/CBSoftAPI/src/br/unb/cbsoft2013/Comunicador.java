package br.unb.cbsoft2013;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Classe que permite o envio e recebimento de objetos do servidor do CBSoft
 * 
 * @author Hudson S. Borges
 *
 */
public class Comunicador {
	
	private boolean conectado = false;
	
	/**
	 * 
	 */
	private Comunicador() {}
	
	/**
	 * @return
	 */
	public boolean enviar(Object objeto){
		return true;
	}
	
	/**
	 * @param value
	 * @return
	 */
	public boolean enviar(Object objeto, int value){
		return false;
	}
	
	/**
	 * @return
	 */
	public List<Object> obterObjetosRecebidos() {
		return Arrays.asList(new Object[]{"1",2,3,"4"});
	}
	
	/**
	 * @return
	 */
	public Object obterUltimosObjetosRecebidos() {
		return "Last Object";
	}
	
	/**
	 * 
	 */
	public void receberTudo() {
		// Do something
	}
	
	/**
	 * 
	 */
	public void receberUltimo() {
		// Do something		
	}
	
	/**
	 * 
	 */
	public void conectar() {
		this.conectado = true;
	}
	
	/**
	 * @return
	 */
	public boolean estaConectado() {
		return conectado;
	}
	
	/**
	 * 
	 */
	public void desconectar(){
		this.conectado = false;
	}
	
	/**
	 * @return
	 */
	static Comunicador obterInstancia(){
		return new Comunicador();
	}

}
