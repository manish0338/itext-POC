package controllers;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;

import model.PDFUtils;
import play.mvc.*;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class HomeController extends Controller {

	/**
	 * An action that renders an HTML page with a welcome message. The
	 * configuration in the <code>routes</code> file means that this method will
	 * be called when the application receives a <code>GET</code> request with a
	 * path of <code>/</code>.
	 */
	public Result index() {
		return ok(views.html.index.render("manish"));
	}

	public Result createPDF() throws Exception {
		JsonNode json = request().body().asJson();
		String html = json.get("html").asText();
		File f = new File("temp.pdf");
		System.out.println("created");
		return ok(PDFUtils.createPDF(html, f));
	}

	public Result fillForm() {
		return ok(PDFUtils.fillForm());
	}

}
