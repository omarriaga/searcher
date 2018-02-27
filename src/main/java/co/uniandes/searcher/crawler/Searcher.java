/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.searcher.crawler;


import java.io.IOException;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author juan
 */
public class Searcher {

    public void buscar() throws IOException{
        Document doc = Jsoup.connect("https://uniandes.edu.co/").get();
        Elements links = doc.select("a[href]");
        for (Element headline : links) {
           
        }
    }

}
