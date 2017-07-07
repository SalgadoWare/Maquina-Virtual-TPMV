package Comandos;

import Excepciones.ArrayException;
import Excepciones.BadFormatBytecode;
import Excepciones.ExecutionError;
import Principal.Engine;

/**
 * 
 * La clase Replace hereda de Command implementando todos los métodos abstractos
 *
 */
public class Replacebc implements Command {

	private int pos;

	public Replacebc(int pos) {
		this.pos = pos;
	}

	public Replacebc() {
	}

	@Override
	public void execute(Engine engine) throws ExecutionError, ArrayException, BadFormatBytecode {

		engine.reemplazar(this.pos);
		engine.showBcProgram();

	}

	@Override
	public Command parse(String[] s) {
		int n;
		if (s.length == 2 && s[0].equalsIgnoreCase("REPLACEBC")) {
			try {
				n = Integer.parseInt(s[1]);
			} catch (Exception e) {
				return null;
			}
			return new Replacebc(n);
		} else
			return null;
	}

	@Override
	public String textHelp() {
		return " REPLACEBC N: Reemplaza el bytecode N por la solicitada al usuario"
				+ System.getProperty("line.separator");
	}

	@Override
	public String toString() {
		return "REPLACEBC";
	}

}
