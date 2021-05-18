package egovframework.com.test.service;

import egovframework.com.cmm.ComDefaultVO;

public class TestVO extends ComDefaultVO{
	private String te_id;
	private String te_name;
	private String te_nick;
	private String te_content;
	private String insert_date;
	private String modify_date;
	private String te_is_notice;
	private String te_is_best;
	private String te_is_check;
	private String te_ids[];
	
	public String[] getTe_ids() {
		return te_ids;
	}
	public void setTe_ids(String[] te_ids) {
		this.te_ids = te_ids;
	}
	public String getTe_is_check() {
		return te_is_check;
	}
	public void setTe_is_check(String te_is_check) {
		this.te_is_check = te_is_check;
	}
	public String getTe_nick() {
		return te_nick;
	}
	public void setTe_nick(String te_nick) {
		this.te_nick = te_nick;
	}
	public String getTe_is_best() {
		return te_is_best;
	}
	public void setTe_is_best(String te_is_best) {
		this.te_is_best = te_is_best;
	}
	public String getTe_is_notice() {
		return te_is_notice;
	}
	public void setTe_is_notice(String te_is_notice) {
		this.te_is_notice = te_is_notice;
	}
	public String getTe_id() {
		return te_id;
	}
	public void setTe_id(String te_id) {
		this.te_id = te_id;
	}
	public String getTe_name() {
		return te_name;
	}
	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}
	public String getTe_content() {
		return te_content;
	}
	public void setTe_content(String te_content) {
		this.te_content = te_content;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public String getModify_date() {
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
}