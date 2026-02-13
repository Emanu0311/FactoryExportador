public class GeneradorPDF extends GeneradorReportes {
    @Override
    public Documento crearDocumento() {
        return new DocumentoPDF();
    }
}