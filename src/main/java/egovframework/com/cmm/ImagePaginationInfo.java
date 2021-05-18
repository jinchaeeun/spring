package egovframework.com.cmm;


import java.text.MessageFormat;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

public class ImagePaginationInfo extends PaginationInfo{
	
	private String firstPageLabel;
	private String previousPageLabel;
	private String currentPageLabel;
	private String otherPageLabel;
	private String nextPageLabel;
	private String lastPageLabel;
	
	public ImagePaginationInfo(){
		initVariables();
	}
	public void initVariables(){
		/*firstPageLabel    = "<li>&#160;</li><li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \"><img src=\"" + servletContext.getContextPath() +  "/images/egovframework/com/cmm/mod/icon/icon_prevend.gif\" alt=\"처음\"   border=\"0\"/></a></li>";
        previousPageLabel = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \"><img src=\"" + servletContext.getContextPath() +  "/images/egovframework/com/cmm/mod/icon/icon_prev.gif\"    alt=\"이전\"   border=\"0\"/></a></li>";
        currentPageLabel  = "<li><strong>{0}</strong></li>";
        otherPageLabel    = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">{2}</a></li>";
        nextPageLabel     = "<li>&#160;<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \"><img src=\"" + servletContext.getContextPath() +  "/images/egovframework/com/cmm/mod/icon/icon_next.gif\"    alt=\"다음\"   border=\"0\"/></a></li>";
        lastPageLabel     = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \"><img src=\"" + servletContext.getContextPath() +  "/images/egovframework/com/cmm/mod/icon/icon_nextend.gif\" alt=\"마지막\" border=\"0\"/></a></li>";
        */
        firstPageLabel    = "<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \" class=\"pre_end\">처음</a>&#160;";
        previousPageLabel = "<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \" class=\"pre\">이전</a>&#160;";
        currentPageLabel  = "<strong>{0}</strong>&#160;";
        otherPageLabel    = "<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">{2}</a>&#160;";
        nextPageLabel     = "<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \" class=\"next\">다음</a>&#160;";
        lastPageLabel     = "<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \" class=\"next_end\">끝</a>&#160;";
	}
	
	public String getPagingHtml(String jsFunction){		
		StringBuffer strBuff = new StringBuffer();
        
        int firstPageNo = this.getFirstPageNo();
        int firstPageNoOnPageList = this.getFirstPageNoOnPageList();
        int totalPageCount = this.getTotalPageCount();
		int pageSize = this.getPageSize();
		int lastPageNoOnPageList = this.getLastPageNoOnPageList();
		int currentPageNo = this.getCurrentPageNo();
		int lastPageNo = this.getLastPageNo();
				
		//if(totalPageCount > pageSize){
			if(firstPageNoOnPageList > pageSize){
				strBuff.append(MessageFormat.format(firstPageLabel,new Object[]{jsFunction,Integer.toString(firstPageNo)}));
				strBuff.append(MessageFormat.format(previousPageLabel,new Object[]{jsFunction,Integer.toString(firstPageNoOnPageList-1)}));
	        }else{
	        	strBuff.append(MessageFormat.format(firstPageLabel,new Object[]{jsFunction,Integer.toString(firstPageNo)}));
				strBuff.append(MessageFormat.format(previousPageLabel,new Object[]{jsFunction,Integer.toString(firstPageNo)}));
	        }
		//}
		
		for(int i=firstPageNoOnPageList;i<=lastPageNoOnPageList;i++){
			if(i==currentPageNo){
        		strBuff.append(MessageFormat.format(currentPageLabel,new Object[]{Integer.toString(i)}));
        	}else{
        		strBuff.append(MessageFormat.format(otherPageLabel,new Object[]{jsFunction,Integer.toString(i),Integer.toString(i)}));
        	}
        }
		
		//if(totalPageCount > pageSize){
			if(lastPageNoOnPageList < totalPageCount){
	        	strBuff.append(MessageFormat.format(nextPageLabel,new Object[]{jsFunction,Integer.toString(firstPageNoOnPageList+pageSize)}));
	        	strBuff.append(MessageFormat.format(lastPageLabel,new Object[]{jsFunction,Integer.toString(lastPageNo)}));
	        }else{
	        	strBuff.append(MessageFormat.format(nextPageLabel,new Object[]{jsFunction,Integer.toString(lastPageNo)}));
	        	strBuff.append(MessageFormat.format(lastPageLabel,new Object[]{jsFunction,Integer.toString(lastPageNo)}));
	        }
		//}
		
		return strBuff.toString();
	}
	/*
	public String getPagingHtml2(){
		int pageIndex = this.getCurrentPageNo();
		int firstIndex = this.getFirstPageNoOnPageList();
    	int lastIndex = this.getLastPageNoOnPageList();
    	
    	int firstPage = this.getFirstPageNo();
    	int lastPage = this.getLastPageNo();
    	
    	int beforePage = pageIndex;
    	if(pageIndex > 1){
    		beforePage = pageIndex - 1;
    	}
    	
    	int nextPage = pageIndex;
    	if(nextPage < lastPage){
    		nextPage = pageIndex + 1;
    	}
    	
    	String pagingHtml = "";
    	pagingHtml += "<div class='paging' style='text-align:center;'>";
    	pagingHtml += "<ul>";
    	pagingHtml += "<a href='?pageIndex="+firstPage+"' onclick='fn_comment_paging("+firstPage+");return false; ' class='pre_end' title='처음페이지'><img src='/newspaper/tmplat/images/common/paging_first.gif' alt='처음' /></a>&nbsp;";
    	pagingHtml += "<a href='?pageIndex="+beforePage+"' onclick='fn_comment_paging("+beforePage+");return false; ' class='pre' title='이전페이지'><img src='/newspaper/tmplat/images/common/paging_before.gif' alt='이전' /></a>&nbsp;";
    	for(int i=firstIndex;i<=lastIndex;i++){
    		if(pageIndex == i){
    			pagingHtml += "<strong>"+i+"</strong>&nbsp;";
    		}else{
    			pagingHtml += "<a href='?pageIndex="+i+"' onclick='fn_comment_paging("+i+");return false; '>"+i+"</a>&nbsp;";
    		}
    	}
    	pagingHtml += "<a href='?pageIndex="+nextPage+"' onclick='fn_comment_paging("+nextPage+");return false; ' class='next' title='다음페이지'><img src='/newspaper/tmplat/images/common/paging_next.gif' alt='다음' /></a>&nbsp;";
    	pagingHtml += "<a href='?pageIndex="+lastPage+"' onclick='fn_comment_paging("+lastPage+");return false; ' class='next_end' title='마지막페이지'><img src='/newspaper/tmplat/images/common/paging_end.gif' alt='끝' /></a>&nbsp;";
    	pagingHtml += "</ul>";
    	pagingHtml += "</div>";
		return pagingHtml;
	}*/
}
