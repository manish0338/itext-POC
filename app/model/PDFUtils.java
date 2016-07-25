package model;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import com.itextpdf.text.Document;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class PDFUtils {

	public static File createPDF(String html, File f) throws Exception {
		try {
			// File f = new File("temp.pdf");
			Document doc = new Document();
			FileOutputStream out = new FileOutputStream(f);

			PdfWriter writer = PdfWriter.getInstance(doc, out);

			doc.open();
			// HTMLWorker h = new HTMLWorker(doc);
			// h.parse(new StringReader(html));
			XMLWorkerHelper.getInstance().parseXHtml(writer, doc,
					new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8)));
			System.out.println(f.exists());
			doc.close();
			return f;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static File fillForm() {
		try {
			PdfReader reader = new PdfReader("CertificateOfExcellence.pdf");
			File f = new File("certificate.pdf");
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(f));
			AcroFields form = stamper.getAcroFields();
			form.setField("course", "Information Technology");
			form.setField("name", "Manish Gangal");
			form.setField("date", "July 25 2016");
			form.setField("description",
					"In this infographic, learn how to complete fillable PDF forms or fill in PDF forms using the free Reader. Whether your PDF form has fillable fields or not, you'll still be able to print and save all your information."
							+ "This feature does not work with forms that are developed using Adobe LiveCycle Designer.");
			stamper.setFormFlattening(true);
			stamper.close();
			return f;
		} catch (Exception e) {
			return null;
		}
	}
}
