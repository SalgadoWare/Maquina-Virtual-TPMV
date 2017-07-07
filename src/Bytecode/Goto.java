package Bytecode;

import Cpu.CPU;
import Excepciones.ArrayException;

/**
 * 
 * La clase Goto hereda de ByteCodesOneParameter implementando todos los métodos
 * abstractos
 *
 */
public class Goto extends ByteCodesOneParameter {

	public Goto(int n) {
		super(n);
	}

	public Goto() {
	}

	@Override
	public void execute(CPU cpu) throws ArrayException {
		if (this.param < cpu.getSizeProgram())
			cpu.setProgramCounter(this.param);
		else
			throw new ArrayException(
					"Salto " + this.toString() + " incorrecto, no existe bytecode en la posicion " + this.param);
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("GOTO")) {
			int n = Integer.parseInt(string2);
			return new Goto(n);
		}
		return null;
	}

	@Override
	protected String toStringAux() {
		return "GOTO";
	}

}
