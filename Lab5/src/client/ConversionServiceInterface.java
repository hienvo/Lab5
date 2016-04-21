
package client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ConversionServiceInterface", targetNamespace = "http://endpoints/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ConversionServiceInterface {


    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://endpoints/ConversionServiceInterface/inchToFeetRequest", output = "http://endpoints/ConversionServiceInterface/inchToFeetResponse")
    public double inchToFeet(
        @WebParam(name = "arg0", partName = "arg0")
        double arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://endpoints/ConversionServiceInterface/feetToInchRequest", output = "http://endpoints/ConversionServiceInterface/feetToInchResponse")
    public double feetToInch(
        @WebParam(name = "arg0", partName = "arg0")
        double arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://endpoints/ConversionServiceInterface/miToKmRequest", output = "http://endpoints/ConversionServiceInterface/miToKmResponse")
    public double miToKm(
        @WebParam(name = "arg0", partName = "arg0")
        double arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://endpoints/ConversionServiceInterface/monthToDayRequest", output = "http://endpoints/ConversionServiceInterface/monthToDayResponse")
    public double monthToDay(
        @WebParam(name = "arg0", partName = "arg0")
        double arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://endpoints/ConversionServiceInterface/cmToInchRequest", output = "http://endpoints/ConversionServiceInterface/cmToInchResponse")
    public double cmToInch(
        @WebParam(name = "arg0", partName = "arg0")
        double arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://endpoints/ConversionServiceInterface/inchToCmRequest", output = "http://endpoints/ConversionServiceInterface/inchToCmResponse")
    public double inchToCm(
        @WebParam(name = "arg0", partName = "arg0")
        double arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://endpoints/ConversionServiceInterface/ftToMRequest", output = "http://endpoints/ConversionServiceInterface/ftToMResponse")
    public double ftToM(
        @WebParam(name = "arg0", partName = "arg0")
        double arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://endpoints/ConversionServiceInterface/kmToMiRequest", output = "http://endpoints/ConversionServiceInterface/kmToMiResponse")
    public double kmToMi(
        @WebParam(name = "arg0", partName = "arg0")
        double arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://endpoints/ConversionServiceInterface/mToFtRequest", output = "http://endpoints/ConversionServiceInterface/mToFtResponse")
    public double mToFt(
        @WebParam(name = "arg0", partName = "arg0")
        double arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://endpoints/ConversionServiceInterface/dayToMonthRequest", output = "http://endpoints/ConversionServiceInterface/dayToMonthResponse")
    public double dayToMonth(
        @WebParam(name = "arg0", partName = "arg0")
        double arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://endpoints/ConversionServiceInterface/weekToYearRequest", output = "http://endpoints/ConversionServiceInterface/weekToYearResponse")
    public double weekToYear(
        @WebParam(name = "arg0", partName = "arg0")
        double arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://endpoints/ConversionServiceInterface/miToFtRequest", output = "http://endpoints/ConversionServiceInterface/miToFtResponse")
    public double miToFt(
        @WebParam(name = "arg0", partName = "arg0")
        double arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://endpoints/ConversionServiceInterface/ftToMiRequest", output = "http://endpoints/ConversionServiceInterface/ftToMiResponse")
    public double ftToMi(
        @WebParam(name = "arg0", partName = "arg0")
        double arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://endpoints/ConversionServiceInterface/yearToWeekRequest", output = "http://endpoints/ConversionServiceInterface/yearToWeekResponse")
    public double yearToWeek(
        @WebParam(name = "arg0", partName = "arg0")
        double arg0);

}