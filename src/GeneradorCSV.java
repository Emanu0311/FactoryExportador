public class GeneradorCSV extends GeneradorReportes {
    @Override
    public Documento crearDocumento() {
        return new DocumentoCSV();
    }
}