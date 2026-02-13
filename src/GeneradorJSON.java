public class GeneradorJSON extends GeneradorReportes {
    @Override
    public Documento crearDocumento() {
        return new DocumentoJSON();
    }
}