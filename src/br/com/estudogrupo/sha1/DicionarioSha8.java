package br.com.estudogrupo.sha1;

import static br.com.estudogrupo.crypt.Sha1.sha1Password;
import br.com.estudogrupo.dicionarios.*;
import static br.com.estudogrupo.dicionarios.Dicionario3.md5Crytografando;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author higor
 */
public class DicionarioSha8 implements Runnable {

    private String recebe;
    private String lista;

    public String getLista() {
        return lista;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

    public String getRecebe() {
        return recebe;
    }

    public void setRecebe(String recebe) {
        this.recebe = recebe;
    }

    @Override
    public void run() {

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(lista));
            String linha = null;
            while (br.ready()) {
                linha = br.readLine();

                if (sha1Password(linha).equalsIgnoreCase(getRecebe())) {
                    System.out.println("Senha é : " + linha);
                    System.exit(0);
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DicionarioSha8.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DicionarioSha8.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DicionarioSha8.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(DicionarioSha8.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
