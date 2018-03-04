/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigdata.bean;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author AnamaMoha
 */
@ManagedBean(name = "managmentbooleans")
@ApplicationScoped
public class Managmentbooleans {

    /**
     * Creates a new instance of Managmentbooleans
     */
    
    private boolean booleanoRss = false;
    private boolean booleanocRAWLER = false;
    
    public Managmentbooleans() {
    }

    /**
     * @return the booleanoRss
     */
    public boolean isBooleanoRss() {
        return booleanoRss;
    }

    /**
     * @return the booleanocRAWLER
     */
    public boolean isBooleanocRAWLER() {
        return booleanocRAWLER;
    }

    /**
     * @param booleanoRss the booleanoRss to set
     */
    public void setBooleanoRss(boolean booleanoRss) {
        this.booleanoRss = booleanoRss;
    }

    /**
     * @param booleanocRAWLER the booleanocRAWLER to set
     */
    public void setBooleanocRAWLER(boolean booleanocRAWLER) {
        this.booleanocRAWLER = booleanocRAWLER;
    }
    public String changebooleans(){
        //booleanoRss = false;
       // booleanocRAWLER = false;
        return "taller1";

    }
    
}
