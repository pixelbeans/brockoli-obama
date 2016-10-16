
public class Zipcode {
		
	// declare instance variables
	private String zipcode;
	private String barcode;
	private String convertCode;
	private boolean valid;
	private int convertNumber;
	private int checkDigit;
	
	/**
	 * Constructor (second)
	 * overloads constructor
	 * @param barcode_input user input that will be converted
	 */
	public Zipcode(String barcode_input) {
		convertCode = barcode_input;
	}
	
	/**
	 * Constructor
	 * initializes some instance variables
	 * @param zip_number user input that will be converted
	 */
	public Zipcode(int zip_number) {
		this.zipcode = "";
		this.barcode = zipToBar(zip_number);
		valid = true;
		convertNumber = zip_number;
		checkDigit = sumOfZip();
	}

	/**Method sumofZip
	 * Mutator
	 * finds check digit for user input
	 * @return checkDigit
	 */
	private int sumOfZip() {
		int currentDigit = 0;
		int currentSum = 0;
		int checkDigit = 0;
		while (convertNumber >= 10) {
			currentDigit = convertNumber % 10;
			currentSum += currentDigit;
			convertNumber = convertNumber / 10;
		}
		if (convertNumber >= 0) {
			currentSum += convertNumber;
		}
		while (currentSum >= 10) {
			currentSum = currentSum - 10;
		}
		if (currentSum < 10) {
			checkDigit = 10 - currentSum;
		}
		return checkDigit;
	}
	
	/**
	 * Method zipToBar
	 * Mutator
	 * converts user input to String, converts String to barcode,
	 * finds check digit, and adds check digit to barcode
	 * @return barcode
	 */
	private String zipToBar(int convertNumber) {
		int i;
		barcode = "|";
		zipcode = Integer.toString(convertNumber);
		String zipcode = String.format("%05d", convertNumber);
		for (i = 0; i < zipcode.length(); i++) {
			if (zipcode.charAt(i) == '0') {
				barcode += "||:::";
			}
			else if (zipcode.charAt(i) == '1') {
				barcode += ":::||";
			}
			else if (zipcode.charAt(i) == '2') {
				barcode += "::|:|";
			}
			else if (zipcode.charAt(i) == '3') {
				barcode += "::||:";
			}
			else if (zipcode.charAt(i) == '4') {
				barcode += ":|::|";
			}
			else if (zipcode.charAt(i) == '5') {
				barcode += ":|:|:";
			}
			else if (zipcode.charAt(i) == '6') {
				barcode += ":||::";
			}
			else if (zipcode.charAt(i) == '7') {
				barcode += "|:::|";
			}
			else if (zipcode.charAt(i) == '8') {
				barcode += "|::|:";
			}
			else if (zipcode.charAt(i) == '9') {
				barcode += "|:|::";
			}	
		}
		if (checkDigit == 0) {
			barcode += "||:::|";
		}
		else if (checkDigit == 1) {
			barcode += ":::|||";
		}
		else if (checkDigit == 2) {
			barcode += "::|:||";
		}
		else if (checkDigit == 3) {
			barcode += "::||:|";
		}
		else if (checkDigit == 4) {
			barcode += ":|::||";
		}
		else if (checkDigit == 5) {
			barcode += ":|:|:|";
		}
		else if (checkDigit == 6) {
			barcode += ":||::|";
		}
		else if (checkDigit == 7) {
			barcode += "|:::||";
		}
		else if (checkDigit == 8) {
			barcode += "|::|:|";
		}
		else if (checkDigit == 9) {
			barcode += "|:|::|";
		}
		return barcode;	
	}
	
	/**
	 * Accessor
	 * @return checkDigit
	 */
	public int getCheckDigit() {
		return checkDigit;
	}
	
	/**
	 * Accessor
	 * @return converted barcode
	 */
	public String getBarcode() {
		return barcode;
	}

	
}
