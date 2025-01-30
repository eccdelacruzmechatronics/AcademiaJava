class Inyector {
    public static ProcesadorPagos proporcionarProcesadorPagos(String tipo) {
        return new ProcesadorPagos(tipo); // Se crea el objeto sin modificar su estado después
    }
}