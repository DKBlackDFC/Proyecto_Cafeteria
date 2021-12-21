/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Base_De_Datos.Construcciones.Almacen;
import Base_De_Datos.Implementaciones.DAOAlmacenImpI;
import Base_De_Datos.interfaces.DAOAlmacen;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DIEGO
 */
public class Reportes {
    public void Reporte_Inventario(String categoria) throws Exception{
        List<Almacen> datos = new ArrayList();
        DAOAlmacen metodosAlmacen = new DAOAlmacenImpI();
        
        if(categoria.equals("-Imprimir todo-")){
            datos = metodosAlmacen.Listar("");
        }else{
            datos = metodosAlmacen.Listar(categoria);
        }
        
        Document documento = new Document();
            
        String ruta = System.getProperty("user.home");
        PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Inventario.pdf"));
        documento.open();
        
        Image img = Image.getInstance("C:/Users/DIEGO/Documents/NetBeansProjects/Proyecto_Cafeteria/Proyecto_Cafeteria/src/IMG/Login/Logo_ReportesV2.jpg");
        img.setAlignment(Element.ALIGN_LEFT);
        img.scaleToFit(150, 100);
        documento.add(img);
        
        PdfContentByte pc = writer.getDirectContent();
        BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        pc.setFontAndSize(bf, 30);
        pc.beginText();
            pc.setTextMatrix(200, 765);
            pc.showText("PUNTO DE VENTA.");
        pc.endText();

        Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.WHITE);
        Font texto = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
        Font TySep = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);

        Paragraph separador = new Paragraph(10);
        separador.setFont(TySep);
        separador.add(Chunk.NEWLINE);
        separador.add("__________________________________________________________________________");
        separador.add(Chunk.NEWLINE);
        separador.setAlignment(Element.ALIGN_CENTER);
        documento.add(separador);

        Paragraph p = new Paragraph(10);
        p.add(Chunk.NEWLINE);
        p.setFont(texto);
        p.add("Reporte de Inventario:");
        p.add(Chunk.NEWLINE);
        p.setIndentationLeft(40);
        p.setAlignment(Element.ALIGN_LEFT);
        documento.add(p);
        
        Paragraph separador2 = new Paragraph(10);
        separador2.setFont(TySep);
        separador2.add(Chunk.NEWLINE);
        separador2.add("__________________________________________________________________________");
        separador2.add(Chunk.NEWLINE);
        separador2.add(Chunk.NEWLINE);
        separador2.setAlignment(Element.ALIGN_CENTER);
        documento.add(separador2);
        
        PdfPTable tabla = new PdfPTable(9);
        tabla.setWidthPercentage(100);
        PdfPCell c1 = new PdfPCell(new Phrase("ID", negrita));
        PdfPCell c2 = new PdfPCell(new Phrase("CATEGORÍA", negrita));
        PdfPCell c3 = new PdfPCell(new Phrase("DESCRIPCIÓN", negrita));
        PdfPCell c4 = new PdfPCell(new Phrase("PRE. COMPRA", negrita));
        PdfPCell c5 = new PdfPCell(new Phrase("PRE. VENTA", negrita));
        PdfPCell c6 = new PdfPCell(new Phrase("EXISTENCIA", negrita));
        PdfPCell c7 = new PdfPCell(new Phrase("UNIDAD", negrita));
        PdfPCell c8 = new PdfPCell(new Phrase("FEC. DE CAD.", negrita));
        PdfPCell c9 = new PdfPCell(new Phrase("PROVEEDOR", negrita));

        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);

        c1.setBackgroundColor(BaseColor.DARK_GRAY);
        c2.setBackgroundColor(BaseColor.DARK_GRAY);
        c3.setBackgroundColor(BaseColor.DARK_GRAY);
        c4.setBackgroundColor(BaseColor.DARK_GRAY);
        c5.setBackgroundColor(BaseColor.DARK_GRAY);
        c6.setBackgroundColor(BaseColor.DARK_GRAY);
        c7.setBackgroundColor(BaseColor.DARK_GRAY);
        c8.setBackgroundColor(BaseColor.DARK_GRAY);
        c9.setBackgroundColor(BaseColor.DARK_GRAY);
        
        tabla.addCell(c1);
        tabla.addCell(c2);
        tabla.addCell(c3);
        tabla.addCell(c4);
        tabla.addCell(c5);
        tabla.addCell(c6);
        tabla.addCell(c7);
        tabla.addCell(c8);
        tabla.addCell(c9);

        for(int i = 0;i < datos.size();i++){
            tabla.addCell(String.valueOf(datos.get(i).getId()));
            tabla.addCell(datos.get(i).getCategoria());
            tabla.addCell(datos.get(i).getDescripcion());
            tabla.addCell(String.format("%.2f",datos.get(i).getPrecioCompra()));
            tabla.addCell(String.format("%.2f",datos.get(i).getPrecioVenta()));

             if(datos.get(i).getUnidad_venta().equals("Kg")
                || datos.get(i).getUnidad_venta().equals("Litros")
                || datos.get(i).getUnidad_venta().equals("Mililitros")){

                tabla.addCell(String.format("%.2f",datos.get(i).getExistencias()));

            }else{
                tabla.addCell(String.format("%.0f",datos.get(i).getExistencias()));
            }

            tabla.addCell(datos.get(i).getUnidad_venta());
            tabla.addCell(datos.get(i).getFechaCaducidad());
            tabla.addCell(datos.get(i).getProveedor());
        }

        documento.add(tabla);
        
        documento.close();
    }
}
