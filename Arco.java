package GrafoConLista;

public class Arco {

	private Vertice origen;
	private Vertice destino;
	private String nomb;
	
	public Arco(Vertice or, Vertice des) {
		
		origen=or;
		destino=des;
	}
	
	public String getNombre()
	{
		return nomb;
	}
	
	public void setNombre(String n) {
		nomb=n;
	}
	
	public Vertice getPredecesor()
	{
		return origen;
	}
	
	public Vertice getSucesor()
	{
		return destino;
	}
	
	public void setPred(Vertice p)
	{
		origen =p;
	}
	
	public void setSuc(Vertice s)
	{
		destino=s;
	}
	
	
	
	
}
