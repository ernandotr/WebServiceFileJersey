package br.com.ernandorezende.app;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/service")
public class Service {
	
	private File file;
	
	private ResponseBuilder responseBuilder;
	
	private String caminhoPasta;
	
	public Service() {
		try {
			caminhoPasta = new File(".").getCanonicalPath();
			
			caminhoPasta = caminhoPasta.concat("/").concat("arquivos");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/gettxt")
	@Produces("text/plain")
	public Response getTxt() {
		file = new File(caminhoPasta + "/ernando.txt");
		
		responseBuilder = Response.ok(file);
		
		responseBuilder.header("Content-Disposition", "attachment;filename=" + file.getName());
		
		return responseBuilder.build();
	}
	
	/**
	 * 
	 * 	 * DOWNLOAD DE IMAGEM
	 * */
	@GET
	@Path("/getimagem")
	@Produces("image/png")
	public Response getImagem(){
 
		file = new File(caminhoPasta + "/imagem.png");
 
		responseBuilder = Response.ok(file);
 
		responseBuilder.header("Content-Disposition", "attachment;filename=" + file.getName());
 
		return responseBuilder.build();
 
	}
 
	/**
	 * 
	 * 	 * DOWNLOAD DE ARQUIVO PDF
	 * */
	@GET
	@Path("/getpdf")
	@Produces("application/pdf")
	public Response getPdf(){
 
		file = new File(caminhoPasta + "/Java.pdf");
 
		responseBuilder = Response.ok(file);
 
		responseBuilder.header("Content-Disposition", "attachment;filename=" + file.getName());
 
		return responseBuilder.build();
 
	}
 
	/**
	 * 
	 * DOWNLOAD DE ARQUIVO EXCEL
	 * */	
	@GET
	@Path("/getexcel")
	@Produces("application/vnd.ms-excel")
	public Response getExcel(){
 
		file = new File(caminhoPasta + "/planilha.xlsx");
 
		responseBuilder = Response.ok(file);
 
		responseBuilder.header("Content-Disposition", "attachment;filename=" + file.getName());
 
		return responseBuilder.build();
 
	}
 
	/**
	 * 
	 * DOWNLOAD DE ARQUIVO ZIP
	 * */
	@GET
	@Path("/getzip")
	@Produces("application/zip")
	public Response getZip(){
 
		file = new File(caminhoPasta + "/tudo.zip");
 
		responseBuilder = Response.ok(file);
 
		responseBuilder.header("Content-Disposition", "attachment;filename=" + file.getName());
 
		return responseBuilder.build();
 
	}

}
