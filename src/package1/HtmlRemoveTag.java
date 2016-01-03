package package1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlRemoveTag {
	public static String Remove (String inputStr){
		String htmlStr = inputStr;
	
		Pattern p_strong ;
		Matcher m_strong;
		Pattern p_a;
		Matcher m_a;
		Pattern p_span;
		Matcher m_span;
		Pattern p_em;
		Matcher m_em;
		Pattern p_iframe;
		Matcher m_iframe;
		Pattern p_nbsp;
		Matcher m_nbsp;
		
		try {
			String regEx_strong = "<[\\s]*?strong[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?strong[\\s]*?>"; 
			p_strong = Pattern.compile(regEx_strong, Pattern.CASE_INSENSITIVE);
			m_strong = p_strong.matcher(htmlStr);
			int time = 0;
			while (m_strong.find()){
				System.out.println(time);
				time++;
				String strong = m_strong.group().substring(m_strong.group().indexOf("<strong>")+8,m_strong.group(). indexOf("</strong>"));
				htmlStr = m_strong.replaceAll(strong);
			}
			
			/*
			String regEx_a =  "<[\\s]*?a[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?a[\\s]*?>"; 
			p_a = Pattern.compile(regEx_a, Pattern.CASE_INSENSITIVE);
			m_a = p_a.matcher(htmlStr);
			htmlStr = m_a.replaceAll("");
			
			String regEx_span =  "<[\\s]*?span[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?span[\\s]*?>"; 
			p_span = Pattern.compile(regEx_span, Pattern.CASE_INSENSITIVE);
			m_span = p_span.matcher(htmlStr);
			htmlStr = m_span.replaceAll("");
			
			String regEx_em = "<[\\s]*?em[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?em[\\s]*?>"; 
			p_em = Pattern.compile(regEx_em, Pattern.CASE_INSENSITIVE);
			m_em = p_em.matcher(htmlStr);
			htmlStr = m_em.replaceAll("");
			
			String regEx_iframe = "<[\\s]*?iframe[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?iframe[\\s]*?>"; 
			p_iframe = Pattern.compile(regEx_iframe, Pattern.CASE_INSENSITIVE);
			m_iframe = p_iframe.matcher(htmlStr);
			htmlStr = m_iframe.replaceAll("");
			
			String regEx_nbsp="[\\s]*?&nbsp[\\s]*?;";
			p_nbsp = Pattern.compile(regEx_nbsp, Pattern.CASE_INSENSITIVE);
			m_nbsp = p_nbsp.matcher(htmlStr);
			htmlStr = m_nbsp.replaceAll("");
		*/				
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return htmlStr;
	}
	public static void main (String [] args) throws IOException{
		
		try{
			File file = new File("data/test.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader BufferReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line = "";
			while ((line = BufferReader.readLine()) != null){
				stringBuffer.append(line);
			}
			fileReader.close();
			System.out.println("Content of file");
			System.out.println(stringBuffer.toString());
			String str = HtmlRemoveTag.Remove(stringBuffer.toString());
			System.out.println(str);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
