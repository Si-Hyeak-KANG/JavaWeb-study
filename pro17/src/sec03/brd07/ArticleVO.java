package sec03.brd07;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Date;

public class ArticleVO {

	private int level;
	private int articleNO;
	private int parentNO;
	private String title;
	private String content;
	private String imageFileName;
	private String id;
	private Date writeDate;
	
	
	public ArticleVO() {
		super();
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getArticleNO() {
		return articleNO;
	}


	public void setArticleNO(int articleNO) {
		this.articleNO = articleNO;
	}


	public int getParentNO() {
		return parentNO;
	}


	public void setParentNO(int parentNO) {
		this.parentNO = parentNO;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getImageFileName() {
		
			try {
				
				if (imageFileName != null && imageFileName.length() != 0) {
					
					imageFileName = URLDecoder.decode(imageFileName,"utf-8");
				}
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return imageFileName;
	}


	public void setImageFileName(String imageFileName) {
		
		try {
			
			if (imageFileName != null && imageFileName.length() != 0) {
				this.imageFileName = URLEncoder.encode(imageFileName,"utf-8");
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		
		this.writeDate = writeDate;
	}
	
	
}
