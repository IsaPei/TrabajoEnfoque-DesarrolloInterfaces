package utils;

import data.AlquilerViviendaData;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class GeneradorReport {

    public void generateReport(AlquilerViviendaData alqReport) {
        try {
            String nombreReport = "Alquiler.jrxml";
            String nombrePdfExport = "alquiler_" + alqReport.getCodReferencia() + ".pdf";
            //Se guarda en una variable la ruta del proyecto.
            String rutaProyecto = System.getProperty("user.dir");
            //Se construye la ruta del .jrxml.
            Path ruta = Paths.get(rutaProyecto, "src", "main", "java", "reports", nombreReport);

            //Cargamos el fichero de Jasper
            JasperDesign jasperDesign = JRXmlLoader.load(ruta.toFile());
            //Compilar el fichero
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            //Se crea una lista que almacenará los elementos que se verán en el informe.
            ArrayList<AlquilerViviendaData> listaAlq = new ArrayList<>();
            //Mete el alquiler en la lista.
            listaAlq.add(alqReport);
            //Pone los datos en el Jasper
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(listaAlq));

            //Se construye la ruta del pdf.
            Path rutaPdf = Paths.get(rutaProyecto, "src", "main", "java", "reports", nombrePdfExport);
            JasperExportManager.exportReportToPdfFile(jasperPrint, rutaPdf.toString());

            Runtime.getRuntime().exec("cmd /c start " + rutaPdf.toString());
        } catch (JRException | IOException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }
}
