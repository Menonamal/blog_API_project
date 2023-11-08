package com.flight_reservation_app.utilities;
import java.io.FileOutputStream; 
import java.util.Date;

import org.springframework.stereotype.Component;

import com.flight_reservation_app.entity.Reservation;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PDFgenerator {
	 
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    
    
    public  void generateItinerary(String filePath, Reservation reservation) {
        
            Document document = new Document();
            try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
           document.add(generateTable(reservation));
           
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
//    private static void addMetaData(Document document) {
//        document.addTitle("My first PDF");
//        document.addSubject("Using iText");
//        document.addKeywords("Java, PDF, iText");
//        document.addAuthor("Lars Vogel");
//        document.addCreator("Lars Vogel");
//    }

    private PdfPTable generateTable(Reservation reservation) {
            
       
        
        PdfPTable table = new PdfPTable(2);
        PdfPCell cell;
        table.setWidthPercentage(100);
        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);

        cell = new PdfPCell(new Phrase("Flight Itinerary"));
        cell.setColspan(2);
        table.addCell(cell);


//        cell = new PdfPCell(new Phrase("Flight Details"));
//        cell.setColspan(2);
//        table.addCell(cell);
        
        
        table.addCell("Departure City");
        table.addCell(reservation.getFlight().getDepartureCity());
        
        table.addCell("Arrival City");
        table.addCell(reservation.getFlight().getArrivalCity());
        
        table.addCell("Flight Number");
        table.addCell(reservation.getFlight().getFlightNumber());
       
        table.addCell("Operating Airline");
        table.addCell(reservation.getFlight().getOperatingAirlines());
      
       table.addCell("Departure Date");
       table.addCell(reservation.getFlight().getDateOfDeparture().toString());
       
       table.addCell("Departure time");
       table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
        
       cell = new PdfPCell( new Phrase ("Passenger Details"));
       cell.setColspan(2);
       table.addCell(cell);
       
       
        table.addCell("First Name");
        table.addCell(reservation.getPassenger().getFirstName());
        
        
        
//        PdfPTable table1 = new PdfPTable(2);
//        table1.setWidthPercentage(100);
        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);

//        PdfPCell c2 = new PdfPCell(new Phrase("Flight Detail"));
//        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
//        c2.setColspan(2);
//        table1.addCell(c2);
		return table;

//        table1.addCell("Operating Airlines");
//        table1.addCell(operatingAirlines);
//        table1.addCell("Departure Date");
//        table1.addCell(departureDate);
//        table1.addCell("Departure City");
//        table1.addCell(departureCity);
//        
//        table1.addCell("Arrival City");
//        table1.addCell(arrivalCity);
//        
//        document.add(table1);
       
//        document.close();
    }

  
}
