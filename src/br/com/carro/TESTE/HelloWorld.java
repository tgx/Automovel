package br.com.carro.TESTE;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/helloworld")
public class HelloWorld {

	@GET
	@Produces("text/plain")
	public String showHelloWorld() {
		return "Olá Mundo";
	}
}
