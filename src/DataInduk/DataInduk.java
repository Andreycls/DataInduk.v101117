/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataInduk;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 *
 * @author asemJr
 */
public class DataInduk {
class MyFooter extends PdfPageEventHelper {
        Font ffont = new Font(Font.FontFamily.UNDEFINED, 5, Font.BOLD);
        Font fJudul = new Font(Font.FontFamily.HELVETICA,20, Font.BOLD);
        Font fAlamat = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte cb = writer.getDirectContent();
            Phrase header = new Phrase("Sample InfoDes Header", ffont);
            Phrase footer = new Phrase("Sample InfoDes Footer", ffont);
            Paragraph Judul = new Paragraph("Pemerintah Kabupaten Tobasa ",fJudul);
            Paragraph subJudul = new Paragraph("Kecamatan Laguboti",fJudul);
            Paragraph Alamat = new Paragraph("Jalan.SM RAJA NO.546 , Laguboti",fAlamat);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    header,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.top() + 10, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    footer,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.bottom() - 10, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    Judul,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.top() - 30, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    subJudul,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.top() - 50, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    Alamat,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.top() - 65, 0);
            
            
            
        }
    }
 
    public static final String DEST = "D:/Kerjaan/Project/Sistem Informasi InfoDes App (Desktop Application)/Hasil/DataInduk.pdf";
 
    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new DataInduk().createPdf(DEST);
    }
 
    public void createPdf(String filename) throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        String imagePath = "C:/Users/asemJr/Desktop/logo.png" ; 
        Image image = Image.getInstance(imagePath);
        image.setAbsolutePosition(10, 730);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        MyFooter event = new MyFooter();
        writer.setPageEvent(event);
        
// step 3
        document.open();
        // step 4
         PdfPTable table = new PdfPTable(14);
         
         PdfContentByte canvas = writer.getDirectContent();
         CMYKColor magentaColor = new CMYKColor(0.f, 1.f, 0.f, 0.f);
         canvas.setColorStroke(magentaColor);
        
        canvas.closePathStroke();
        table.addCell("No KK");
        table.addCell("NIK");
        table.addCell("Nama");
        table.addCell("Tempat Lahir");
        table.addCell("Tanggal Lahir");
        table.addCell("L/P");
        table.addCell("RW");
        table.addCell("RT");
        table.addCell("Agama");
        table.addCell("Status Nikah");
        table.addCell("Status Keluarga");
        table.addCell("Pendidikan");
        table.addCell("Pekerjaan");
        table.addCell("Warga");
        
        
        table.setHeaderRows(1);
        for(int aw = 0; aw < 10; aw++){
            
            table.addCell("1");
            table.addCell("2");
            table.addCell("3");
            table.addCell("4");
            table.addCell("5");
            table.addCell("5");
            table.addCell("8");
            table.addCell("2");
            table.addCell("5");
            table.addCell("6");
            
        }        // step 5
        table.setWidthPercentage(110);
//      
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
       for(int x = 0; x<9;){
           x++;
           document.add(new Paragraph("  " ));
       }
       document.add(image); 
       document.add(new Paragraph("  " ));
        
        document.add(table);
        
        for (int i = 0; i < 3; ) {
            i++;
            document.add(new Paragraph("  " ));
            document.newPage();
        }
       
        document.close();
    }

}