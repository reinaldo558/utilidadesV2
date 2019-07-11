/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2;

import br.com.reinaldo.utilidadesv2.constantes.VariaveisComuns;
import br.com.reinaldo.utilidadesv2.regras.AreaNotificacao;
import br.com.reinaldo.utilidadesv2.utils.AcoesComuns;
import br.com.reinaldo.utilidadesv2.utils.CryptoUtil;
import br.com.reinaldo.utilidadesv2.utils.TerminalUtil;
import br.com.reinaldo.utilidadesv2.view.FramePrincipal;
import javax.swing.JOptionPane;

/**
 *
 * @author desenv
 */
public class Inicio {
    
    public static void main(String[] args) {
        try {
            prepararInicioCryptoPass();
            AreaNotificacao.criarSystemTrayInicial();
            VariaveisComuns.JANELA_PRINCIPAL = new FramePrincipal();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
                
    }
    
    
    
    private static void prepararInicioCryptoPass() throws Exception {
        AcoesComuns.procurarProperties();
        // Se o hash ou a senha desse aplicativo estiverem quebrados (ou for o primeiro start), novos serao criados
        if (VariaveisComuns.HASH == null || "".equals(VariaveisComuns.HASH) || VariaveisComuns.SENHA_APP == null || "".equals(VariaveisComuns.SENHA_APP)) {
            final String hashRandom = CryptoUtil.getInstance().getHashRandom();
            AcoesComuns.gravarNovoProperties("HASHLOCAL=" + hashRandom);
            AcoesComuns.adicionarNoProperties("HSM_IPHOST=xxxxxxxxx");
            AcoesComuns.adicionarNoProperties("HSM_PORTA=xxx");
            VariaveisComuns.HASH = hashRandom;
            VariaveisComuns.HSM_CVC_IP = "xxxxxxx";
            VariaveisComuns.HSM_CVC_PORTA = "xxx";
            final String novaSenhaApp = JOptionPane.showInputDialog(null, "Informe uma senha de acesso a este aplicativo", "Utilidades V2", JOptionPane.QUESTION_MESSAGE);
            if (novaSenhaApp != null && !"".equals(novaSenhaApp) && !"".equals(novaSenhaApp.trim())) {
                final String novaSenhaEncryptada = CryptoUtil.getInstance().encrypt(VariaveisComuns.HASH, novaSenhaApp);
                AcoesComuns.adicionarNoProperties("OP=" + novaSenhaEncryptada);
                VariaveisComuns.SENHA_APP = novaSenhaEncryptada;
            } else {
                System.exit(0);
            }
        }
        
    }
}
