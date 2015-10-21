/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estudogrupo.principal;

import br.com.estudogrupo.dicionarios.Dicionario;
import br.com.estudogrupo.dicionarios.Dicionario1;
import br.com.estudogrupo.dicionarios.Dicionario2;
import br.com.estudogrupo.dicionarios.Dicionario3;
import br.com.estudogrupo.dicionarios.Dicionario4;
import br.com.estudogrupo.dicionarios.Dicionario5;
import br.com.estudogrupo.dicionarios.Dicionario6;
import br.com.estudogrupo.dicionarios.Dicionario7;
import br.com.estudogrupo.online.DicionarioOnline01;
import br.com.estudogrupo.online.DicionarioOnline02;
import br.com.estudogrupo.online.DicionarioOnline03;
import br.com.estudogrupo.online.DicionarioOnline04;
import br.com.estudogrupo.online.DicionarioOnline05;
import br.com.estudogrupo.sha1.DicionarioSha1;
import br.com.estudogrupo.sha1.DicionarioSha2;
import br.com.estudogrupo.sha1.DicionarioSha3;
import br.com.estudogrupo.sha1.DicionarioSha4;
import br.com.estudogrupo.sha1.DicionarioSha5;
import br.com.estudogrupo.sha1.DicionarioSha6;
import br.com.estudogrupo.sha1.DicionarioSha7;
import br.com.estudogrupo.sha1.DicionarioSha8;
import java.net.UnknownHostException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author higor
 */
public class Principal {

