package Bytecode;

import Cpu.CPU;
import Excepciones.ArrayException;

/**
 * 
 * La clase abstracta ConditionalJumps hereda de ByteCodesOneParameter
 * implementando unos métodos abstractos y definiendo otros
 *
 */
public abstract class ConditionalJumps extends ByteCodesOneParameter {

	public ConditionalJumps() {
	}

	public ConditionalJumps(int j) {
		super(j);
	}

	@Override
	public void execute(CPU cpu) throws ArrayException {
		int cima = cpu.pop();
		int subcima = cpu.pop();
		if (!this.compare(subcima, cima))
			if (this.param < cpu.getSizeProgram())
				cpu.setProgramCounter(this.param);
			else
				throw new ArrayException(
						"Salto " + this.toString() + " incorrecto, no existe bytecode en la posicion " + this.param);
		else
			cpu.increaseProgramCounter();
	}

	abstract protected boolean compare(int n1, int n2);

	public void setJump(int programCounter) {
		this.param = programCounter;
	}
}
