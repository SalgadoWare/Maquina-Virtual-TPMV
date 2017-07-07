package Bytecode;

import Cpu.CPU;
import Excepciones.ArrayException;

/**
 * 
 * La clase Push hereda de ByteCodesOneParameter implementando todos los métodos
 * abstractos
 *
 */
public class Push extends ByteCodesOneParameter {

	public Push(int n2) {
		this.param = n2;
	}

	public Push() {
	}

	@Override
	public void execute(CPU cpu) throws ArrayException {
		cpu.push(this.param);
		cpu.increaseProgramCounter();
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("PUSH")) {
			int n = Integer.parseInt(string2);
			return new Push(n);
		}
		return null;
	}

	@Override
	protected String toStringAux() {
		return "PUSH";
	}
}
