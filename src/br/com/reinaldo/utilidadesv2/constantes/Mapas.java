package br.com.reinaldo.utilidadesv2.constantes;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rs42134
 */
public class Mapas {
    
    
    private Mapas() {}
    
    public static Map<String, String> criarMapaHtmlString() {
        Map mapa = new HashMap(70);
        mapa.put("&aacute;", "á");mapa.put("&agrave;", "à");mapa.put("&acirc;" , "â");mapa.put("&atilde;", "ã");mapa.put("&auml;"  , "ä");mapa.put("&aelig;" , "æ");
        mapa.put("&Aacute;", "Á");mapa.put("&Agrave;", "À");mapa.put("&Acirc;" , "Â");mapa.put("&Atilde;", "Ã");mapa.put("&Auml;"  , "Ä");mapa.put("&AElig;" , "Æ");
        mapa.put("&eacute;", "é");mapa.put("&egrave;", "è");mapa.put("&ecirc;" , "ê");mapa.put("&euml;"  , "ë");mapa.put("&eth;"   , "ð");
        mapa.put("&Eacute;", "É");mapa.put("&Egrave;", "È");mapa.put("&Ecirc;" , "Ê");mapa.put("&Euml;"  , "Ë");mapa.put("&ETH;"   , "Ð");
        mapa.put("&iacute;", "í");mapa.put("&igrave;", "ì");mapa.put("&icirc;" , "î");mapa.put("&iuml;"  , "ï");
        mapa.put("&Iacute;", "Í");mapa.put("&Igrave;", "Ì");mapa.put("&Icirc;" , "Î");mapa.put("&Iuml;"  , "Ï");
        mapa.put("&oacute;", "ó");mapa.put("&ograve;", "ò");mapa.put("&ocirc;" , "ô");mapa.put("&otilde;", "õ");mapa.put("&oslash;", "ø");mapa.put("&ouml;"  , "ö");
        mapa.put("&Oacute;", "Ó");mapa.put("&Ograve;", "Ò");mapa.put("&Ocirc;" , "Ô");mapa.put("&Otilde;", "Õ");mapa.put("&Oslash;", "Ø");mapa.put("&Ouml;"  , "Ö");
        mapa.put("&uacute;", "ú");mapa.put("&ugrave;", "ù");mapa.put("&ucirc;" , "û");mapa.put("&uuml;"  , "ü");
        mapa.put("&Uacute;", "Ú");mapa.put("&Ugrave;", "Ù");mapa.put("&Ucirc;" , "Û");mapa.put("&Uuml;"  , "Ü");
        mapa.put("&cedil;" , "ç");mapa.put("&Ccedil;", "Ç");mapa.put("&Ntilde;", "Ñ");mapa.put("&ntilde;", "ñ");
        mapa.put("&Yacute;", "Ý");mapa.put("&yacute;", "ý");mapa.put("&reg;"   , "®");mapa.put("&copy;"  , "©");
        mapa.put("&THORN;" , "Þ");mapa.put("&thorn;" , "þ");mapa.put("&szlig;" , "ß");
        mapa.put("&gt;"    , ">");mapa.put("&lt;"    , "<");mapa.put("&amp;"   , "&");mapa.put("&quot;"  , "\"");
        return mapa;
    }
        
    
    public static Map<String, String> criarMapaStringHtml() {
        Map mapa = new HashMap(70);
        mapa.put("á", "&aacute;");mapa.put("à", "&agrave;");mapa.put("â", "&acirc;");mapa.put("ã", "&atilde;");mapa.put("ä", "&auml;");mapa.put("æ", "&aelig;");
        mapa.put("Á", "&Aacute;");mapa.put("À", "&Agrave;");mapa.put("Â", "&Acirc;");mapa.put("Ã", "&Atilde;");mapa.put("Ä", "&Auml;");mapa.put("Æ", "&AElig;");
        mapa.put("é", "&eacute;");mapa.put("è", "&egrave;");mapa.put("ê", "&ecirc;");mapa.put("ë", "&euml;");mapa.put("ð", "&eth;");
        mapa.put("É", "&Eacute;");mapa.put("È", "&Egrave;");mapa.put("Ê", "&Ecirc;");mapa.put("Ë", "&Euml;");mapa.put("Ð", "&ETH;");
        mapa.put("í", "&iacute;");mapa.put("ì", "&igrave;");mapa.put("î", "&icirc;");mapa.put("ï", "&iuml;");
        mapa.put("Í", "&Iacute;");mapa.put("Ì", "&Igrave;");mapa.put("Î", "&Icirc;");mapa.put("Ï", "&Iuml;");
        mapa.put("ó", "&oacute;");mapa.put("ò", "&ograve;");mapa.put("ô", "&ocirc;");mapa.put("õ", "&otilde;");mapa.put("ø", "&oslash;");mapa.put("ö", "&ouml;");
        mapa.put("Ó", "&Oacute;");mapa.put("Ò", "&Ograve;");mapa.put("Ô", "&Ocirc;");mapa.put("Õ", "&Otilde;");mapa.put("Ø", "&Oslash;");mapa.put("Ö", "&Ouml;");
        mapa.put("ú", "&uacute;");mapa.put("ù", "&ugrave;");mapa.put("û", "&ucirc;");mapa.put("ü", "&uuml;");
        mapa.put("Ú", "&Uacute;");mapa.put("Ù", "&Ugrave;");mapa.put("Û", "&Ucirc;");mapa.put("Ü", "&Uuml;");
        mapa.put("ç", "&cedil;");mapa.put("Ç", "&Ccedil;");mapa.put("Ñ", "&Ntilde;");mapa.put("ñ", "&ntilde;");
        mapa.put("Ý", "&Yacute;");mapa.put("ý", "&yacute;");mapa.put("\"", "&quot;");
        mapa.put("®", "&reg;");mapa.put("©", "&copy;");mapa.put("Þ", "&THORN;");mapa.put("þ", "&thorn;");
        mapa.put("ß", "&szlig;");mapa.put(">", "&gt;");mapa.put("<", "&lt;");mapa.put("&", "&amp;");
        return mapa;
    }
    
