package Bytecode;

import Cpu.CPU;
import Excepciones.ArrayException;

/**
 * 
 * La clase Load hereda de ByteCodesOneParameter implementando todos los métodos
 * abstractos
 *
 */
public class Load extends ByteCodesOneParameter {

	public Load(int n) {
		super(n);
	}

	public Load() {
	}

	@Override
	public void execute(CPU cpu) throws ArrayException {
		Integer m = cpu.readMem(this.param);
		cpu.push(m);
		cpu.increaseProgramCounter();

	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("LOAD")) {
			int n = Integer.parseInt(string2);
			return new Load(n);
		}
		return null;
	}

	@Override
	protected String toStringAux() {
		return "LOAD";
	}

}
