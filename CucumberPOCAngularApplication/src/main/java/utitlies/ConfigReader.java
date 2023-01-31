package utitlies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	/**
	 * This method is used to load config.properties file 
	 * @return it return Properties prop object
	 */
	public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/configs/config.properties");

			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return prop;
	}

}