    public static Map<String, String> criarMapaUnicodeString() {
        Map mapa = new HashMap(70);
        mapa.put("\\u0026", "&");mapa.put("\\u003C", "<");mapa.put("\\u003E", ">");mapa.put("\\u00A9", "©");mapa.put("\\u00AE", "®");
        mapa.put("\\u00C0", "À");mapa.put("\\u00C1", "Á");mapa.put("\\u00C2", "Â");mapa.put("\\u00C3", "Ã");mapa.put("\\u00C4", "Ä");
        mapa.put("\\u00C5", "Å");mapa.put("\\u00C6", "Æ");mapa.put("\\u00C7", "Ç");mapa.put("\\u00C8", "È");mapa.put("\\u00C9", "É");
        mapa.put("\\u00CA", "Ê");mapa.put("\\u00CB", "Ë");mapa.put("\\u00CC", "Ì");mapa.put("\\u00CD", "Í");mapa.put("\\u00CE", "Î");
        mapa.put("\\u00CF", "Ï");mapa.put("\\u00D0", "Ð");mapa.put("\\u00D1", "Ñ");mapa.put("\\u00D2", "Ò");mapa.put("\\u00D3", "Ó");
        mapa.put("\\u00D4", "Ô");mapa.put("\\u00D5", "Õ");mapa.put("\\u00D6", "Ö");mapa.put("\\u00D8", "Ø");mapa.put("\\u00D9", "Ù");
        mapa.put("\\u00DA", "Ú");mapa.put("\\u00DB", "Û");mapa.put("\\u00DC", "Ü");mapa.put("\\u00DD", "Ý");mapa.put("\\u00DE", "Þ");
        mapa.put("\\u00DF", "ß");mapa.put("\\u00E0", "à");mapa.put("\\u00E1", "á");mapa.put("\\u00E2", "â");mapa.put("\\u00E3", "ã");
        mapa.put("\\u00E4", "ä");mapa.put("\\u00E5", "å");mapa.put("\\u00E6", "æ");mapa.put("\\u00E7", "ç");mapa.put("\\u00E8", "è");
        mapa.put("\\u00E9", "é");mapa.put("\\u00EA", "ê");mapa.put("\\u00EB", "ë");mapa.put("\\u00EC", "ì");mapa.put("\\u00ED", "í");
        mapa.put("\\u00EE", "î");mapa.put("\\u00EF", "ï");mapa.put("\\u00F0", "ð");mapa.put("\\u00F1", "ñ");mapa.put("\\u00F2", "ò");
        mapa.put("\\u00F3", "ó");mapa.put("\\u00F4", "ô");mapa.put("\\u00F5", "õ");mapa.put("\\u00F6", "ö");mapa.put("\\u00F8", "ø");
        mapa.put("\\u00F9", "ù");mapa.put("\\u00FA", "ú");mapa.put("\\u00FB", "û");mapa.put("\\u00FC", "ü");mapa.put("\\u00FD", "ý");
        mapa.put("\\u00FE", "þ");mapa.put("\\u00FF", "ÿ");
        return mapa;
    }
    
