package hustar.bbs.service;

import egovframework.com.cmm.ComDefaultVO;

public class NoticeVO extends ComDefaultVO {
	public int seq;
	public String subject;
	public String writer;
	public String date;
	public String contents;
	
	//단축키 Alt+shift+s -> Generate Getters and Setters 클릭
	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	

	
}
