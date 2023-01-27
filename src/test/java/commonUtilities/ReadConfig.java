package commonUtilities;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties properties;
	FileReader fileReader;

	public ReadConfig(){
		    properties = new Properties();
		
			try {
				fileReader = new FileReader(System.getProperty("user.dir")+"/Confuguration/config.properties");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				properties.load(fileReader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	public String getBrowser()
	{
		String value = properties.getProperty("browser");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");
	}
	
	public String getBaseUrl()
	{
		String value = properties.getProperty("baseurl");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");
    }

	public String getEmail()
	{
		String email = properties.getProperty("defaultuser");
		if(email!=null)
			return email;
		else
			throw new RuntimeException("email not specified in config file.");
		}

	public String getPassword()
	{
		String password = properties.getProperty("defaultpassword");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("password not specified in config file.");
		
	}
	public String getDataType()
	{
		String type = properties.getProperty("type");
		if(type!=null)
			return type;
		else
			throw new RuntimeException("login Data type not specified in config file.");
		
	}
}
