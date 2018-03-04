package RSS;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import net.sf.saxon.query.XQueryExpression;
import net.sf.saxon.query.XQueryParser;





import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LectorRSS extends Thread{
    
        	
	private String tipo;
	private String uri;
	private ArrayList<Noticiia> noticiias;
    private CountDownLatch countDownLatch;
	

	public LectorRSS(String tipo, String uri, CountDownLatch countDownLatch){
		this.tipo = tipo;
		this.uri = uri;
		this.noticiias = new ArrayList<Noticiia>();
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {		
		if (tipo.equals("DW")) {			
			noticiias = LeerRSSDW(uri);
//			System.out.println("Hla");
		}else {
			noticiias = LeerRSS(uri);
//			System.out.println("hla");

		}	
        countDownLatch.countDown();
        }   
        
        public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public ArrayList<Noticiia> getNoticiias() {
		return noticiias;
	}

	public void setNoticiias(ArrayList<Noticiia> noticiias) {
		this.noticiias = noticiias;
	}
    
    
	public static ArrayList<Noticiia> LeerRSS(String uri) {
	String titulo = "";
	String enlace = "";
	String descripcion = "";
	String fecha = "";
	String categoria = "";
	
	ArrayList<Noticiia> Noticias = new ArrayList<Noticiia>();
	// DocumentBuilderFactory
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	try {
	// Obtenemos un DocumentBuilder que internamente 
	DocumentBuilder builder = factory.newDocumentBuilder();
	// Cargamos un documento a traves del DocumentBuilder por medio de la URI
	Document document = builder.parse(uri);
	// Obtenemos una lista de noticias 
	NodeList items = document.getElementsByTagName("item");
	// Por cada noticia, extraemos los diferentes elementos
	for (int i = 0; i < items.getLength(); i++) 
	{
		categoria = "";
		Node nodo = items.item(i);
		for (Node n = nodo.getFirstChild(); n != null; n = n.getNextSibling()) 
		{
			if (n.getNodeName() == "title")
				titulo = n.getTextContent();
			if (n.getNodeName() == "link")
				enlace = n.getTextContent();
			if (n.getNodeName() == "description") 
			{
				descripcion = n.getTextContent();
				// Para eliminar tags HTML
				descripcion = descripcion.replaceAll("<[^>]*>", "");
			}
			if (n.getNodeName() == "pubDate") 
			{
				fecha = n.getTextContent();
			}			
			if (n.getNodeName() == "category") 
			{
				categoria = categoria +"--" +n.getTextContent();	
			}
		}		
		Noticiia noticia = new Noticiia();
		noticia.setCategoria(categoria);
		noticia.setDescripcion(descripcion);
		noticia.setEnlace(enlace);
		noticia.setFecha(fecha);
		noticia.setTitulo(titulo);
		Noticias.add(noticia);			
	}
  } 
   catch (ParserConfigurationException e) 
	{
		System.err.println("No se pudo crear una instancia de DocumentBuilder");
	} 
  catch (SAXException e) 
	 {
        System.err.println("Error SAX al parsear el archivo");
    } 
	catch (IOException e) 
	{
        System.err.println("Se produjo un error de E/S");
	} 
	catch (DOMException e) 
	{
			System.err.println("Se produjo un error del DOM");
	}
   return Noticias;
}
	
	public static ArrayList<Noticiia> LeerRSSDW(String uri) {
		String titulo = "";
		String enlace = "";
		String descripcion = "";
		String fecha = "";
		String categoria = "";
		
		ArrayList<Noticiia> Noticias = new ArrayList<Noticiia>();
		//Obtenemos una instacia de DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
		// Obtenemos un DocumentBuilder 
		DocumentBuilder  builder = factory.newDocumentBuilder();
		// Cargamos un documento a traves del DocumentBuilder por medio de la URI
		Document document = builder.parse(uri);
		// Obtenemos una lista de noticias 
		// Por cada noticia, extraemos los diferentes elementos 
		NodeList itemsE = document.getElementsByTagName("entry");

			for (int ii = 0; ii < itemsE.getLength(); ii++) 
			{
				categoria = "";
				Node noddo = itemsE.item(ii);
				for (Node n = noddo.getFirstChild(); n != null; n = n.getNextSibling()) 
				{
					if (n.getNodeName() == "title")
						titulo = n.getTextContent();
					if (n.getNodeName() == "link")
						enlace = n.getAttributes().getNamedItem("href").getTextContent();
					if (n.getNodeName() == "summary") 
					{
						descripcion = n.getTextContent();
						// Para eliminar tags HTML
						descripcion = descripcion.replaceAll("<[^>]*>", "");
					}
					if (n.getNodeName() == "published") 
					{
						fecha = n.getTextContent();
					}					
					if (n.getNodeName() == "category") 
					{ 
						categoria = categoria +"--" +n.getAttributes().getNamedItem("term").getTextContent();	
					}
				}			
				Noticiia noticia = new Noticiia();
				noticia.setCategoria(categoria);
				noticia.setDescripcion(descripcion);
				noticia.setEnlace(enlace);
				noticia.setFecha(fecha);
				noticia.setTitulo(titulo);
				Noticias.add(noticia);			
		}
	  } 
	   catch (ParserConfigurationException e) 
		{
			System.err.println("No se pudo crear una instancia de DocumentBuilder");
		} 
	  catch (SAXException e) 
		 {
	        System.err.println("Error SAX al parsear el archivo");
	    } 
		catch (IOException e) 
		{
	        System.err.println("Se produjo un error de E/S");
		} 
		catch (DOMException e) 
		{
				System.err.println("Se produjo un error del DOM");
		}
	   return Noticias;
	}

}
