/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2.regras;

import br.com.reinaldo.utilidadesv2.constantes.VariaveisComuns;
import br.com.reinaldo.utilidadesv2.entidades.MaquinaEntity;
import br.com.reinaldo.utilidadesv2.utils.CryptoUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author desenv
 */
public class CryptoPass {
    
    
    public static void mudarSenhaMaquina(final String maquina, final String novaSenhaAberta) {
        if (VariaveisComuns.MAQUINAS_TODAS.containsKey(maquina)) {
            try {
                final MaquinaEntity meMemoria = VariaveisComuns.MAQUINAS_TODAS.get(maquina);
                final MaquinaEntity meParaGravar = new MaquinaEntity();

                meParaGravar.setDescricao(meMemoria.getDescricao());
                meParaGravar.setGrupo(meMemoria.getGrupo());
                meParaGravar.setLabel(meMemoria.getLabel());
                meParaGravar.setNome(meMemoria.getNome());
                meParaGravar.setSenha(CryptoUtil.getInstance().encrypt(VariaveisComuns.HASH, novaSenhaAberta));
                meParaGravar.setUsuario(meMemoria.getUsuario());
                meParaGravar.setTipoTerminal(meMemoria.getTipoTerminal());
                meParaGravar.setComandoPersonalizado(meMemoria.getComandoPersonalizado());
                meParaGravar.setDominio(meMemoria.getDominio());
                meParaGravar.setIp(meMemoria.getIp());
                meParaGravar.setUrl(meMemoria.getUrl());
                
                alterarSenhaNoProperties(meParaGravar);
            } catch (Exception ex) {
            
            }
        }
    }
    
    
    /**
     * Altera a senha de uma maquina no arquivo de propriedades. <br/>
     * Como nao encontrei uma forma rapida e facil de alterar o meio de um
     * arquivo de texto, sem depender de libs externas, entao o arquivo esta
     * sendo reescrito por completo. Como eh um arquivo pequeno, de alguns Kb de
     * tamanho, isso nao eh um problema.
     *
     * @param maquina Nome do servidor, conforme esta no arquivo de propriedades
     * (Ex: -D-spos3084)
     * @param novaSenha Nova senha aberta, que sera encriptada e atualizada (Ex:
     * pirilampu)
     */
    private static void alterarSenhaNoProperties(final MaquinaEntity maquina) {
        // Primeiro le e carrega todo o arquivo na memoria
        try {
            final BufferedReader br = new BufferedReader(new FileReader(VariaveisComuns.PATH_PROPERTIES));
            final List<String> linhas = new ArrayList<>();
            String linha;
            while ((linha = br.readLine()) != null) {
                // Se a linha corresponde ao servidor cuja senha sera alterada, entao uma nova linha sera criada
                if (linha.startsWith("CRYPTO=") && linha.contains(maquina.getNome()) && linha.contains(maquina.getGrupo()) && linha.contains(maquina.getUsuario())) {
                    linhas.add(maquina.toString());
                } // Caso contrario, se for um outro servidor ou propriedade, apenas o adiciona na lista
                else {
                    linhas.add(linha);
                }
            }
            br.close();

            // Gravar todas as linhas lidas (ou criadas) no arquivo
            final BufferedWriter bw = new BufferedWriter(new FileWriter(VariaveisComuns.PATH_PROPERTIES));
            for (String atual : linhas) {
                bw.write(atual);
                bw.newLine();
            }

            bw.close();

        } catch (Exception ex) {
            System.out.println("Nao foi possivel ler/escrever no arquivo de propriedades " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    
    public static void alterarMaquinaNoProperties(final MaquinaEntity antes, final MaquinaEntity depois) throws Exception {
        // Primeiro le e carrega todo o arquivo na memoria
        try {
            final BufferedReader br = new BufferedReader(new FileReader(VariaveisComuns.PATH_PROPERTIES));
            final List<String> linhas = new ArrayList<>();
            String linha;
            while ((linha = br.readLine()) != null) {
                // Se a linha corresponde ao servidor cuja senha sera alterada, entao uma nova linha sera criada
                if (linha.startsWith("CRYPTO=") && linha.contains(antes.getNome())) {
                    linhas.add(depois.toString());
                } // Caso contrario, se for um outro servidor ou propriedade, apenas o adiciona na lista
                else {
                    linhas.add(linha);
                }
            }
            br.close();

            // Gravar todas as linhas lidas (ou criadas) no arquivo
            final BufferedWriter bw = new BufferedWriter(new FileWriter(VariaveisComuns.PATH_PROPERTIES));
            for (String atual : linhas) {
                bw.write(atual);
                bw.newLine();
            }

            bw.close();

        } catch (Exception ex) {
            System.out.println("Nao foi possivel ler/escrever no arquivo de propriedades " + ex.getMessage());
            ex.printStackTrace();
        }
    }
            
    
}
