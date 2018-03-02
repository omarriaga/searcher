package RSS;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "news")
@XmlAccessorType (XmlAccessType.FIELD)
public class News 
{
	@XmlElement(name = "new")
	private List<Noticiia> newws = null;

	public List<Noticiia> getNews() {
		return newws;
	}

	public void setNews(List<Noticiia> newws) {
		this.newws = newws;
	}

	public int len() {
		// TODO Auto-generated method stub
		return newws.size();
	}

}
