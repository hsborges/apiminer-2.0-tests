package br.unb.cbsoft2013.android;
import br.unb.cbsoft2013.Credencial;
import br.unb.cbsoft2013.Comunicador;


public class MainAndroid {
	
	private Credencial credencial = Credencial.obterInstancia("visitante", "visitante");

	public void metodoA(Object objeto) {
		if (!credencial.estaAutenticada()) {
			credencial.autenticar();
		} else {
			Comunicador comunicador = credencial.obterComunicador();
			comunicador.conectar();
			comunicador.enviar(objeto);
			comunicador.desconectar();
		}
	}
	
	public void metodoB(int tempoMaximo) {
		if (!credencial.estaAutenticada()) {
			credencial.autenticar();
		} else {
			Comunicador comunicador = credencial.obterComunicador();
			comunicador.conectar();
			comunicador.enviar(tempoMaximo);
			comunicador.desconectar();
		}
	}
	
	public void metodoC () {
		System.out.println(credencial.toString());
	}
	
}
