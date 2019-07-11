/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2.regras;

import br.com.reinaldo.utilidadesv2.constantes.Constantes;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author desenv
 */
public class GeradorCpfCnpj {

    /**
     * Regras para criacao de CPF
     * 1º) Existirem 9 numeros (9 numeros que podem ser criados de forma aleatoria)
     * 2º) Calcular o primeiro digito verificador com os 9 numeros existentes, utilizando a seguinte formula:
     *        SOMA = (10 * n1) + (9 * n2) + (8 * n3) + (7 * n4) + (6 * n5) + (5 * n6) + (4 * n7) + (3 * n8) + (2 * n9)
     *     Obter o resto da divisao da soma acima pela constante 11 
     *        RESTO = SOMA % 11
     *     Se o resto da divisao for 1 ou 0, entao o digito e igual a ZERO
     *     Se o resto da divisao for maior ou igual a dois, entao eh utilizada a formula 
     *        11 - RESTO
     * 3º) Adicionar o primeiro digito ao final dos numeros base, agora com 10 numeros bases eh 
     *     necessario calcular o segundo digito utilizando a mesma formula, porem iniciando em 11
     *        SOMA = (11 * n1) + (10 * n2) + (9 * n3) + (8 * n4) + (7 * n5) + (6 * n6) + (5 * n7) + (4 * n8) + (3 * n9) + (2 * n10)
     *     Utilizar os mesmos criterios utilizados para o primeiro digito, obter o resto da divisao 
     *     e verificar o que devera ser retornado, se zero ou a formula (11 - RESTO)
     * 4º) Adicionar o segundo digito ao final dos numeros base e imprimir o resultado
     * @param pBase
     * @return 
     */
    public static String gerarCpf(List<Integer> pBase) {
        final List<Integer> base = pBase != null ? pBase : getNumerosBase();

        final int dig1 = getPrimeiroDigito(base);
        base.add(dig1);
        final int dig2 = getSegundoDigito(base);
        base.add(dig2);

        final StringBuilder sb = new StringBuilder();
        for (Integer n : base) {
            sb.append(String.valueOf(n));
        }

        final String numeros = sb.toString();
        sb.append("\t");
        sb.append(numeros.substring(0, 3));
        sb.append(".");
        sb.append(numeros.substring(3, 6));
        sb.append(".");
        sb.append(numeros.substring(6, 9));
        sb.append("-");
        sb.append(numeros.substring(9));

        return sb.toString();
    }

    public static int getPrimeiroDigito(final List<Integer> base) {
        int dig = 0;
        int x = 0;
        for (int i = 10; i >= 2; i--) {
            dig += (i * base.get(x++));
        }

        final int resto = dig % 11;

        if (resto == 0 || resto == 1) {
            return 0;
        } else {
            return 11 - resto;
        }
    }

    public static int getSegundoDigito(final List<Integer> base) {
        int dig = 0;
        int x = 0;
        for (int i = 11; i >= 2; i--) {
            dig += (i * base.get(x++));
        }

        int resto = dig % 11;

        if (resto == 0 || resto == 1) {
            return 0;
        } else {
            return 11 - resto;
        }
    }

    public static List<Integer> getNumerosBase() {
        final List<Integer> base = new ArrayList<>(11);
        for (int i = 0; i < 9; i++) {
            base.add(Constantes.RANDOM.nextInt(9));
        }
        return base;
    }

    public static List<Integer> getNumerosBase(final String param) {
        final List<Integer> base = new ArrayList<>(11);
        for (int i = 0; i < param.length(); i++) {
            base.add(Integer.valueOf(String.valueOf(param.charAt(i))));
        }
        if (base.size() < 9) {
            for (int i = (9 - (9 - base.size())); i < 9; i++) {
                base.add(Constantes.RANDOM.nextInt(9));
            }
        }
        return base;
    }

    public static String getDataParaCPF() {
        final StringBuilder sb = new StringBuilder();
        final Calendar cal = Calendar.getInstance();

        sb.append(String.valueOf(cal.get(Calendar.YEAR)).substring(2));
        sb.append(String.valueOf(cal.get(Calendar.MONTH)));
        sb.append(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));

        return sb.toString();
    }
}
