package Comandos;

import Excepciones.ArrayException;
import Excepciones.ExecutionError;
import Principal.Engine;

/**
 * 
 * La clase Run hereda de Command implementando todos los métodos abstractos
 *
 */
public class Run implements Command {

	@Override
	public void execute(Engine engine) throws ExecutionError, ArrayException {
		engine.run();
		engine.show_sProgram();
		engine.showBcProgram();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("RUN"))
			return new Run();
		else
			return null;
	}

	@Override
	public String textHelp() {
		return " RUN: Ejecuta el programa" + System.getProperty("line.separator");
	}

	@Override
	public String toString() {
		return "RUN";
	}
}