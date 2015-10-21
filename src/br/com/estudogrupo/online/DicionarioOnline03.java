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
public class DicionarioOnline03 implements Runnable {

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
        HttpPost post = new HttpPost("http://www.cloudcracker.net/index.php");
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("inputbox", getRecebe()));
            nameValuePairs.add(new BasicNameValuePair("submit", "Crack+MD5+Hash"));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine().trim()) != null) {

                if (line.startsWith("Word:")) {
                    String key = line.substring(96);
                    System.out.println("Senha é : " + key.replace("\"", "").replace("/>", ""));
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        } catch (NullPointerException e) {

        }

    }

}
