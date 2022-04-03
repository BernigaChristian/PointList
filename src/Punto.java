//Classe che definisce un oggetto di tipo Punto, avente come attributi le sue coordinate in un sistema di assi cartesiani ortogonali
//La classe contiene, oltre ai costruttori e ai getter e setter, i metodi toString, equals e due metodi distanza, che calcolano risp.
//la distanza del punto dal centro e la distanza del punto da un altro punto, passato come parametro.
package listapunti.src;

public class Punto {
	private double x;
	private double y;

	public Punto() {
	     x=0;
	     y=0;
	}
	   
	public Punto(double x, double y) {
	     this.x=x;
	     this.y=y;
	}
	
	public Punto(Punto p) {
	     this.x=p.x;
	     this.y=p.y;
	}
	  
	public void setX(double asc) { 
	      x = asc; 
	}
	
	public void setY(double ord) { 
	      y = ord; 
	}
	
	public double getX() { 
		return x; 
	}
	
	public double getY() { 
		return y; 
	}
 
	public String toString() { 
	      return "("+x+";"+y+")"; 
    }
	
	public boolean equals(Punto p) {
		return x==p.x && y==p.y;
	}
    
	public double distanza() {
		return Math.sqrt(x*x+y*y);
	}
	
	 public double distanza(Punto p){
		return (Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y)));
	 }

}