    public static Map<String, String> criarMapaStringUnicode() {
        Map mapa = new HashMap(70);
        mapa.put("&", "\\u0026");mapa.put("<", "\\u003C");mapa.put(">", "\\u003E");mapa.put("©", "\\u00A9");mapa.put("®", "\\u00AE");
        mapa.put("À", "\\u00C0");mapa.put("Á", "\\u00C1");mapa.put("Â", "\\u00C2");mapa.put("Ã", "\\u00C3");mapa.put("Ä", "\\u00C4");
        mapa.put("Å", "\\u00C5");mapa.put("Æ", "\\u00C6");mapa.put("Ç", "\\u00C7");mapa.put("È", "\\u00C8");mapa.put("É", "\\u00C9");
        mapa.put("Ê", "\\u00CA");mapa.put("Ë", "\\u00CB");mapa.put("Ì", "\\u00CC");mapa.put("Í", "\\u00CD");mapa.put("Î", "\\u00CE");
        mapa.put("Ï", "\\u00CF");mapa.put("Ð", "\\u00D0");mapa.put("Ñ", "\\u00D1");mapa.put("Ò", "\\u00D2");mapa.put("Ó", "\\u00D3");
        mapa.put("Ô", "\\u00D4");mapa.put("Õ", "\\u00D5");mapa.put("Ö", "\\u00D6");mapa.put("Ø", "\\u00D8");mapa.put("Ù", "\\u00D9");
        mapa.put("Ú", "\\u00DA");mapa.put("Û", "\\u00DB");mapa.put("Ü", "\\u00DC");mapa.put("Ý", "\\u00DD");mapa.put("Þ", "\\u00DE");
        mapa.put("ß", "\\u00DF");mapa.put("à", "\\u00E0");mapa.put("á", "\\u00E1");mapa.put("â", "\\u00E2");mapa.put("ã", "\\u00E3");
        mapa.put("ä", "\\u00E4");mapa.put("å", "\\u00E5");mapa.put("æ", "\\u00E6");mapa.put("ç", "\\u00E7");mapa.put("è", "\\u00E8");
        mapa.put("é", "\\u00E9");mapa.put("ê", "\\u00EA");mapa.put("ë", "\\u00EB");mapa.put("ì", "\\u00EC");mapa.put("í", "\\u00ED");
        mapa.put("î", "\\u00EE");mapa.put("ï", "\\u00EF");mapa.put("ð", "\\u00F0");mapa.put("ñ", "\\u00F1");mapa.put("ò", "\\u00F2");
        mapa.put("ó", "\\u00F3");mapa.put("ô", "\\u00F4");mapa.put("õ", "\\u00F5");mapa.put("ö", "\\u00F6");mapa.put("ø", "\\u00F8");
        mapa.put("ù", "\\u00F9");mapa.put("ú", "\\u00FA");mapa.put("û", "\\u00FB");mapa.put("ü", "\\u00FC");mapa.put("ý", "\\u00FD");
        mapa.put("þ", "\\u00FE");mapa.put("ÿ", "\\u00FF");
        return mapa;
    }
    
    
    public static Map<String, String> criarMapaStringHexa() {
        Map mapa = new HashMap(70);
        mapa.put("!", "21");mapa.put("\"", "22");mapa.put("#", "23");mapa.put("$", "24");mapa.put("%", "25");mapa.put("&", "26");mapa.put("'", "27");mapa.put("(", "28");
        mapa.put(")", "29");mapa.put("*", "2A");mapa.put("+", "2B");mapa.put(",", "2C");mapa.put("-", "2D");mapa.put(".", "2E");mapa.put("/", "2F");mapa.put("0", "30");
        mapa.put("1", "31");mapa.put("2", "32");mapa.put("3", "33");mapa.put("4", "34");mapa.put("5", "35");mapa.put("6", "36");mapa.put("7", "37");mapa.put("8", "38");
        mapa.put("9", "39");mapa.put(":", "3A");mapa.put(";", "3B");mapa.put("<", "3C");mapa.put("=", "3D");mapa.put(">", "3E");mapa.put("?", "3F");mapa.put("@", "40");
        mapa.put("A", "41");mapa.put("B", "42");mapa.put("C", "43");mapa.put("D", "44");mapa.put("E", "45");mapa.put("F", "46");mapa.put("G", "47");mapa.put("H", "48");
        mapa.put("I", "49");mapa.put("J", "4A");mapa.put("K", "4B");mapa.put("L", "4C");mapa.put("M", "4D");mapa.put("N", "4E");mapa.put("O", "4F");mapa.put("P", "50");
        mapa.put("Q", "51");mapa.put("R", "52");mapa.put("S", "53");mapa.put("T", "54");mapa.put("U", "55");mapa.put("V", "56");mapa.put("W", "57");mapa.put("X", "58");
        mapa.put("Y", "59");mapa.put("Z", "5A");mapa.put("[", "5B");mapa.put("\\", "5C");mapa.put("]", "5D");mapa.put("^", "5E");mapa.put("_", "5F");mapa.put("`", "60");
        mapa.put("a", "61");mapa.put("b", "62");mapa.put("c", "63");mapa.put("d", "64");mapa.put("e", "65");mapa.put("f", "66");mapa.put("g", "67");mapa.put("h", "68");
        mapa.put("i", "69");mapa.put("j", "6A");mapa.put("k", "6B");mapa.put("l", "6C");mapa.put("m", "6D");mapa.put("n", "6E");mapa.put("o", "6F");mapa.put("p", "70");
        mapa.put("q", "71");mapa.put("r", "72");mapa.put("s", "73");mapa.put("t", "74");mapa.put("u", "75");mapa.put("v", "76");mapa.put("w", "77");mapa.put("x", "78");
        mapa.put("y", "79");mapa.put("z", "7A");mapa.put("{", "7B");mapa.put("|", "7C");mapa.put("}", "7D");mapa.put("~", "7E");mapa.put("¡", "A1");mapa.put("¢", "A2");
        mapa.put("£", "A3");mapa.put("¤", "A4");mapa.put("¥", "A5");mapa.put("¦", "A6");mapa.put("§", "A7");mapa.put("¨", "A8");mapa.put("©", "A9");mapa.put("ª", "AA");
        mapa.put("«", "AB");mapa.put("¬", "AC");mapa.put("­", "AD");mapa.put("®", "AE");mapa.put("¯", "AF");mapa.put("°", "B0");mapa.put("±", "B1");mapa.put("²", "B2");
        mapa.put("³", "B3");mapa.put("´", "B4");mapa.put("µ", "B5");mapa.put("¶", "B6");mapa.put("·", "B7");mapa.put("¸", "B8");mapa.put("¹", "B9");mapa.put("º", "BA");
        mapa.put("»", "BB");mapa.put("¼", "BC");mapa.put("½", "BD");mapa.put("¾", "BE");mapa.put("¿", "BF");mapa.put("À", "C0");mapa.put("Á", "C1");mapa.put("Â", "C2");
        mapa.put("Ã", "C3");mapa.put("Ä", "C4");mapa.put("Å", "C5");mapa.put("Æ", "C6");mapa.put("Ç", "C7");mapa.put("È", "C8");mapa.put("É", "C9");mapa.put("Ê", "CA");
        mapa.put("Ë", "CB");mapa.put("Ì", "CC");mapa.put("Í", "CD");mapa.put("Î", "CE");mapa.put("Ï", "CF");mapa.put("Ð", "D0");mapa.put("Ñ", "D1");mapa.put("Ò", "D2");
        mapa.put("Ó", "D3");mapa.put("Ô", "D4");mapa.put("Õ", "D5");mapa.put("Ö", "D6");mapa.put("×", "D7");mapa.put("Ø", "D8");mapa.put("Ù", "D9");mapa.put("Ú", "DA");
        mapa.put("Û", "DB");mapa.put("Ü", "DC");mapa.put("Ý", "DD");mapa.put("Þ", "DE");mapa.put("ß", "DF");mapa.put("à", "E0");mapa.put("á", "E1");mapa.put("â", "E2");
        mapa.put("ã", "E3");mapa.put("ä", "E4");mapa.put("å", "E5");mapa.put("æ", "E6");mapa.put("ç", "E7");mapa.put("è", "E8");mapa.put("é", "E9");mapa.put("ê", "EA");
        mapa.put("ë", "EB");mapa.put("ì", "EC");mapa.put("í", "ED");mapa.put("î", "EE");mapa.put("ï", "EF");mapa.put("ð", "F0");mapa.put("ñ", "F1");mapa.put("ò", "F2");
        mapa.put("ó", "F3");mapa.put("ô", "F4");mapa.put("õ", "F5");mapa.put("ö", "F6");mapa.put("÷", "F7");mapa.put("ø", "F8");mapa.put("ù", "F9");mapa.put("ú", "FA");
        mapa.put("û", "FB");mapa.put("ü", "FC");mapa.put("ý", "FD");mapa.put("þ", "FE");mapa.put("ÿ", "FF");
        return mapa;
    }
    
