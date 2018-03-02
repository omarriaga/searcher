package RSS;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ReadSaveRss 
{
	static News news = new News();
        
        public final static String DIRECCION_XML = "";
        
        
        public static News rss() {
            
            news.setNews(new ArrayList<Noticiia>());
		//Reuters news
		ArrayList noticiasReutersB  = LectorRSS.LeerRSS("http://feeds.reuters.com/reuters/businessNews/");
		news.getNews().addAll(noticiasReutersB);
		ArrayList noticiasReutersT  = LectorRSS.LeerRSS("http://feeds.reuters.com/reuters/technologyNews/");
		news.getNews().addAll(noticiasReutersT);	
		ArrayList noticiasReutersE  = LectorRSS.LeerRSS("http://feeds.reuters.com/reuters/entertainment/");
		news.getNews().addAll(noticiasReutersE);	
		
		//mashable
		ArrayList noticiasmashableT= LectorRSS.LeerRSS("http://feeds.mashable.com/mashable/tech/");
		news.getNews().addAll(noticiasmashableT);
		ArrayList noticiasmashableB= LectorRSS.LeerRSS("http://feeds.mashable.com/mashable/business/");
		news.getNews().addAll(noticiasmashableB);
		ArrayList noticiasmashableE= LectorRSS.LeerRSS("http://feeds.mashable.com/mashable/entertainment");
		news.getNews().addAll(noticiasmashableE);		
		
		//DW
		ArrayList noticiasDWB= LectorRSS.LeerRSSDW("http://rss.dw.com/atom/rss-en-bus");
		news.getNews().addAll(noticiasDWB); 
		ArrayList noticiasDWE= LectorRSS.LeerRSSDW("http://rss.dw.com/atom/rss-en-cul"); //cultural
		news.getNews().addAll(noticiasDWE);
		ArrayList noticiasDWT= LectorRSS.LeerRSSDW("http://rss.dw.com/atom/rss_en_science"); //tec
		news.getNews().addAll(noticiasDWE);
		
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
		jaxbMarshaller.marshal(news, new File("./noticias.xml"));
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
}
