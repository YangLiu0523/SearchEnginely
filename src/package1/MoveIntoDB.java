package package1;

public class MoveIntoDB {
	private String url;
	private String publishid;
	private String subjectid;
	private String title;
	private String keywords;
	private String description;
	private String content;
	
	public MoveIntoDB(String url, String publishid,String subjectid,String title,String keywords,String description,String content){
		this.url = url;
		this.publishid = publishid;
		this.subjectid = subjectid;
		this.title = title;
		this.keywords = keywords;
		this.description = description;
		this.content = content;
	}
	public void setMoveIntoDB(String url, String publishid,String subjectid,String title,String keywords,String description,String content){
		this.url = url;
		this.publishid = publishid;
		this.subjectid = subjectid;
		this.title = title;
		this.keywords = keywords;
		this.description = description;
		this.content = content;
	}
	public void addToDB(DBConnection dbc){
		String sql = "insert into pageindex(url,publishid,subjectid,title,keywords,description,content)"+
	            "values('"+url+"', '"+publishid+"','''+subjectid+''','"+title+"','"+keywords+"','"+description+"','"+content+"')";
	    dbc.executeQuery(sql);
	}	
}
