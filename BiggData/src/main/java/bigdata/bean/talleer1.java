
package bigdata.bean;

import RSS.Noticiia;
import RSS.ReadSaveRss;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name ="talleer1")
@SessionScoped
public class talleer1 implements Serializable {

    private int max_page=3; // Número maximmo de páginas

    private boolean booleanoRss = false;
    private boolean booleanocRAWLER = false;

    
    private ArrayList<Noticiia> noticiasRss; // Noticias originales
    private ArrayList<Noticiia> noticiasRssRegEx; // Noticias filtradas con expresiones
    private ArrayList<Noticiia> noticiasRssXquery; // Noticias filtradas con XQuery

    /**
     * @return the max_page
     */
    public int getMax_page() {
        return max_page;
    }

    /**
     * @return the booleanoEjer
     */
    public boolean isBooleanoCrawler() {
        return booleanocRAWLER;
    }
    /**
     * @return the booleanoEjer
     */
    public boolean isbooleanoRss() {
        return booleanoRss;
    }

    /**
     * @return the NoticiasRss
     */
    public ArrayList<Noticiia> getNoticiasRss() {
        return noticiasRss;
    }

    /**
     * @return the NoticiasRssRegEx
     */
    public ArrayList<Noticiia> getNoticiasRssRegEx() {
        return noticiasRssRegEx;
    }

    /**
     * @return the NoticiasRssXquery
     */
    public ArrayList<Noticiia> getNoticiasRssXquery() {
        return noticiasRssXquery;
    }

    /**
     * @param max_page the max_page to set
     */
    public void setMax_page(int max_page) {
        this.max_page = max_page;
    }

    /**
     * @param booleanoEjer the booleanoEjer to set
     */
    public void setbooleanocRAWLER(boolean booleanocRAWLER) {
        this.booleanocRAWLER = booleanocRAWLER;
    }
    
    /**
     * @param booleanoEjer the booleanoEjer to set
     */
    public void setbooleanoRss(boolean booleanoRss) {
        this.booleanoRss = booleanoRss;
    }
    
    /**
     * @param NoticiasRss the NoticiasRss to set
     */
    public void setNoticiasRss(ArrayList<Noticiia> noticiasRss) {
        this.noticiasRss = noticiasRss;
    }

    /**
     * @param NoticiasRssRegEx the NoticiasRssRegEx to set
     */
    public void setNoticiasRssRegEx(ArrayList<Noticiia> noticiasRssRegEx) {
        this.noticiasRssRegEx = noticiasRssRegEx;
    }

    /**
     * @param NoticiasRssXquery the NoticiasRssXquery to set
     */
    public void setNoticiasRssXquery(ArrayList<Noticiia> noticiasRssXquery) {
        this.noticiasRssXquery = noticiasRssXquery;
    }
    /**
     * Creates a new instance of talleer1
     */
    public talleer1() {
    }
 //--------------------------------------------------------------------------Metodos----------------------------------------------------------
    
    public void ejercicioRSS() {
        // banderas de indicion
            booleanocRAWLER = false;
            booleanoRss = true; // estamos con rss
            ReadSaveRss rss = new ReadSaveRss();
            noticiasRss = (ArrayList<Noticiia>) rss.rss().getNews();
            noticiasRssRegEx = noticiasRss;
            noticiasRssXquery = noticiasRssXquery;
    }
}
