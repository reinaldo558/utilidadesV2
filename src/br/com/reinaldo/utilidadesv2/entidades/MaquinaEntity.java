package br.com.reinaldo.utilidadesv2.entidades;

import br.com.reinaldo.utilidadesv2.constantes.VariaveisComuns;
import br.com.reinaldo.utilidadesv2.utils.CryptoUtil;

public class MaquinaEntity {
    
    public static final int TIPO_TERMINAL_NAVEGADOR = 0;
    public static final int TIPO_TERMINAL_PUTTY = 1;
    public static final int TIPO_TERMINAL_SHELL = 2;
    public static final int TIPO_TERMINAL_PERSONALIZADO = 3;

    private String nome;
    private String usuario;
    private String senha;
    private String grupo;
    private String label;
    private String descricao;
    private String url;
    private int tipoTerminal;
    private String comandoPersonalizado;
    private String ip;
    private String dominio;

    public MaquinaEntity() {
    }

    public MaquinaEntity(final String pGrupo, final String pNome, final String pLabel, final String pUser, 
            final String pPass, final String pDesc, final String pUrl, final int pTipoTerminal, final String pComandoPersonalizado) {
        this.grupo = pGrupo;
        this.nome = pNome;
        this.label = pLabel;
        this.usuario = pUser;
        this.senha = pPass;
        this.descricao = pDesc;
        this.url = pUrl;
        this.tipoTerminal = pTipoTerminal;
        this.comandoPersonalizado = pComandoPersonalizado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Retorna a senha conforme esta no arquivo de propriedades (Ex:
     * 15431742751338204304833834843077878346971025503883679291)
     *
     * @return
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Retorna a senha aberta e completa (Ex: pirilampu)
     *
     * @return
     */
    public String getSenhaAberta() throws Exception {
        if (this.senha != null && !"".equals(this.senha) && !"".equals(this.senha.trim())) {
                return CryptoUtil.getInstance().decrypt(VariaveisComuns.HASH, this.senha);
        }
        return senha;
    }

    /**
     * Retorna apenas os dois primeiros e o ultimo caractere da senha aberta
     * (Ex: para senha "pirilampu" retorna "pi...u")
     *
     * @return
     */
    public String getSenhaReduzida() throws Exception {
        if (this.senha != null && !"".equals(this.senha) && !"".equals(this.senha.trim())) {
            final String aberta = getSenhaAberta();
            if (aberta != null && !"".equals(aberta) && !"".equals(aberta.trim())) {
                return (aberta.substring(0, 2) + "..." + aberta.substring(aberta.length() - 1));
            }
        }
        return getSenhaAberta();
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public String getNomeExibicao() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getNome());
        try {
            if (getDescricao() != null && getDescricao().length() > 1) {
                sb.append(" > ");
                if (getDescricao().length() > 20) {
                    sb.append(getDescricao().substring(0, 20));
                } else {
                    sb.append(getDescricao());
                }
            }
        } catch (Exception ex) {}
        return sb.toString();
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //CRYPTO=Dados||%||spos7010||%||(H) spos7010||%||rs33196||%||N+F4PrSowLk=||%||Maquina web com tomcat para homologacao
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        
        sb.append("CRYPTO=");
        sb.append(this.grupo).append("||%||");
        sb.append(this.nome).append("||%||");
        sb.append(this.label).append("||%||");
        sb.append(this.usuario).append("||%||");
        sb.append(this.senha).append("||%||");
        if (this.descricao != null && !"".equals(this.descricao) && !"".equals(this.descricao.trim())) {
            sb.append(this.descricao).append("||%||");
        } else {
            sb.append("").append("||%||");
        }
        if (this.url != null && !"".equals(this.url) && !"".equals(this.url.trim())) {
            sb.append(this.url).append("||%||");
        } else {
            sb.append("").append("||%||");
        }
        sb.append(this.tipoTerminal).append("||%||");
        if (this.comandoPersonalizado != null && !"".equals(this.comandoPersonalizado) && !"".equals(this.comandoPersonalizado.trim())) {
            sb.append(this.comandoPersonalizado);
        } else {
            sb.append("");
        }
        
        return sb.toString();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTipoTerminal() {
        return tipoTerminal;
    }

    public void setTipoTerminal(int tipoTerminal) {
        this.tipoTerminal = tipoTerminal;
    }

    public String getComandoPersonalizado() {
        return comandoPersonalizado;
    }

    public void setComandoPersonalizado(String comandoPersonalizado) {
        this.comandoPersonalizado = comandoPersonalizado;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }
    
    

}
