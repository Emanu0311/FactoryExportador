public class GeneradorExcel extends GeneradorReportes {
    @Override
    public Documento crearDocumento() {
        return new DocumentoExcel();
    }
}