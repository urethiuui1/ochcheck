package checker;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Check {
	// Rapidgator
	public static boolean rgcheck(String link) throws IOException {
		URL url = new URL(link);
		HttpURLConnection.setFollowRedirects(false);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");		

		if(con.getResponseCode() != 200) {
			return false;
		}else if(con.getResponseCode() == 301 || con.getResponseCode() == 302) {
			return false;
		}
		
		else {
			return true;
		}
	}
	
	
	//DDownload
	public static boolean ddlcheck(String link) throws IOException {
		URL url = new URL(link);
		HttpURLConnection.setFollowRedirects(false);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		String content;
		Scanner scanner = new Scanner(con.getInputStream());
		scanner.useDelimiter("\\Z");
		content = scanner.next();
		scanner.close();
		
		if(content.contains("File Not Found")) {
			return false;
		}else {
			return true;
		}

	}
	
	
	// Nitroflare
	public static boolean nitroflarecheck(String link) throws IOException {
		URL url = new URL(link);
		HttpURLConnection.setFollowRedirects(false);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");		
		if(con.getResponseCode() != 200) {
			return false;
		}
		else {
			return true;
		}
	}
}
