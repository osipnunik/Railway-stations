package test.log4j;

import org.apache.log4j.Logger;

public class LogTest {

	private static final Logger log = Logger.getLogger(Logger.class);
	
	public static void main(String[] args) {
		log.info("some text");
		log.error("some serios problem");
	}
}
