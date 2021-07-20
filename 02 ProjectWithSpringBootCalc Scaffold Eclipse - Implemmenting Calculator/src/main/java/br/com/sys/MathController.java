package br.com.sys;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sys.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum( @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set an numeric value");
		}
		
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value = "/substraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double substraction( @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set an numeric value");
		}
		
		Double sum = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiply( @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set an numeric value");
		}
		
		Double sum = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division( @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set an numeric value");
		}
		
		Double sum = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media( @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set an numeric value");
		}
		
		Double sum = (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
		return sum;
	}
	
	@RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
	public Double squareRoot( @PathVariable("number") String number) throws Exception {
		
		if (!isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set an numeric value");
		}
		
		Double sum = (Double) Math.sqrt(convertToDouble(number));
		return sum;
	}


	private Double convertToDouble(String strNumber) {
		if (strNumber == null) {
			return 0D;
		}
		
		String num = strNumber.replaceAll(",", ".");
		
		if (isNumeric(num)) {
			return Double.parseDouble(num);
		}
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		
		if (strNumber == null) {
			return false;
		}
		
		String num = strNumber.replaceAll(",", ".");
		return num.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
