package Test;

import java.text.SimpleDateFormat;
import java.util.UUID;

import org.apache.log4j.chainsaw.Main;
import org.apache.poi.ss.formula.functions.T;

public class ClassTest {
    public static void main(String[] args) {
		
    	SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String pay_time = simple.format(System.currentTimeMillis());
		String create_time = simple.format(System.currentTimeMillis());
		System.out.println(create_time);
	}
    
}
