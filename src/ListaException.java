package listapunti.src;

public class ListaException extends Exception {
	
	private String errore;
	
	public ListaException(String errore) {
		this.errore=errore;
	}

	@Override
	public String toString() {
		return errore;
	}
	
	

}
