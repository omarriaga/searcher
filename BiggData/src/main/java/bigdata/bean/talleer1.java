
package bigdata.bean;

import RSS.Noticiia;
import RSS.ReadSaveRss;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;


@ManagedBean(name ="talleer1")
@SessionScoped
public class talleer1 implements Serializable {

    
    private boolean booleanoRss;
    private boolean booleanocRAWLER = false;
    private boolean booleanoXQuery;
    private boolean booleanoRG;
    private String tipoFiltro;
    private String palabraClave;
    private String tipoFiltroRG;
    private String palabraClaveRG;
    
    @ManagedProperty("#{managmentbooleans}")
    private Managmentbooleans mng;

    private ArrayList<Noticiia> noticiasRss; // Noticias originales
    private ArrayList<Noticiia> noticiasRssF; // Noticias originales

    private ArrayList<Noticiia> noticiasRssRegEx; // Noticias filtradas con expresiones
    private ArrayList<Noticiia> noticiasRssXquery; // Noticias filtradas con XQuery
    private Map<String,String> dropD;
    private ReadSaveRss rss;

        @PostConstruct
    public void init() {
        setDropD(new HashMap<String, String>());
        getDropD().put("Titulo", "titulo");
        getDropD().put("Categoria", "categoria");
        getDropD().put("Descripción", "descripcion");
        booleanoRss = false;
        setBooleanoRG(false);
        setBooleanoXQuery(false);
        rss = new ReadSaveRss();

        //booleanoRss = getMng().isBooleanoRss();
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
     * @return the noticiasRssF
     */
    public ArrayList<Noticiia> getnoticiasRssF() {
        return noticiasRssF;
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
    public void setnoticiasRssF(ArrayList<Noticiia> noticiasRssF) {
        this.noticiasRssF = noticiasRssF;
    }

        
    public void onCountryChange() {
            System.out.println("bigdata.bean.talleer1.onCountryChange()"+"ABABABABABA");
    }

    public void onCountryChange2() {
            System.out.println("bigdata.bean.talleer1.onCountryChange()"+"ABABABABABA");
    }
    /**
     * @return the dropD
     */
    public Map<String,String> getDropD() {
        return dropD;
    }

    /**
     * @param dropD the dropD to set
     */
    public void setDropD(Map<String,String> dropD) {
        this.dropD = dropD;
    }

    /**
     * @return the tipoFiltro
     */
    public String getTipoFiltro() {
        return tipoFiltro;
    }

    /**
     * @return the palabraClave
     */
    public String getPalabraClave() {
        return palabraClave;
    }

    /**
     * @param tipoFiltro the tipoFiltro to set
     */
    public void setTipoFiltro(String tipoFiltro) {
        this.tipoFiltro = tipoFiltro;
    }

    /**
     * @param palabraClave the palabraClave to set
     */
    public void setPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }
    
 //--------------------------------------------------------------------------Metodos----------------------------------------------------------
    
   
    
        /**
     * @return the mng
     */
    public Managmentbooleans getMng() {
        return mng;
    }

    /**
     * @param mng the mng to set
     */
    public void setMng(Managmentbooleans mng) {
        this.mng = mng;
    }

    /**
     * @return the booleanoXQuery
     */
    public boolean isBooleanoXQuery() {
        return booleanoXQuery;
    }

    /**
     * @param booleanoXQuery the booleanoXQuery to set
     */
    public void setBooleanoXQuery(boolean booleanoXQuery) {
        this.booleanoXQuery = booleanoXQuery;
    }

    /**
     * @return the tipoFiltroRG
     */
    public String getTipoFiltroRG() {
        return tipoFiltroRG;
    }

    /**
     * @return the palabraClaveRG
     */
    public String getPalabraClaveRG() {
        return palabraClaveRG;
    }

    /**
     * @param tipoFiltroRG the tipoFiltroRG to set
     */
    public void setTipoFiltroRG(String tipoFiltroRG) {
        this.tipoFiltroRG = tipoFiltroRG;
    }

    /**
     * @param palabraClaveRG the palabraClaveRG to set
     */
    public void setPalabraClaveRG(String palabraClaveRG) {
        this.palabraClaveRG = palabraClaveRG;
    }

    /**
     * @return the booleanoRG
     */
    public boolean isBooleanoRG() {
        return booleanoRG;
    }

    /**
     * @param booleanoRG the booleanoRG to set
     */
    public void setBooleanoRG(boolean booleanoRG) {
        this.booleanoRG = booleanoRG;
    }

        
    public void booleanFalsos() {
            booleanocRAWLER = false;
            booleanoRss = false; // estamos con rss  
            booleanoXQuery = false;
            booleanoRG = false;
    }
    
     public void ejercicioRSS() {
            booleanocRAWLER = false;
            booleanoRss = true;// estamos con rss
            noticiasRss = (ArrayList<Noticiia>) rss.rss().getNews();          
    }
    
    
    public void filtrajexQuery() {
        booleanoXQuery = true;
        noticiasRssXquery =  rss.filtarXquery(tipoFiltro,palabraClave);
        
    }
    
    public void filtrajeRX(){
        booleanoRG = true;
        noticiasRssRegEx = rss.filtarRegex(tipoFiltroRG,palabraClaveRG);
    }


}