    public static void main(String[] args) throws ParseException {
        Dicionario dicionario = new Dicionario();
        Dicionario1 dicionario1 = new Dicionario1();
        Dicionario2 dicionario2 = new Dicionario2();
        Dicionario3 dicionario3 = new Dicionario3();
        Dicionario4 dicionario4 = new Dicionario4();
        Dicionario5 dicionario5 = new Dicionario5();
        Dicionario6 dicionario6 = new Dicionario6();
        Dicionario7 dicionario7 = new Dicionario7();
        DicionarioSha1 dicionarioSha1 = new DicionarioSha1();
        DicionarioSha2 dicionarioSha2 = new DicionarioSha2();
        DicionarioSha3 dicionarioSha3 = new DicionarioSha3();
        DicionarioSha4 dicionarioSha4 = new DicionarioSha4();
        DicionarioSha5 dicionarioSha5 = new DicionarioSha5();
        DicionarioSha6 dicionarioSha6 = new DicionarioSha6();
        DicionarioSha7 dicionarioSha7 = new DicionarioSha7();
        DicionarioSha8 dicionarioSha8 = new DicionarioSha8();
        CommandLineParser parser = new PosixParser();
        Options options = new Options();
        options.addOption("m", "MD5", true, "Md5 hash");
        options.addOption("s", "SHA1", true, "Sha1 hash");
        options.addOption("b", "BASE64", true, "Base64 hash");
        options.addOption("l1", "Lista 1", true, "WordList");
        options.addOption("l2", "Lista 2", true, "WordList");
        options.addOption("l3", "Lista 3", true, "WordList");
        options.addOption("l4", "Lista 4", true, "WordList");
        options.addOption("l5", "Lista 5", true, "WordList");
        options.addOption("l6", "Lista 6", true, "WordList");
        options.addOption("l7", "Lista 7", true, "WordList");
        options.addOption("l8", "Lista 8", true, "WordList");
        options.addOption("oM", "ONLINE", true, "Busca md5 hash Online");
        int contador = 0;
        int contadodorSha = 0;
        CommandLine line = null;
        try {
            line = parser.parse(options, args);
        } catch (Exception e) {

        }

        try {
            if (line.hasOption("oM")) {
                String pegar = line.getOptionValue("oM");
                DicionarioOnline01 dicionarioOnline01 = new DicionarioOnline01();
                dicionarioOnline01.setRecebe(pegar);
                Thread t1Online = new Thread(dicionarioOnline01);
                t1Online.start();

                //Segunda Thread
                DicionarioOnline02 dicionarioOnline02 = new DicionarioOnline02();
                dicionarioOnline02.setRecebe(pegar);
                Thread t2Online = new Thread(dicionarioOnline02);
                t2Online.start();

                //Terceira Thread
                DicionarioOnline03 dicionarioOnline03 = new DicionarioOnline03();
                dicionarioOnline03.setRecebe(pegar);
                Thread t3Online = new Thread(dicionarioOnline03);
                t3Online.start();

                //Quarta Thread
                DicionarioOnline04 dicionarioOnline04 = new DicionarioOnline04();
                dicionarioOnline04.setRecebe(pegar);
                Thread t4Online = new Thread(dicionarioOnline04);
                t4Online.start();
                //Quinta Thread
                DicionarioOnline05 dicionarioOnline05 = new DicionarioOnline05();
                dicionarioOnline05.setRecebe(pegar);
                Thread t5Online = new Thread(dicionarioOnline05);
                t5Online.start();

                System.out.println(" _____        _____ _____ _   _ \n"
                        + "|  __ \\ /\\   |  __ \\_   _| \\ | |\n"
                        + "| |__) /  \\  | |  | || | |  \\| |\n"
                        + "|  ___/ /\\ \\ | |  | || | | . ` |\n"
                        + "| |  / ____ \\| |__| || |_| |\\  |\n"
                        + "|_| /_/    \\_\\_____/_____|_| \\_|\n"
                        + "                                \n"
                        + "            ");
                System.out.println("Executando...");

            } else if (line.hasOption('m')) {
                if (line.hasOption("l1")) {
                    String recebe = line.getOptionValue('m');
                    String lista = line.getOptionValue("l1");
                    dicionario.setRecebe(recebe);
                    dicionario.setLista(lista);
                    contador++;
                    Thread t1 = new Thread(dicionario);

                    t1.start();

                }
                if (line.hasOption("l2")) {
                    contador++;
                    String recebe = line.getOptionValue('m');
                    String lista = line.getOptionValue("l2");
                    dicionario1.setRecebe(recebe);
                    dicionario1.setLista(lista);
                    Thread t2 = new Thread(dicionario1);

                    t2.start();

                }
                if (line.hasOption("l3")) {
                    contador++;
                    String recebe = line.getOptionValue('m');
                    String lista = line.getOptionValue("l3");
                    dicionario2.setRecebe(recebe);
                    dicionario2.setLista(lista);
                    Thread t3 = new Thread(dicionario2);

                    t3.start();
                }
                if (line.hasOption("l4")) {
                    contador++;
                    String recebe = line.getOptionValue('m');
                    String lista = line.getOptionValue("l3");
                    dicionario3.setRecebe(recebe);
                    dicionario3.setLista(lista);
                    Thread t4 = new Thread(dicionario3);

                    t4.start();

                }
                if (line.hasOption("l5")) {
                    String recebe = line.getOptionValue('m');
                    String lista = line.getOptionValue("l5");
                    dicionario4.setRecebe(recebe);
                    dicionario4.setLista(lista);
                    Thread t5 = new Thread(dicionario4);
                    contador++;

                    t5.start();

                }
                if (line.hasOption("l6")) {
                    contador++;
                    String recebe = line.getOptionValue('m');
                    String lista = line.getOptionValue("l6");
                    dicionario5.setRecebe(recebe);
                    dicionario5.setLista(lista);
                    Thread t6 = new Thread(dicionario5);

                    t6.start();
                }
                if (line.hasOption("l7")) {
                    contador++;
                    String recebe = line.getOptionValue('m');
                    String lista = line.getOptionValue("l7");
                    dicionario6.setRecebe(recebe);
                    dicionario6.setLista(lista);
                    Thread t6 = new Thread(dicionario6);

                    t6.start();
                }
                if (line.hasOption("l8")) {
                    contador++;
                    String recebe = line.getOptionValue('m');
                    String lista = line.getOptionValue("l8");
                    dicionario7.setRecebe(recebe);
                    dicionario7.setLista(lista);
                    Thread t7 = new Thread(dicionario7);

                    t7.start();

                }
                if (contador > 0) {
                    System.out.println(" _____        _____ _____ _   _ \n"
                            + "|  __ \\ /\\   |  __ \\_   _| \\ | |\n"
                            + "| |__) /  \\  | |  | || | |  \\| |\n"
                            + "|  ___/ /\\ \\ | |  | || | | . ` |\n"
                            + "| |  / ____ \\| |__| || |_| |\\  |\n"
                            + "|_| /_/    \\_\\_____/_____|_| \\_|\n"
                            + "                                \n"
                            + "            ");
                    System.out.println("Executando...");
                    contador = 0;

                }
            } else if (line.hasOption('s')) {
                if (line.hasOption("l1")) {
                    contadodorSha++;
                    String pegar = line.getOptionValue('s');
                    String lista = line.getOptionValue("l1");
                    dicionarioSha1.setRecebe(pegar);
                    dicionarioSha1.setLista(lista);
                    Thread t1 = new Thread(dicionarioSha1);

                    t1.start();
                } else if (line.hasOption("l2")) {
                    contadodorSha++;
                    String pegar = line.getOptionValue('s');
                    String lista = line.getOptionValue("l2");
                    dicionarioSha2.setRecebe(pegar);
                    dicionarioSha2.setLista(lista);
                    Thread t2 = new Thread(dicionarioSha2);

                    t2.start();
                } else if (line.hasOption("l3")) {
                    String pegar = line.getOptionValue('s');
                    String lista = line.getOptionValue("l3");
                    dicionarioSha3.setRecebe(pegar);
                    dicionarioSha3.setLista(lista);
                    Thread t3 = new Thread(dicionarioSha3);
                    contadodorSha++;
                    t3.start();
                } else if (line.hasOption("l4")) {
                    String pegar = line.getOptionValue('s');
                    String lista = line.getOptionValue("l4");
                    dicionarioSha4.setRecebe(pegar);
                    dicionarioSha4.setLista(lista);
                    Thread t4 = new Thread(dicionarioSha4);
                    contadodorSha++;
                    t4.start();
                } else if (line.hasOption("l5")) {
                    String pegar = line.getOptionValue('s');
                    String lista = line.getOptionValue("l5");
                    dicionarioSha5.setRecebe(pegar);
                    dicionarioSha5.setLista(lista);
                    Thread t5 = new Thread(dicionarioSha5);
                    contador++;
                    t5.start();
                } else if (line.hasOption("l6")) {
                    String pegar = line.getOptionValue('s');
                    String lista = line.getOptionValue("l6");
                    dicionarioSha6.setRecebe(pegar);
                    dicionarioSha6.setLista(lista);
                    Thread t6 = new Thread(dicionarioSha6);
                    contadodorSha++;
                    t6.start();
                } else if (line.hasOption("l7")) {
                    String pegar = line.getOptionValue('s');
                    String lista = line.getOptionValue("l7");
                    dicionarioSha7.setRecebe(pegar);
                    dicionarioSha7.setLista(lista);
                    Thread t7 = new Thread(dicionarioSha7);
                    contadodorSha++;
                    t7.start();
                } else {
                    HelpFormatter formatter = new HelpFormatter();
                    formatter.printHelp(" _____        _____ _____ _   _ \n"
                            + "|  __ \\ /\\   |  __ \\_   _| \\ | |\n"
                            + "| |__) /  \\  | |  | || | |  \\| |\n"
                            + "|  ___/ /\\ \\ | |  | || | | . ` |\n"
                            + "| |  / ____ \\| |__| || |_| |\\  |\n"
                            + "|_| /_/    \\_\\_____/_____|_| \\_|\n\n\n"
                            + "                                \n"
                            + "   \n"
                            + "                              \n"
                            + "\n"
                            + "\n"
                            + "\n "
                            + "\n", options);
                }
                if (contadodorSha > 0) {
                    System.out.println(" _____        _____ _____ _   _ \n"
                            + "|  __ \\ /\\   |  __ \\_   _| \\ | |\n"
                            + "| |__) /  \\  | |  | || | |  \\| |\n"
                            + "|  ___/ /\\ \\ | |  | || | | . ` |\n"
                            + "| |  / ____ \\| |__| || |_| |\\  |\n"
                            + "|_| /_/    \\_\\_____/_____|_| \\_|\n"
                            + "                                \n"
                            + "            ");
                    System.out.println("Executando...");
                    contadodorSha = 0;
                }

            } else if (line.hasOption('b')) {
                String pegar = line.getOptionValue('b');
                System.out.println(" _____        _____ _____ _   _ \n"
                        + "|  __ \\ /\\   |  __ \\_   _| \\ | |\n"
                        + "| |__) /  \\  | |  | || | |  \\| |\n"
                        + "|  ___/ /\\ \\ | |  | || | | . ` |\n"
                        + "| |  / ____ \\| |__| || |_| |\\  |\n"
                        + "|_| /_/    \\_\\_____/_____|_| \\_|\n"
                        + "                                \n"
                        + "            ");
                System.out.println("executando...");
                byte[] decoder = Base64.decodeBase64(pegar.getBytes());
                System.out.println("Senha é: " + new String(decoder));

            } else {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp(" _____        _____ _____ _   _ \n"
                        + "|  __ \\ /\\   |  __ \\_   _| \\ | |\n"
                        + "| |__) /  \\  | |  | || | |  \\| |\n"
                        + "|  ___/ /\\ \\ | |  | || | | . ` |\n"
                        + "| |  / ____ \\| |__| || |_| |\\  |\n"
                        + "|_| /_/    \\_\\_____/_____|_| \\_|\n\n\n"
                        + "                                \n"
                        + "   \n"
                        + "                              \n"
                        + "\n"
                        + "\n"
                        + "\n "
                        + "\n", options);
            }

        } catch (NullPointerException e) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp(" _____        _____ _____ _   _ \n"
                    + "|  __ \\ /\\   |  __ \\_   _| \\ | |\n"
                    + "| |__) /  \\  | |  | || | |  \\| |\n"
                    + "|  ___/ /\\ \\ | |  | || | | . ` |\n"
                    + "| |  / ____ \\| |__| || |_| |\\  |\n"
                    + "|_| /_/    \\_\\_____/_____|_| \\_|\n\n\n"
                    + "                                \n"
                    + "   \n"
                    + "                              \n"
                    + "\n"
                    + "\n"
                    + "\n "
                    + "\n", options);
        }

    }
}
