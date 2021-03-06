package kr.co.jhchoi.model;

public class BoardDto {
	   private int board_id;      
	   private String title;       
	   private String contents;	   
	   private String writer;       
	   private String password;     
	   private int read_cnt;    
	   private String wdate;       
	   private int cont_like;    
	   private int cont_unlike;  
	   private String pds_link;    
	   private int reply_level;  
	   private int ref_id;
	   
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRead_cnt() {
		return read_cnt;
	}
	public void setRead_cnt(int read_cnt) {
		this.read_cnt = read_cnt;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public int getCont_like() {
		return cont_like;
	}
	public void setCont_like(int cont_like) {
		this.cont_like = cont_like;
	}
	public int getCont_unlike() {
		return cont_unlike;
	}
	public void setCont_unlike(int cont_unlike) {
		this.cont_unlike = cont_unlike;
	}
	public String getPds_link() {
		return pds_link;
	}
	public void setPds_link(String pds_link) {
		this.pds_link = pds_link;
	}
	public int getReply_level() {
		return reply_level;
	}
	public void setReply_level(int reply_level) {
		this.reply_level = reply_level;
	}
	public int getRef_id() {
		return ref_id;
	}
	public void setRef_id(int ref_id) {
		this.ref_id = ref_id;
	}       
	     
}
