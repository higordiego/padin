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
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author higor
 */
public class DicionarioOnline04 implements Runnable {

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
        HttpPost post = new HttpPost("http://www.md5online.org/");
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("md5", getRecebe()));
            nameValuePairs.add(new BasicNameValuePair("search", "0"));
            nameValuePairs.add(new BasicNameValuePair("action", "decrypt"));
            nameValuePairs.add(new BasicNameValuePair("a", "82355607"));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine().trim()) != null) {
                if (line.startsWith("<span class=\"result\"")) {
                    String key = line.substring(81, 100);
                    System.out.println("Senha é : "+key.trim().replace("</b>", "").replace("</s>", "").replace("</span><br", "").replace(" /", ""));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();

        } catch (NullPointerException e) {

        }

    }

    public static void main(String[] args) {
        DicionarioOnline04 dicionarioOnline04 = new DicionarioOnline04();
        dicionarioOnline04.run();
    }

}
