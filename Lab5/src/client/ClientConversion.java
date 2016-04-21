package client;

import java.util.Scanner;

public class ClientConversion {
	public static void main(String[] args) {
		String input = "";
		ConversionServiceService service = new ConversionServiceService();
		ConversionServiceInterface server = service.getConversionServicePort();
		System.out.println("use symbols only: inches = in; " + " kilometer = km; " + " feet = ft; etc.");
		System.out.println(
				"in <---> ft, in <---> cm, ft <---> m, ft <---> mi, mi <--> km, days<--->months, weeks <--->years");
		System.out.println("Enter the command, e.g: 10 in ? ft ; 10 days ? months ; 10 weeks ? years; Enter exit to exit the program");
		Scanner sc = new Scanner(System.in);
		while (!input.equals("exit") || input.equals("error")) {
			input = sc.nextLine();
			int i = input.indexOf(" ");
			
			if (input.contains("in ? cm")) {
				input = input.substring(0, i);
				double value = Double.parseDouble(input);
				System.out.println(server.inchToCm(value));
				
			} else if (input.contains("cm ? in")) {
				input = input.substring(0, i);
				double value = Double.parseDouble(input);
				System.out.println(server.cmToInch(value));
			}

			else if (input.contains("in ? ft")) {
				input = input.substring(0, i);
				double value = Double.parseDouble(input);
				System.out.println(server.inchToFeet(value));
			}

			else if (input.contains("ft ? in")) {
				input = input.substring(0, i);
				double value = Double.parseDouble(input);
				System.out.println(server.feetToInch(value));
			}

			else if (input.contains("ft ? mi")) {
				input = input.substring(0, i);
				double value = Double.parseDouble(input);
				System.out.println(server.ftToMi(value));
			}

			else if (input.contains("mi ? ft")) {
				input = input.substring(0, i);
				double value = Double.parseDouble(input);
				System.out.println(server.miToFt(value));
			}

			else if (input.contains("ft ? m")) {
				input = input.substring(0, i);
				double value = Double.parseDouble(input);
				System.out.println(server.ftToM(value));
			}

			else if (input.contains("m ? ft")) {
				input = input.substring(0, i);
				double value = Double.parseDouble(input);
				System.out.println(server.mToFt(value));
			}

			else if (input.contains("mi ? km")) {
				input = input.substring(0, i);
				double value = Double.parseDouble(input);
				System.out.println(server.miToKm(value));
			}

			else if (input.contains("km ? mi")) {
				input = input.substring(0, i);
				double value = Double.parseDouble(input);
				System.out.println(server.kmToMi(value));
			}

			else if (input.contains("days ? months")) {
				input = input.substring(0, i);
				double value = Double.parseDouble(input);
				System.out.println(server.dayToMonth(value));
			}

			else if (input.contains("months ? days")) {
				input = input.substring(0, i);
				double value = Double.parseDouble(input);
				System.out.println(server.monthToDay(value));
			}

			else if (input.contains("weeks ? years")) {
				input = input.substring(0, i);
				double value = Double.parseDouble(input);
				System.out.println(server.weekToYear(value));
			}

			else if (input.contains("years ? weeks")) {
				input = input.substring(0, i);
				double value = Double.parseDouble(input);
				System.out.println(server.yearToWeek(value));
			} 
			else if (input.equals("exit")) {
				System.out.println("Exit the program....");
			}
			else {
				input = "error";
				System.out.println("Error: Invalid command, please re-enter the command!");
			}
		}

	}
}
