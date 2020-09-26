package GrafoConLista;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;


public class Graph {

	private Vertice[] vertices;
	private Arco[] listaAdyacencia;
	private static Logger Logger;
	private int cantvertices,cantarcos;
	
	public Graph ()
	{
		vertices = new Vertice[1000];
		listaAdyacencia = new Arco[1000];
		cantvertices=0;
		cantarcos=0;
		
		if ( Logger == null)
		{
			Logger = Logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			Logger.addHandler(hnd);
			
			Logger.setLevel(Level.WARNING);
			
			Logger rootLogger = Logger.getParent();
			for (Handler h: rootLogger.getHandlers())
			{
				h.setLevel(Level.OFF);
			}
		
		
		}
			
	}
	
	
	private boolean estaNodo(Vertice v) {
		boolean esta=false;
		int i=0;
		
		while ((i<cantvertices)&&(!esta)) {
			if ((v.getNombre()).equals(vertices[i].getNombre()))
				esta=true;
			else i++;
		}
		
		return esta;
	}
	
	private boolean estaArco(Arco a) {
		boolean esta=false;
		int i=0;
		
		while ((i<cantarcos)&&(!esta)) {
			if ((listaAdyacencia[i].getPredecesor()).getNombre().equals(a.getPredecesor().getNombre()))
				{if((listaAdyacencia[i].getSucesor().getNombre()).equals(a.getSucesor().getNombre()))
				{esta=true;}}
		
			i++;
		}
		
		return esta;
	}
	
	
	
	
	
	public void addNode(int node)
	{
		Vertice vert = new Vertice(node);
				Logger.fine("El vertice a incorporar es "+vert.getNombre());
		
		if (estaNodo(vert))
			Logger.warning(vert.getNombre() +" ya se encuentra en el Grafo");
		else {
			vertices[cantvertices]=vert;
			cantvertices++;
		Logger.info("El vertice "+vert.getNombre()+" se agregó al Grafo");
			
		}
		
		
	
	
	}
	
	
	
	public void addEdge(int node1, int node2) {
		Vertice vert1 = new Vertice(node1);
		Vertice vert2 = new Vertice(node2);
		
		 Arco arc = new Arco(vert1,vert2);
		
		 
		 if (!estaArco(arc))
		{
		listaAdyacencia[cantarcos]=arc;
		Logger.info("El Arco con vertice "+vert1.getNombre()+"y "+ vert2.getNombre()+" se ingresó correctamente");
		cantarcos++;
		}
		 else Logger.warning("El Arco ya se encuentra asociado");
		
	}
	
	public void removeNode(int node)
	{
		Vertice ver =new Vertice(node);
		
		if (!estaNodo(ver))
			Logger.warning("El vertice"+ver.getNombre()+" no se puede remover porque no se encuentra en el Grafo");
		else 
			{
			int i=0;
			boolean esta=false;
			while (i<cantvertices && !esta)
			{
				if (vertices[i]==ver)
				{
					vertices[i]=vertices[cantvertices-1];
					esta=true;
				}
				else i++;
			}
			cantvertices--;
			Logger.info("Se removio el vertice");}
	}
	
	public void removeEdge(int node1, int node2)
	{
		int i =0; boolean encontre=false;
		Vertice ver1 = new Vertice(node1);
		Vertice ver2 = new Vertice(node2);
		Arco aux= new Arco(ver1,ver2);

		while ((i<listaAdyacencia.length)&&!encontre)
		{ 
			aux = listaAdyacencia[i];
			if ((aux.getPredecesor()==ver1)&&(aux.getPredecesor()==ver2))
			{
				encontre=true;
			}
			else {
				i++;
			}
		}
		
		if (encontre==true)
		{	
			listaAdyacencia[i]=listaAdyacencia[cantarcos-1];
			cantarcos--;
			Logger.fine("Se removio el Arco correctamente");
		}
		else
			Logger.warning("No se removio el arco deseado ya que no se encuentra en el Grafo");
		
		
	}
	
	
}
