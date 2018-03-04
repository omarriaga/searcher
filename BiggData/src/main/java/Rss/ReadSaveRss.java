package RSS;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Source;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import com.saxonica.xqj.SaxonXQDataSource;
 
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XQueryCompiler;
import net.sf.saxon.s9api.XQueryEvaluator;
import net.sf.saxon.s9api.XQueryExecutable;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmValue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;



public class ReadSaveRss 
{
	static News news = new News();
        private static Document document;
        public static String XMLFIle = ""; 
        static CountDownLatch countDownLatch;

        
        public static News rss() {
            
            news.setNews(new ArrayList<Noticiia>());
            countDownLatch = new CountDownLatch(9);
		//Reuters news
//		ArrayList noticiasReutersB  = LectorRSS.LeerRSS("http://feeds.reuters.com/reuters/businessNews/");
//		news.getNews().addAll(noticiasReutersB);
//		ArrayList noticiasReutersT  = LectorRSS.LeerRSS("http://feeds.reuters.com/reuters/technologyNews/");
//		news.getNews().addAll(noticiasReutersT);	
//		ArrayList noticiasReutersE  = LectorRSS.LeerRSS("http://feeds.reuters.com/reuters/entertainment/");
//		news.getNews().addAll(noticiasReutersE);	
//		
//		//mashable
//		ArrayList noticiasmashableT= LectorRSS.LeerRSS("http://feeds.mashable.com/mashable/tech/");
//		news.getNews().addAll(noticiasmashableT);
//		ArrayList noticiasmashableB= LectorRSS.LeerRSS("http://feeds.mashable.com/mashable/business/");
//		news.getNews().addAll(noticiasmashableB);
//		ArrayList noticiasmashableE= LectorRSS.LeerRSS("http://feeds.mashable.com/mashable/entertainment");
//		news.getNews().addAll(noticiasmashableE);		
//		
//		//DW
//		ArrayList noticiasDWB= LectorRSS.LeerRSSDW("http://rss.dw.com/atom/rss-en-bus");
//		news.getNews().addAll(noticiasDWB); 
//		ArrayList noticiasDWE= LectorRSS.LeerRSSDW("http://rss.dw.com/atom/rss-en-cul"); //cultural
//		news.getNews().addAll(noticiasDWE);
//		ArrayList noticiasDWT= LectorRSS.LeerRSSDW("http://rss.dw.com/atom/rss_en_science"); //tec
//		news.getNews().addAll(noticiasDWE);

                LectorRSS lector1 = new LectorRSS("RS","http://feeds.reuters.com/reuters/businessNews/",countDownLatch);
		LectorRSS lector2 = new LectorRSS("RS","http://feeds.reuters.com/reuters/entertainment/",countDownLatch);
		LectorRSS lector3 = new LectorRSS("RS","http://feeds.reuters.com/reuters/technologyNews/",countDownLatch);
		LectorRSS lector4 = new LectorRSS("RS","http://feeds.mashable.com/mashable/tech/",countDownLatch);
		LectorRSS lector5 = new LectorRSS("RS","http://feeds.mashable.com/mashable/business/",countDownLatch);
		LectorRSS lector6 = new LectorRSS("RS","http://feeds.mashable.com/mashable/entertainment",countDownLatch);
                LectorRSS lector7 = new LectorRSS("DW","http://rss.dw.com/atom/rss-en-bus",countDownLatch);
		LectorRSS lector8 = new LectorRSS("DW","http://rss.dw.com/atom/rss-en-cul",countDownLatch);
		LectorRSS lector9 = new LectorRSS("DW","http://rss.dw.com/atom/rss_en_science",countDownLatch);
		                
		lector1.start();
		lector2.start();
		lector3.start();
		lector4.start();
		lector5.start();
		lector6.start();
		lector7.start();
		lector8.start();
		lector9.start();
                
                try {
                    countDownLatch.await();
                    System.out.println("latch");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Wait for countdown
                        
		news.getNews().addAll(lector1.getNoticiias());
		news.getNews().addAll(lector2.getNoticiias());
		news.getNews().addAll(lector3.getNoticiias());
		news.getNews().addAll(lector4.getNoticiias());
		news.getNews().addAll(lector5.getNoticiias());
		news.getNews().addAll(lector6.getNoticiias());
		news.getNews().addAll(lector7.getNoticiias());
		news.getNews().addAll(lector8.getNoticiias());
		news.getNews().addAll(lector9.getNoticiias());
                
                        
		System.out.println(news.len());
            try {
                marshalingExample();

            } catch (JAXBException ex) {
                Logger.getLogger(ReadSaveRss.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            return news;
            
        }

	private static void unMarshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(News.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		News emps = (News) jaxbUnmarshaller.unmarshal( new File("../XMLS/noticias.xml") );
		
		for(Noticiia emp : emps.getNews())
		{
//			System.out.println(emp.getId());
//			System.out.println(emp.getFirstName());
		}
	}

	//pasa a xml estandar todas noticias
	private static void marshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(News.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller(); 
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                
               // System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
                //jaxbMarshaller.marshal(news, System.out); 
                File a = new File("noticias.xml");
		jaxbMarshaller.marshal(news, a);
                XMLFIle = a.getAbsolutePath().replace("\\", "/");
                System.out.println("RSS.ReadSaveRss.marshalingExample()"+XMLFIle);
//                System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
                
               // System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                try{
                File file = new File("noticias.xml");
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                document = documentBuilder.parse(file);
                    //System.out.println("RSS.ReadSaveRss.marshalingExample()"+usr);
                }
                catch(Exception e){
                    System.out.println("RSS.ReadSaveRss.marshalingExample()"+e);
                }
	}
        
        public static ArrayList<Noticiia> filtarXquery(String tipoFiltro, String palabraClave){
            
        String hola = "<books> <book category=\"JAVA\">  </book> </books>";// string base
        Processor saxon = new Processor(false);
        net.sf.saxon.s9api.DocumentBuilder builder = saxon.newDocumentBuilder();
        Source src    = new StreamSource(new StringReader(hola));
        XdmNode doc;
        ArrayList<Noticiia> retorno = new ArrayList<Noticiia>();
        	try {
				doc = builder.build(src);
			      XQueryCompiler compiler = saxon.newXQueryCompiler();
//			      compiler.declareNamespace("books", hola);
			      
			      XQueryExecutable exec = compiler.compile("for $x in"+" doc(\""+XMLFIle+"\")"+"/news/new[contains("+tipoFiltro+",'"+palabraClave+"')] return concat( data($x/titulo), '________', data($x/fecha),'________', data($x/enlace))");

			      XQueryEvaluator querys = exec.load();
			      
			      querys.setContextItem(doc);
//			      XdmValue result = querys.evaluate();
			      Iterator rest = querys.iterator();
                           
                              
			      while (rest.hasNext()) {
                                  String next = rest.next().toString();
                                  Noticiia a = new Noticiia();
                                  a.setCategoria("");
                                  a.setDescripcion("");
                                  System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"+next.split("________").length);
                                  if (next.split("________").length==3){
                                    a.setEnlace(next.split("________")[2]);
                                    a.setFecha(next.split("________")[1]);
                                    a.setTitulo(next.split("________")[0]);
                                  retorno.add(a); 
                                  }

                                System.out.println("RSS.ReadSaveRss.filtarXquery()"+a.getTitulo());

                                System.out.println("RSS.ReadSaveRss.filtarXquery()"+a.getFecha());

                                  System.out.println("RSS.ReadSaveRss.filtarXquery()"+a.getEnlace());

		          System.out.println(hola);
		       }
			} catch (SaxonApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
                return retorno;
        }
        
        
         public static ArrayList<Noticiia> filtarRegex(String tipoFiltro, String palabraClave){
             
            ArrayList<Noticiia> retorno = new ArrayList<Noticiia>();

             
             if(news.getNews() != null){
                 System.out.println("RSS.ReadSaveRss.filtarRegex()"+"NOOOOOOOOOOOOOOOOOOOOO");
                    for (int i= 0; i<news.getNews().size();i++){
                     
                        if(tipoFiltro.equalsIgnoreCase("categoria") && Pattern.compile("\\b"+palabraClave+"\\b").matcher(news.getNews().get(i).getCategoria()).find()){
                            retorno.add(news.getNews().get(i));
                            System.out.println("RSS.ReadSaveRss.filtarRegex()"+news.getNews().get(i).getCategoria());
                        }
                        else if(tipoFiltro.equalsIgnoreCase("titulo") && Pattern.compile("\\b"+palabraClave+"\\b").matcher(news.getNews().get(i).getTitulo()).find()){
                            retorno.add(news.getNews().get(i));
                                                        System.out.println("RSS.ReadSaveRss.filtarRegex()"+news.getNews().get(i).getTitulo());

                        }
                       else if(tipoFiltro.equalsIgnoreCase("descripcion")&& Pattern.compile("\\b"+palabraClave+"\\b").matcher(news.getNews().get(i).getDescripcion()).find()){
                           retorno.add(news.getNews().get(i));
                                                       System.out.println("RSS.ReadSaveRss.filtarRegex()"+news.getNews().get(i).getDescripcion());

                        }
                 }
                 
             }else{

                 System.out.println("RSS.ReadSaveRss.filtarRegex()"+"NULOOOOOOOOO");
             }
             
             return retorno;
         }


}