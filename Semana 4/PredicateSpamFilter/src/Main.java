public class Main {
    public static void main(String[] args) {
        String[] correos = {
            "🔥🔥 Oferta especial, gana dinero fácil!",  // SPAM (Palabras clave + emojis)
            "Hola, ¿cómo estás?",  // Seguro
            "Reunión a las 3PM en la oficina",  // Seguro
            "Te has ganado un premio!!!",  // Sospechoso
            "info@spam.com",  // SPAM (Dominio sospechoso)
            "Trabajo desde casa @amazoon.com", // SPAM (Dominio + palabra clave)
            "Visita nuestro sitio: bit.ly/descuento", // SPAM (URL sospechosa)
            "😀😀😀🔥🔥🔥 Descuento EXCLUSIVO - oferta por tiempo limitado"  // Sospechoso (demasiados emojis)
        };

        for (String correo : correos) {
            System.out.println("📩 Correo: " + correo);
            System.out.println("➡ Resultado: " + ClasificadorSpam.analizarCorreo(correo));
            System.out.println("-----------------------------------");
        }
    }
}
