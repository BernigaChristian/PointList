package listapunti.src;

public class TestLista {

	public static void main(String[] args) {
		Punto p1, p2, p3, p4, p5;
        Lista l = new Lista();
        p1=new Punto(1.0,2.5);
        p2=new Punto(2.0,4.0);
        p3=new Punto(3.0,2.0);
        p4=new Punto(1.0,2.0);
        p5=new Punto(1.5,1.5);
        l.inserisciInTesta(p1);
        l.inserisciInTesta(p2);
        l.inserisciInCoda(p3);
        try {
          l.inserisciInPosizione(p4, 1);
        }
        catch(ListaException le) {
          System.out.println(le.toString());
        }
        l.inserisciInCoda(p5);
        System.out.println("Numero di punti presenti nella lista: "+l.getElementi());
        System.out.println(l.toString());
        try {
          //l.eliminaInTesta();
          //l.eliminaInTesta();
          //l.eliminaInCoda();
          //l.eliminaInPosizione(2);
            System.out.println(l.shuffle(1,5));
        }
        catch(ListaException le) {
            System.out.println(le.toString());
        }
        System.out.println("Numero di punti presenti nella lista: "+l.getElementi());
        System.out.println(l.toString());
        System.out.println(l.ricercaIter(1.5, 2.0)?"Punto (1.5,2.0) presente":"Punto (1.5,2.0) NON presente");
        System.out.println(l.ricercaIter(1.0, 2.5)?"Punto (1.0, 2.5) presente":"(1.0, 2.5) NON presente");
        System.out.println(l.ricerca(1.5, 2.0)?"Punto (1.5,2.0) presente":"Punto (1.5,2.0) NON presente");
        System.out.println(l.ricerca(1.5, 1.5)?"Punto (1.5,1.5) presente":"Punto (1.5,1.5) NON presente");
        System.out.println(l.ricerca(1.0, 2.0)?"Punto (1.0,2.0) presente":"Punto (1.0,2.0) NON presente");
        
        
	}

}
