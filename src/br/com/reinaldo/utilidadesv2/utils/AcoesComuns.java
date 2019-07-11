/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2.utils;

import br.com.reinaldo.utilidadesv2.constantes.VariaveisComuns;
import br.com.reinaldo.utilidadesv2.entidades.MaquinaEntity;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author desenv
 */
public class AcoesComuns {

    public static void copiarParaAreaTransferencia(final String texto) {
        final Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        final Clipboard systemClipboard = defaultToolkit.getSystemClipboard();
        systemClipboard.setContents(new StringSelection(texto), null);
    }

    /**
     * Procura o arquivo de propriedades no local padrao, definido em
     * {@link Objetos#PATH_PROPERTIES}. <br/>
     * Se o arquivo de propriedades existir, le este arquivo inteiro convertendo
     * as strings encontradas em objetos uteis para este programa.
     *
     * @see Objetos#SENHA_APP
     * @see Objetos#MAQUINAS
     * @see Objetos#MAQUINAS_TODAS
     */
    public static void procurarProperties() {
        try {
            VariaveisComuns.MAQUINAS_TODAS.clear();
            VariaveisComuns.MAQUINAS.clear();
            
            final BufferedReader br = new BufferedReader(new FileReader(VariaveisComuns.PATH_PROPERTIES));
            String linha;
            while ((linha = br.readLine()) != null) {
                // Verifica se a linha atual se refere a senha de acesso ao aplicativo
                if (linha.startsWith("OP=")) {
                    VariaveisComuns.SENHA_APP = linha.substring(3);
                } // Verifica se a linha atual se refere ao hash do algoritmo de criptografia
                else if (linha.startsWith("HASHLOCAL=")) {
                    VariaveisComuns.HASH = linha.substring(10);
                }  // Controla a conversao de dados dos servidores
                else if (linha.startsWith("CRYPTO=")) {
                    try {
                        final String[] str = linha.substring(7).split("\\|\\|%\\|\\|");
                        // Este loop esta sendo aproveitado para criar este outro para, para facilitar as acoes na janela
                        final MaquinaEntity maquina = 
                                str.length == 9 ?
                                new MaquinaEntity(str[0], str[1], str[2], str[3], str[4], str[5], str[6], Integer.parseInt(str[7]), str[8])
                                :
                                new MaquinaEntity(str[0], str[1], str[2], str[3], str[4], str[5], str[6], Integer.parseInt(str[7]), "");
                        VariaveisComuns.MAQUINAS_TODAS.put(str[1], maquina);
                        
                        // Adiciona ao mapa principal, que sera responsavel por gerenciar o objeto JTree
                        if (VariaveisComuns.MAQUINAS.containsKey(str[0])) {
                            VariaveisComuns.MAQUINAS.get(str[0]).add(maquina);
                        } else {
                            final List<MaquinaEntity> lista = new ArrayList<>();
                            lista.add(maquina);
                            VariaveisComuns.MAQUINAS.put(str[0], lista);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (linha.startsWith("HSM_IPHOST=")) {
                    VariaveisComuns.HSM_CVC_IP = linha.substring(11);
                } else if (linha.startsWith("HSM_PORTA=")) {
                    VariaveisComuns.HSM_CVC_PORTA = linha.substring(10);
                }
            }
            br.close();
        } catch (Exception ex) {
            System.out.println("Nao foi possivel ler o arquivo de propriedades " + ex.getMessage());
        }
        
        
        procurarIpsNomes();
        
    }
    
    
    private static void procurarIpsNomes() {
        try {
            new Thread(() -> {
                final Set<String> chaves = VariaveisComuns.MAQUINAS_TODAS.keySet();
                for (String atual : chaves) {
                    if (atual.toLowerCase().startsWith("spos")) {
                        System.out.print("\nProcurando " + atual);
                        final MaquinaEntity maquina = VariaveisComuns.MAQUINAS_TODAS.get(atual);
                        InetAddress inet;
                        try {
                            inet = InetAddress.getByName(maquina.getNome() + ".prod.cetelem.com.br");
                            maquina.setIp(inet.getHostAddress());
                            maquina.setDominio(inet.getHostName());
                            VariaveisComuns.MAQUINAS_TODAS.put(atual, maquina);
                            System.out.print(" => Encontrado " + inet.getHostName() + "/" + inet.getHostAddress());
                        } catch (UnknownHostException uhex) {
                            try {
                                inet = InetAddress.getByName(maquina.getNome() + ".teste.cetelem.com.br");
                                maquina.setIp(inet.getHostAddress());
                                maquina.setDominio(inet.getHostName());
                                VariaveisComuns.MAQUINAS_TODAS.put(atual, maquina);
                                System.out.print(" => Encontrado " + inet.getHostName() + "/" + inet.getHostAddress());
                            } catch (Exception ex2) {
                                System.out.printf(ex2.getMessage());
                            }
                        } catch (Exception ex1) {
                            System.out.printf(ex1.getMessage());
                        }
                    }
                }
                System.out.println("\nFim da busca de enderecos/ips");
            }).start();
        } catch (Exception ex) {
        
        }
    }
    
    
    public static void gravarNovoProperties(final String texto) {
        try  {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(VariaveisComuns.PATH_PROPERTIES, false))) {
                bw.write(texto);
                bw.newLine();
            }
        } catch (Exception ex) {
            System.out.println("Erro ao tentar gravar o novo acesso no arquivo de propriedades");
            ex.printStackTrace();
        }
    }
    
    
    public static void adicionarNoProperties(final String texto) {
        try  {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(VariaveisComuns.PATH_PROPERTIES, true))) {
                bw.write(texto);
                bw.newLine();
            }
        } catch (Exception ex) {
            System.out.println("Erro ao tentar gravar o novo acesso no arquivo de propriedades");
            ex.printStackTrace();
        }
    }
    
    
    /**
     * Retorna <b>TRUE</b> se o parametro for nulo ou vazio<br/>
     * Retorno <b>FALSE</b> se o parametro possuir algum valor diferente de espacos<br/><br/>
     * Realiza um trim no objeto<br/>
     * @param param
     * @return 
     */
    public static boolean isVazio(final String param) {
        return param == null || "".equals(param) || "".equals(param.trim());
    }
    
    
    
    public static String salvarEmArquivo(final JFrame parent, final List<String> listaTexto) {
        final JFileChooser jfc = new JFileChooser("~/");
        jfc.setApproveButtonText("Salvar");
        jfc.setApproveButtonToolTipText("Salvar");
        jfc.setDialogTitle("Salvar o historico de comandos enviados");
        jfc.setDialogType(JFileChooser.SAVE_DIALOG);
        int op = jfc.showSaveDialog(parent);
        if (op == JFileChooser.APPROVE_OPTION) {
            try {
                final String path = jfc.getSelectedFile().getAbsolutePath();
                final File f = new File(path);
                final FileOutputStream out = new FileOutputStream(f);
                final DataOutputStream dOut = new DataOutputStream(out);
                for (String historico1 : listaTexto) {
                    dOut.writeUTF((String) historico1);
                    dOut.writeUTF("\n\n");
                }
                dOut.close();
                out.close();
                return "Arquivo salvo com sucesso:\n" + path;
            } catch (Exception ex) {
                return "Ocorreu um erro ao salvar o arquivo: " + ex.getMessage();
            }
        }
        return "";
    }
    
    
    public static String escolherDiretorio(final JFrame parent) {
        final JFileChooser jfc = new JFileChooser("~/");
        jfc.setApproveButtonText("Salvar");
        jfc.setApproveButtonToolTipText("Salvar");
        jfc.setDialogTitle("Salvar o historico de comandos enviados");
        jfc.setDialogType(JFileChooser.SAVE_DIALOG);
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        int op = jfc.showSaveDialog(parent);
        if (op == JFileChooser.APPROVE_OPTION) {
            return jfc.getSelectedFile().getAbsolutePath();
        }
        return "";
    }

}
