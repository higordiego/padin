/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estudogrupo.sha1;

import static br.com.estudogrupo.crypt.Sha1.sha1Password;
import br.com.estudogrupo.dicionarios.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author higor
 */
public class DicionarioSha6 implements Runnable {

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
            Logger.getLogger(Dicionario.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(Dicionario.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DicionarioSha6.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Dicionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String md5Crytografando(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
