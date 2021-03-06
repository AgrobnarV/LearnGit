package omnicomm.test.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private final Properties properties;
  public WebDriver getDriver;
  public WebDriver wd;
  public FtpHelper ftp;

  private String browser;
  private RegistrationHelper registrationHelper;
  private MailHelper mailHelper;
  private JamesHelper jamesHelper;
  private DbHelper dbHelper;
  private ChangePasswordHelper chpass;
  private SoapHelper soapHelper;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {

    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    dbHelper = new DbHelper();
  }

  public void stop() {
    if (wd != null) {
      wd.quit();
    }
  }

  public HttpSession NewSession() {
    return new HttpSession(this);
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

  public RegistrationHelper registration() {
    if (registrationHelper == null) {
      registrationHelper = new RegistrationHelper(this);
    }
    return registrationHelper;
  }

  public WebDriver getDriver() {
    if (wd == null) {
      if (browser.equals(BrowserType.FIREFOX)) {
        wd = new FirefoxDriver();
      } else if (browser.equals(BrowserType.CHROME)) {
        wd = new ChromeDriver();
      }
      wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
      wd.get(properties.getProperty("web.baseUrl"));
    }
      return wd;
    }

  public FtpHelper ftp(){
    if (ftp == null) {
      ftp = new FtpHelper(this);
    }
    return ftp;
  }

  public MailHelper mail(){
    if (mailHelper == null) {
      mailHelper = new MailHelper(this);
    }
    return mailHelper;
  }

  public JamesHelper james() {
    if (jamesHelper == null) {
      jamesHelper = new JamesHelper(this);
    }
    return jamesHelper;
  }

  public HttpSession newSession() {
    return new HttpSession(this);
  }

  public DbHelper db() {
    return dbHelper;
  }
  public ChangePasswordHelper chpass() {
    if (chpass == null) {
      chpass = new ChangePasswordHelper(this);
    }
    return chpass;
  }

  public SoapHelper soap() {
    if (soapHelper == null) {
      soapHelper = new SoapHelper(this);
    }
    return soapHelper;
  }
}
