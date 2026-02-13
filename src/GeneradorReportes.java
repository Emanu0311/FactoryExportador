public abstract class GeneradorReportes {

    // Este es el Factory Method
    public abstract Documento crearDocumento();

    // Lógica de negocio común a todos los reportes
    public void iniciarProcesoExportacion(String datos) {
        System.out.println("--- Iniciando Generación de Reporte ---");

        // Llamamos al factory method para obtener el objeto
        Documento doc = crearDocumento();

        // Usamos el objeto (polimorfismo)
        doc.exportar(datos);

        System.out.println("--- Reporte finalizado con éxito ---\n");
    }
}
