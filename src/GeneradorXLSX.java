public class GeneradorXLSX extends GeneradorReportes {
    @Override
    public Documento crearDocumento() {
        return new DocumentoXLSX();
    }
}