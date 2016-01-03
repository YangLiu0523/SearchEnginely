package package1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlGetInfo {
	public static ArrayList<String> getUrl(String htmlStr){
		ArrayList<String> allUrl = new ArrayList<String> ();
		
		Pattern p_url ;
		Matcher m_url;
		
		String regEx_url = "<url>[\\s\\S]*?</url>"; 
		p_url = Pattern.compile(regEx_url, Pattern.CASE_INSENSITIVE);
		m_url = p_url.matcher(htmlStr);
		
		while (m_url.find()){
			String ans = m_url.group();
			ans = ans.substring(ans.indexOf("<url>")+5,ans.indexOf("</url>"));
			allUrl.add(ans);
		}
		return allUrl;
	}
	public static ArrayList<String> getPublishid(String htmlStr){
		ArrayList<String> allPublishid = new ArrayList<String> ();
		
		Pattern p_publishid;
		Matcher m_publishid;
		
		String regEx_publishid = "publishid[\\s\\S]*?>";
		p_publishid = Pattern.compile(regEx_publishid, Pattern.CASE_INSENSITIVE);
		m_publishid = p_publishid.matcher(htmlStr);
		
		while (m_publishid.find()){
			String ans = m_publishid.group();
			ans = ans.substring(ans.indexOf("=")+2,ans.indexOf('>')-1);
			allPublishid.add(ans);
		}
		return allPublishid;
	}
	
	public static void main (String [] args){
		StringBuffer sb = new StringBuffer();
		try{
			FileReader fr = new FileReader("data/test.txt");
			BufferedReader br = new BufferedReader(fr);
			String s = "";
			while ((s = br.readLine()) != null) sb.append(s);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		for (String s :  HtmlGetInfo.getUrl(sb.toString()))
			System.out.println(s);
		for (String s :  HtmlGetInfo.getPublishid(sb.toString()))
			System.out.println(s);
	}
}
