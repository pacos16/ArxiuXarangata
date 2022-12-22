package es.xarangata;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.multipdf.Splitter; 
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.bytedeco.javacpp.*;
import static org.bytedeco.javacpp.lept.*;
import static org.bytedeco.javacpp.tesseract.*;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;  

public class PdfUtils {
    
   

    public static void pdfSplitter(File file) throws IOException{

      PDDocument doc = PDDocument.load(file); 

      //Instantiating Splitter class 
      Splitter splitter = new Splitter(); 
      
      //splitting the pages of a PDF document 
      List<PDDocument> Pages = splitter.split(doc); 

      //Creating an iterator 
      Iterator<PDDocument> iterator = Pages.listIterator();         

      //Saving each page as an individual document 
      int i = 1; 
      
      while(iterator.hasNext()){ 
         PDDocument pd = iterator.next(); 
         pd.save(file.getParent()+"\\"+ i++ +".pdf");             
      } 
      doc.close();
    }


    public static void pdfSplitterPorInstrumentos(File file) throws IOException{
      try {
        //Create PdfReader instance.
        PdfReader pdfReader = new PdfReader(file.getAbsolutePath());	
      
        //Get the number of pages in pdf.
        int pages = pdfReader.getNumberOfPages(); 
      
        //Iterate the pdf through pages.
        for(int i=1; i<=pages; i++) { 
          System.out.println("Content on Page "+ i );
          //Extract the page content using PdfTextExtractor.
          String pageContent = 
            PdfTextExtractor.getTextFromPage(pdfReader, i);
            pageContent=cleanTextContent(pageContent);
            //split in jumps
            String[] lines = pageContent.split("\n");
            for(int j=0;j<lines.length;j++){
              if(j<5){
                System.out.println(j+" "+lines[j]);
              }
            }
            //Print the page content on console.
            }
      
            //Close the PdfReader.
            pdfReader.close();
          } catch (Exception e) {
            e.printStackTrace();
          }

    }


    private static String cleanTextContent(String text) {
    // strips off all non-ASCII characters
    //text = text.replaceAll("[^\\x00-\\x7F]", "");
  
    // erases all the ASCII control characters
    //text = text.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");
    
    // removes non-printable characters from Unicode
    //text = text.replaceAll("\\p{C}", "");
  
    return text.trim();
  }


  public static void ReadImageText(File file) throws IOException {
        BytePointer outText;

        TessBaseAPI api = new TessBaseAPI();

      
          PDDocument document = PDDocument.load(file);
          PDFRenderer pdfRenderer = new PDFRenderer(document);
        
          ArrayList<BufferedImage> images= new ArrayList<>();
          for (int page = 0; page < document.getNumberOfPages(); ++page)
          { 
              BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 400, ImageType.RGB);
              images.add(bim);
          }
            document.close();
    

        // Open input image with leptonica library
        for (BufferedImage image : images) {
       
        if (api.Init("./tessdata", "eng") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }
          System.out.println("Imagen");
           ImageIO.write (image, "TIFF", new File ("D:\\xaranga\\ARXIU\\Xaranga\\Mecano\\MecanoTest.TIFF"));
           PIX imagen = pixRead("D:\\xaranga\\ARXIU\\Xaranga\\Mecano\\MecanoTest.TIFF");
            api.SetImage(imagen);
            // Get OCR result
            outText = api.GetUTF8Text();
            System.out.println("OCR output:\n" + outText.getString());

            // Destroy used object and release memory
            api.End();
            outText.deallocate();
            pixDestroy(imagen);
        }
        
    }

}
