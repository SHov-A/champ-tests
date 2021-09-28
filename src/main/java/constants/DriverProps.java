package constants;

import java.util.HashMap;

public class DriverProps {
	public static HashMap<OS, String> chrome = new HashMap<>();
	public static HashMap<OS, String> firefox = new HashMap<>();
	public static HashMap<OS, String> opera = new HashMap<>();
	public static HashMap<OS, String> ie = new HashMap<>();

	static {
		chrome.put(OS.LINUX, "./drivers/chromedriver");
		chrome.put(OS.WINDOWS, "./drivers/chromedriver.exe");
		firefox.put(OS.LINUX, "./drivers/geckodriver");
		firefox.put(OS.WINDOWS, "./drivers/geckodriver.exe");
		opera.put(OS.LINUX, "./drivers/operadriver");
		opera.put(OS.WINDOWS, "./drivers/operadriver.exe");
		ie.put(OS.WINDOWS, "./drivers/IEDriverServer.exe");
	}
}
