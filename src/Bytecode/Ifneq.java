package Bytecode;

/**
 * 
 * Este salto condicional hereda de ConditionalJumps e implementa todos sus
 * métodos abstractos
 *
 */
public class Ifneq extends ConditionalJumps {

	public Ifneq(int n) {
		super(n);
	}

	public Ifneq() {
	}

	@Override
	protected ByteCode parseAux(String w1, String w2) {
		if (w1.equalsIgnoreCase("IFNEQ")) {
			int n = Integer.parseInt(w2);
			return new Ifneq(n);
		} else
			return null;
	}

	@Override
	protected boolean compare(int n1, int n2) {
		return n1 != n2;
	}
	
	@Override
	protected String toStringAux() {
	return "IFNEQ";
	}
}
