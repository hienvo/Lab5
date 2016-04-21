package endpoints;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ConversionServiceInterface {
//	
	@WebMethod
	public double inchToFeet(double inch);
	
	@WebMethod
	public double feetToInch(double feet);
	
	@WebMethod
	public double inchToCm(double inch);
	
	@WebMethod
	public double cmToInch(double cm);
	
	@WebMethod
	public double ftToM(double ft);
	
	@WebMethod
	public double mToFt(double m);
	
	@WebMethod
	public double ftToMi(double m);
	
	@WebMethod
	public double miToFt(double m);
	
	@WebMethod
	public double miToKm(double m);
	
	@WebMethod
	public double kmToMi(double m);
	
	@WebMethod
	public double dayToMonth(double m);
	
	@WebMethod
	public double monthToDay(double m);
	
	@WebMethod
	public double weekToYear(double m);
	
	@WebMethod
	public double yearToWeek(double m);
	
}
