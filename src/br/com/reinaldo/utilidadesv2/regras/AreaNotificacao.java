/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2.regras;

import br.com.reinaldo.utilidadesv2.constantes.VariaveisComuns;
import br.com.reinaldo.utilidadesv2.utils.CryptoUtil;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.Timer;

/**
 *
 * @author desenv
 */
public class AreaNotificacao {

    public static MenuItem acaoSair() {
        final MenuItem sair = new MenuItem("Sair");
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });
        return sair;
    }

    public static MenuItem abrirCryptoPass() {
        final MenuItem cryptoPass = new MenuItem("Abrir");
        cryptoPass.addActionListener(getAcaoPadrao());
        return cryptoPass;
    }

    public static ActionListener getAcaoPadrao() {
        return new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                // Se eh a primeira vez que o programa/janela esta sendo aberto, ou se a opcao 
                // de bloqueio por senha esta marcada, entao vai solicitar uma senha para poder
                // abrir a janela
                if (VariaveisComuns.BLOQUEIO_COM_SENHA) {
                    final JPasswordField pf = new JPasswordField();
                    final int okCxl = JOptionPane.showConfirmDialog(null, pf, "Utilidades V2 -  enter password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (okCxl == JOptionPane.OK_OPTION) {
                        try {
                            final String password = new String(pf.getPassword());
                            final String passEncryptadoDigitado = CryptoUtil.getInstance().encrypt(VariaveisComuns.HASH, password);
                            final String passEncryptadoPrograma = VariaveisComuns.SENHA_APP;

                            if (passEncryptadoDigitado.equals(passEncryptadoPrograma)) {
                                VariaveisComuns.JANELA_PRINCIPAL.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "You shall not pass", "Senha incorreta", JOptionPane.ERROR_MESSAGE);
                                System.err.println("You shall not pass");
                            }
                        } catch (Exception ex) {

                        }
                    }
                } // Se a opcao de bloqueio por senha esta desabilidada, a janela sera aberta sem precisar de senha
                else {
                    VariaveisComuns.JANELA_PRINCIPAL.setVisible(true);
                }

            }
        };
    }

    public static void criarSystemTrayInicial() {
        try {
            // Carregar a imagem que sera utilizada como icone, deve existir no mesmo diretorio do jar
            final Image image = Toolkit.getDefaultToolkit().getImage("utilidadesV2.png");
            final PopupMenu trayPopupMenu = new PopupMenu();

            // Submenu para as diversas janelas do direct
            trayPopupMenu.add(abrirCryptoPass());
            trayPopupMenu.add(acaoSair());

            // Adicao do icone, menu e tooltip ao objeto
            final TrayIcon trayIcon = new TrayIcon(image, "UTILIDADES: Dia juliano de hoje[" + Calendar.getInstance().get(Calendar.DAY_OF_YEAR) + "]", trayPopupMenu);
            trayIcon.setImageAutoSize(true);
            trayIcon.addActionListener(getAcaoPadrao());

            // Forca o objeto a ser inserido na area de notificacao
            VariaveisComuns.systemTray.add(trayIcon);

            final ActionListener timerAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    trayIcon.setToolTip("UTILIDADES: Dia juliano de hoje[" + Calendar.getInstance().get(Calendar.DAY_OF_YEAR) + "]");
                }
            };

            final Timer timer = new Timer(14400000, timerAction);
            timer.start();

        } catch (Exception ex) {
            System.out.println("Nao foi possivel criar o objeto na area de notificacao do windows " + ex.getMessage());
            ex.printStackTrace();
        }

    }

}
