import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DocumentoXLSX implements Documento {
    @Override
    public void exportar(String datos, String ruta) {
        System.out.println("SISTEMA XLSX: Generando estructura OOXML...");
        
        // Un archivo .xlsx es básicamente un archivo ZIP con XMLs dentro.
        // Para este ejemplo simplificado, crearemos un ZIP válido con una estructura mínima
        // que Excel pueda intentar abrir (aunque Excel es muy estricto, esto demuestra el concepto).
        // En un entorno real, se usaría una librería como Apache POI.
        
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(ruta))) {
            // [Content_Types].xml
            zos.putNextEntry(new ZipEntry("[Content_Types].xml"));
            String contentTypes = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                    "<Types xmlns=\"http://schemas.openxmlformats.org/package/2006/content-types\">" +
                    "<Default Extension=\"xml\" ContentType=\"application/xml\"/>" +
                    "<Default Extension=\"rels\" ContentType=\"application/vnd.openxmlformats-package.relationships+xml\"/>" +
                    "<Override PartName=\"/xl/workbook.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet.main+xml\"/>" +
                    "<Override PartName=\"/xl/worksheets/sheet1.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.spreadsheetml.worksheet+xml\"/>" +
                    "</Types>";
            zos.write(contentTypes.getBytes());
            zos.closeEntry();

            // _rels/.rels
            zos.putNextEntry(new ZipEntry("_rels/.rels"));
            String rels = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                    "<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">" +
                    "<Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument\" Target=\"xl/workbook.xml\"/>" +
                    "</Relationships>";
            zos.write(rels.getBytes());
            zos.closeEntry();

            // xl/workbook.xml
            zos.putNextEntry(new ZipEntry("xl/workbook.xml"));
            String workbook = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                    "<workbook xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\">" +
                    "<sheets><sheet name=\"Sheet1\" sheetId=\"1\" r:id=\"rId1\"/></sheets>" +
                    "</workbook>";
            zos.write(workbook.getBytes());
            zos.closeEntry();

            // xl/_rels/workbook.xml.rels
            zos.putNextEntry(new ZipEntry("xl/_rels/workbook.xml.rels"));
            String workbookRels = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                    "<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">" +
                    "<Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/worksheet\" Target=\"worksheets/sheet1.xml\"/>" +
                    "</Relationships>";
            zos.write(workbookRels.getBytes());
            zos.closeEntry();

            // xl/worksheets/sheet1.xml (Aquí van los datos)
            zos.putNextEntry(new ZipEntry("xl/worksheets/sheet1.xml"));
            String sheet = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                    "<worksheet xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\">" +
                    "<sheetData><row><c t=\"inlineStr\"><is><t>" + datos + "</t></is></c></row></sheetData>" +
                    "</worksheet>";
            zos.write(sheet.getBytes());
            zos.closeEntry();

            System.out.println("Archivo generado: [" + ruta + "]");

        } catch (IOException e) {
            System.err.println("Error al escribir el archivo XLSX: " + e.getMessage());
        }
    }
}