    public static Map<String, String> criarMapaHexaString() {
        Map mapa = new HashMap(70);
        mapa.put("21", "!");mapa.put("22", "\"");mapa.put("23", "#");mapa.put("24", "$");mapa.put("25", "%");mapa.put("26", "&");mapa.put("27", "'");mapa.put("28", "(");
        mapa.put("29", ")");mapa.put("2A", "*");mapa.put("2B", "+");mapa.put("2C", ",");mapa.put("2D", "-");mapa.put("2E", ".");mapa.put("2F", "/");mapa.put("30", "0");
        mapa.put("31", "1");mapa.put("32", "2");mapa.put("33", "3");mapa.put("34", "4");mapa.put("35", "5");mapa.put("36", "6");mapa.put("37", "7");mapa.put("38", "8");
        mapa.put("39", "9");mapa.put("3A", ":");mapa.put("3B", ";");mapa.put("3C", "<");mapa.put("3D", "=");mapa.put("3E", ">");mapa.put("3F", "?");mapa.put("40", "@");
        mapa.put("41", "A");mapa.put("42", "B");mapa.put("43", "C");mapa.put("44", "D");mapa.put("45", "E");mapa.put("46", "F");mapa.put("47", "G");mapa.put("48", "H");
        mapa.put("49", "I");mapa.put("4A", "J");mapa.put("4B", "K");mapa.put("4C", "L");mapa.put("4D", "M");mapa.put("4E", "N");mapa.put("4F", "O");mapa.put("50", "P");
        mapa.put("51", "Q");mapa.put("52", "R");mapa.put("53", "S");mapa.put("54", "T");mapa.put("55", "U");mapa.put("56", "V");mapa.put("57", "W");mapa.put("58", "X");
        mapa.put("59", "Y");mapa.put("5A", "Z");mapa.put("5B", "[");mapa.put("5C", "\\");mapa.put("5D", "]");mapa.put("5E", "^");mapa.put("5F", "_");mapa.put("60", "`");
        mapa.put("61", "a");mapa.put("62", "b");mapa.put("63", "c");mapa.put("64", "d");mapa.put("65", "e");mapa.put("66", "f");mapa.put("67", "g");mapa.put("68", "h");
        mapa.put("69", "i");mapa.put("6A", "j");mapa.put("6B", "k");mapa.put("6C", "l");mapa.put("6D", "m");mapa.put("6E", "n");mapa.put("6F", "o");mapa.put("70", "p");
        mapa.put("71", "q");mapa.put("72", "r");mapa.put("73", "s");mapa.put("74", "t");mapa.put("75", "u");mapa.put("76", "v");mapa.put("77", "w");mapa.put("78", "x");
        mapa.put("79", "y");mapa.put("7A", "z");mapa.put("7B", "{");mapa.put("7C", "|");mapa.put("7D", "}");mapa.put("7E", "~");mapa.put("A1", "¡");mapa.put("A2", "¢");
        mapa.put("A3", "£");mapa.put("A4", "¤");mapa.put("A5", "¥");mapa.put("A6", "¦");mapa.put("A7", "§");mapa.put("A8", "¨");mapa.put("A9", "©");mapa.put("AA", "ª");
        mapa.put("AB", "«");mapa.put("AC", "¬");mapa.put("AD", "­");mapa.put("AE", "®");mapa.put("AF", "¯");mapa.put("B0", "°");mapa.put("B1", "±");mapa.put("B2", "²");
        mapa.put("B3", "³");mapa.put("B4", "´");mapa.put("B5", "µ");mapa.put("B6", "¶");mapa.put("B7", "·");mapa.put("B8", "¸");mapa.put("B9", "¹");mapa.put("BA", "º");
        mapa.put("BB", "»");mapa.put("BC", "¼");mapa.put("BD", "½");mapa.put("BE", "¾");mapa.put("BF", "¿");mapa.put("C0", "À");mapa.put("C1", "Á");mapa.put("C2", "Â");
        mapa.put("C3", "Ã");mapa.put("C4", "Ä");mapa.put("C5", "Å");mapa.put("C6", "Æ");mapa.put("C7", "Ç");mapa.put("C8", "È");mapa.put("C9", "É");mapa.put("CA", "Ê");
        mapa.put("CB", "Ë");mapa.put("CC", "Ì");mapa.put("CD", "Í");mapa.put("CE", "Î");mapa.put("CF", "Ï");mapa.put("D0", "Ð");mapa.put("D1", "Ñ");mapa.put("D2", "Ò");
        mapa.put("D3", "Ó");mapa.put("D4", "Ô");mapa.put("D5", "Õ");mapa.put("D6", "Ö");mapa.put("D7", "×");mapa.put("D8", "Ø");mapa.put("D9", "Ù");mapa.put("DA", "Ú");
        mapa.put("DB", "Û");mapa.put("DC", "Ü");mapa.put("DD", "Ý");mapa.put("DE", "Þ");mapa.put("DF", "ß");mapa.put("E0", "à");mapa.put("E1", "á");mapa.put("E2", "â");
        mapa.put("E3", "ã");mapa.put("E4", "ä");mapa.put("E5", "å");mapa.put("E6", "æ");mapa.put("E7", "ç");mapa.put("E8", "è");mapa.put("E9", "é");mapa.put("EA", "ê");
        mapa.put("EB", "ë");mapa.put("EC", "ì");mapa.put("ED", "í");mapa.put("EE", "î");mapa.put("EF", "ï");mapa.put("F0", "ð");mapa.put("F1", "ñ");mapa.put("F2", "ò");
        mapa.put("F3", "ó");mapa.put("F4", "ô");mapa.put("F5", "õ");mapa.put("F6", "ö");mapa.put("F7", "÷");mapa.put("F8", "ø");mapa.put("F9", "ù");mapa.put("FA", "ú");
        mapa.put("FB", "û");mapa.put("FC", "ü");mapa.put("FD", "ý");mapa.put("FE", "þ");mapa.put("FF", "ÿ");
        return mapa;
    }
    
}
