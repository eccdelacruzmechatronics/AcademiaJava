import java.util.function.Predicate;

public class FiltroSpam {
    
    private static final String[] PALABRAS_CLAVE = {"gratis", "oferta", "ganaste", "dinero fácil", "trabajo desde casa", "descuento", "premio"};
    private static final String[] DOMINIOS_SOSPECHOSOS = {"@spam.com", "@ofertas.xyz", "@gooogle.com", "@amazoon.com"};
    private static final String[] URLS_SOSPECHOSAS = {"bit.ly", "tinyurl.com", "short.ly", "click-me.com"};

    public static final Predicate<String> contienePalabrasClave = email -> {
        for (String palabra : PALABRAS_CLAVE) {
            if (email.toLowerCase().contains(palabra)) {
                return true;
            }
        }
        return false;
    };

    public static final Predicate<String> dominioSospechoso = email -> {
        for (String dominio : DOMINIOS_SOSPECHOSOS) {
            if (email.toLowerCase().endsWith(dominio)) {
                return true;
            }
        }
        return false;
    };

    public static final Predicate<String> contieneUrlSospechosa = email -> {
        for (String url : URLS_SOSPECHOSAS) {
            if (email.toLowerCase().contains(url)) {
                return true;
            }
        }
        return false;
    };

    public static final Predicate<String> esCorreoMuyCorto = email -> email.length() < 20;

    public static final Predicate<String> contieneMuchosEmojis = email -> {
        long count = email.chars().filter(ch -> Character.toString(ch).matches("[😀-🙏]")).count();
        return count > 3;  // Si hay más de 3 emojis, es sospechoso
    };

    // Combina todos los predicados
    public static final Predicate<String> esSpam = contienePalabrasClave
            .or(dominioSospechoso)
            .or(contieneUrlSospechosa)
            .or(esCorreoMuyCorto)
            .or(contieneMuchosEmojis);
}
