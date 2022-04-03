package listapunti.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lista {
	private Nodo head;
	private int elementi;
	
	public Lista() {
		head=null;
		elementi=0;
	}

	public Lista(Punto[] punti) throws ListaException{
		for(int i=punti.length;i>0;i--)
			inserisciInPosizione(punti[i],punti.length-i+1);
	}
	
	public int getElementi() {
		return elementi;
	}
	
	public boolean vuota() {
		return head==null;
	}
	
	public void inserisciInTesta(Punto punto) {
		Nodo pn=new Nodo(punto);
		pn.setLink(head);
		head=pn;
		elementi++;
	}
	
	public void inserisciInCoda(Punto punto) {
		if(vuota())
			inserisciInTesta(punto);
		else
			inserisciInCoda(head,punto);
	}

	private void inserisciInCoda(Nodo tempNodo,Punto punto){
		if(tempNodo.getLink()==null){
			tempNodo.setLink(new Nodo(punto,null));
			elementi++;
			return;
		}
		inserisciInCoda(tempNodo.getLink(),punto);
	}

	public void inserisciInPosizione(Punto punto, int posizione) throws ListaException{
		if(posizione<1||posizione>(elementi+1))
			throw new ListaException("Posizione errata");
		if(vuota()||posizione==1)
			inserisciInTesta(punto);
		else if(posizione==(elementi+1))
			inserisciInCoda(punto);
		else
			inserisciInPosizione(this.head,punto,posizione);
	}

	private void inserisciInPosizione(Nodo nodoTemp,Punto punto, int posizione){
		if(posizione==1){
			nodoTemp.setLink(new Nodo(punto,nodoTemp.getLink()));
			elementi++;
			return;
		}
		inserisciInPosizione(nodoTemp.getLink(),punto,posizione-1);
	}

	public void eliminaInTesta() throws ListaException {
		if(vuota())
			throw new ListaException("Eliminazione non possibile. Lista vuota");
		head=head.getLink();
		elementi--;
	}

	public void eliminaInCoda() throws ListaException {
		if(vuota())
			throw new ListaException("Eliminazione non possibile. Lista vuota");
		eliminaInCoda(head);
	}

	private void eliminaInCoda(Nodo nodoTemp){
		if(nodoTemp.getLink().getLink()==null){
			nodoTemp.setLink(null);
			elementi--;
			return;
		}
		eliminaInCoda(nodoTemp.getLink());
	}

	public void eliminaInPosizione(int posizione) throws ListaException{
		if(vuota())
			throw new ListaException("Eliminazione non possibile. Lista vuota");
		if(posizione<1||posizione>(elementi+1))
			throw new ListaException("Eliminazione non possibile. Posizione non valida");
		if(posizione==1)
			eliminaInTesta();
		else if(posizione==elementi)
			eliminaInCoda();
		else
			eliminaInPosizione(head,posizione);
	}

	private void eliminaInPosizione(Nodo nodoTemp,int posizione){
		if(posizione==1){
			nodoTemp.setLink(nodoTemp.getLink().getLink());
			elementi--;
			return;
		}
		eliminaInPosizione(nodoTemp.getLink(),posizione-1);
	}
	
	public String toString() {
		Nodo p=head;
		String lista="Punti presenti nella lista:\n";
		if(vuota())
			lista="Non ci sono punti nella lista.\n";
		while(p!=null) {
			lista+=p.getInfo().toString()+"\n";
			p=p.getLink();
		}
		return lista;
	}
	
	public boolean ricercaIter(double x, double y) {
		Nodo n=head;
		while(n!=null) {
			if(n.getInfo().getX()==x && n.getInfo().getY()==y)
				return true;
			n=n.getLink();
		}
		return false;
	}
	
	public boolean ricerca(double x, double y) {
		return ricercaRic(head, x, y);
	}
	
	private boolean ricercaRic(Nodo n, double x, double y) {
		if(n==null)
			return false;
		else if(n.getInfo().getX()==x && n.getInfo().getY()==y)
			return true;
		else
			return ricercaRic(n.getLink(), x, y);
	}

	public int shuffle(int k,int h) throws ListaException{
		if(vuota())
			throw new ListaException("Scambio non possibile. Lista vuota");
		if(k<1||k>(elementi+1)||h<1||h>(elementi+1))
			throw new ListaException("Scambio non possibile. Posizione non valida");
		if(k==h)    return 0;
		return spostaInPosizione(head,null,null,Math.max(h,k),Math.min(h,k));
	}

	private int spostaInPosizione(Nodo tempNodo,Nodo kn,Nodo hn,int max,int min){
		if(tempNodo.getLink()==null&&min==0)  return -1;
		if((--max)==0)   kn=tempNodo;
		if((--min)==0)   hn=tempNodo;
		if(kn!=null && hn!=null){
			Punto temp=kn.getInfo();
			kn.setInfo(hn.getInfo());
			hn.setInfo(temp);
			return 1;
		}
		return spostaInPosizione(tempNodo.getLink(),kn,hn,max,min);
	}

	public int lastFirst()  throws ListaException{
		return shuffle(1,elementi);
	}
}
