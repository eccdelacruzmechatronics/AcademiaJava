public class ClasificadorSpam {
    
    public static String analizarCorreo(String email) {
        int puntuacionSpam = 0;

        if (FiltroSpam.contienePalabrasClave.test(email)) puntuacionSpam += 2;
        if (FiltroSpam.dominioSospechoso.test(email)) puntuacionSpam += 3;
        if (FiltroSpam.contieneUrlSospechosa.test(email)) puntuacionSpam += 2;
        if (FiltroSpam.esCorreoMuyCorto.test(email)) puntuacionSpam += 1;
        if (FiltroSpam.contieneMuchosEmojis.test(email)) puntuacionSpam += 2;

        // Clasificación basada en la puntuación
        if (puntuacionSpam >= 5) {
            return "❌ SPAM - Alto riesgo (" + puntuacionSpam + " puntos)";
        } else if (puntuacionSpam >= 2) {
            return "⚠️ Sospechoso - Revisar (" + puntuacionSpam + " puntos)";
        } else {
            return "✅ Seguro (" + puntuacionSpam + " puntos)";
        }
    }
}
