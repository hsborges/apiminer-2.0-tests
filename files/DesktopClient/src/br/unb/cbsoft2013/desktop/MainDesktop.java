package br.unb.cbsoft2013.desktop;
import java.util.List;

import br.unb.cbsoft2013.Credencial;
import br.unb.cbsoft2013.Comunicador;


public class MainDesktop {
	
	private String usuario;
	private String senha;
	
	public void metodoD() {
		Comunicador comunicador = Credencial.obterInstancia(usuario, senha).obterComunicador();
		comunicador.conectar();
		comunicador.receberTudo();
		List<Object> objetosRecebidos = comunicador.obterObjetosRecebidos();
		for (int i = 0; i < objetosRecebidos.size(); i++) {
			System.out.println(objetosRecebidos.get(i).toString());
		}
		comunicador.desconectar();		
	}
	
	public void metodoE() {
		Comunicador comunicador = Credencial.obterInstancia(usuario, senha).obterComunicador();
		comunicador.conectar();
		comunicador.receberUltimo();
		System.out.println(comunicador.obterUltimosObjetosRecebidos());
		comunicador.desconectar();
	}
	
	public void metodoF() {
		System.out.println("MainDesktop.metodoF()");
	}

}
