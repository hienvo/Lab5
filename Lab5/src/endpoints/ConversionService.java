package endpoints;

import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "endpoints.ConversionServiceInterface")
public class ConversionService implements ConversionServiceInterface{

	
	@WebMethod
	public double inchToFeet(double inch) {
		inch = inch / 12.0;
		return inch;
	}
	
	@WebMethod
	public double feetToInch(double feet) {
		feet = feet * 12.0;
		return feet;
	}
	
	@WebMethod
	public double inchToCm(double inch) {
		inch = inch * 2.54;
		return inch;
	}
	
	@WebMethod
	public double cmToInch(double cm) {
		cm = cm / 2.54;
		return cm;
	}
	
	@WebMethod
	public double ftToM(double ft) {
		ft = ft / 3.28084;
		return ft;
	}
	
	@WebMethod
	public double mToFt(double m) {
		m = m * 3.28084;
		return m;
	}
	
	@WebMethod
	public double ftToMi(double m) {
		m = m / 5280;
		return m;
	}
	
	@WebMethod
	public double miToFt(double m) {
		m = m * 5280;
		return m;
	}
	
	@WebMethod
	public double miToKm(double m) {
		m = m * 1.60934;
		return m;
	}
	
	@WebMethod
	public double kmToMi(double m) {
		m = m / 1.60934;
		return m;
	}
	
	@WebMethod
	public double dayToMonth(double m) {
		m = m / 30.4167;
		return m;
	}
	
	@WebMethod
	public double monthToDay(double m) {
		m = m * 30.4167;
		return m;
	}
	
	@WebMethod
	public double weekToYear(double m) {
		m = m * 0.0191781;
		return m;
	}
	
	@WebMethod
	public double yearToWeek(double m) {
		m = m / 0.0191781;
		return m;
	}

}
