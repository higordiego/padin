/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estudogrupo.online;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author higor
 */
public class DicionarioOnline05 implements Runnable {

    private String recebe;

    public String getRecebe() {
        return recebe;
    }

    public void setRecebe(String recebe) {
        this.recebe = recebe;
    }

    @Override
    public void run() {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://hashtoolkit.com/reverse-hash?hash=" + getRecebe());
        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException ex) {
            Logger.getLogger(DicionarioOnline05.class.getName()).log(Level.SEVERE, null, ex);
        }

// Get the response
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException ex) {
            Logger.getLogger(DicionarioOnline05.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(DicionarioOnline05.class.getName()).log(Level.SEVERE, null, ex);
        }

        String line = "";
        try {
            while ((line = rd.readLine().trim()) != null) {
                if (line.startsWith("<span style=\"float: right;\"><a href=\"/generate-hash/?text=")) {
                    String key = line.substring(58, 70);
                    System.out.println("Senha é : " + key.replaceAll("\"><span", ""));
                    System.exit(0);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DicionarioOnline05.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {

        }

    }

    public static void main(String[] args) {
        DicionarioOnline05 dicionarioOnline04 = new DicionarioOnline05();
        dicionarioOnline04.run();
    }

}
