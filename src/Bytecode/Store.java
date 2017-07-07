package Bytecode;

import Cpu.CPU;
import Excepciones.ArrayException;

/**
 * 
 * La clase Store hereda de ByteCodesOneParameter implementando todos los
 * métodos abstractos
 *
 */
public class Store extends ByteCodesOneParameter {

	public Store(int n) {
		super(n);
	}

	public Store() {
	}

	@Override
	public void execute(CPU cpu) throws ArrayException {
		Integer n = cpu.pop();
		cpu.writeInMem(this.param, n);
		cpu.increaseProgramCounter();

	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("STORE")) {
			int n = Integer.parseInt(string2);
			return new Store(n);
		}
		return null;
	}

	@Override
	protected String toStringAux() {

		return "STORE";
	}

}
