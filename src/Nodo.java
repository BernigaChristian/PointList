package listapunti.src;

public class Nodo {
	private Punto info;
	private Nodo link;

	public Nodo(Punto p) {
		info =new Punto(p);
		link=null;
	}

	public Nodo(Punto p,Nodo link) {
		info =new Punto(p);
		this.link=link;
	}

	public Punto getInfo() {
		return info;
	}

	public void setInfo(Punto info) {
		this.info = info;
	}

	public Nodo getLink() {
		return link;
	}

	public void setLink(Nodo link) {
		this.link = link;
	}

	@Override
	public String toString(){
        return "[" + info+ "]";
    }	

}
