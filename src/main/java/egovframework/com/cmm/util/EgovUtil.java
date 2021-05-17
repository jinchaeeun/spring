package egovframework.com.cmm.util;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.web.util.CookieGenerator;

import egovframework.com.cmm.service.CommonService;


/**
 * EgovComUtil 클래스
 * 
 * @author 서준식
 * @since 2011.09.15
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    -------------    ----------------------
 *   2011.09.15  서준식        최초 생성
 * </pre>
 */

@Service("EgovUtil")
public class EgovUtil implements ApplicationContextAware{
	
	/** Log Info */
	protected Log log = LogFactory.getLog(this.getClass());
	
	@Resource(name="commonService")
	private CommonService commonService;

	
	public static ApplicationContext context;

	public void setApplicationContext(ApplicationContext context)
			throws BeansException {

		this.context = context;
	}

	/**
	 * Spring MVC에서 설정한 빈이 아닌 서비스 빈(컴포넌트)만을 검색할 수 있음
	 * 
	 */
	public static boolean hasComponent(String componentName){

		try{
			Object component = context.getBean(componentName);

			if(component == null){
				return false;
			}else{
				return true;
			}	

		}catch(NoSuchBeanDefinitionException ex){// 해당 컴포넌트를 찾을 수없을 경우 false반환
			return false;
		}
	}

	/**
	 * Spring MVC에서 설정한 빈이 아닌 서비스 빈(컴포넌트)를  Object로 넘김
	 * 
	 */
	public static Object getComponent(String componentName){

		try{
			Object component = context.getBean(componentName);

			if(component == null){
				return null;
			}else{
				return component;
			}	

		}catch(NoSuchBeanDefinitionException ex){// 해당 컴포넌트를 찾을 수없을 경우 false반환
			System.out.print("//" + componentName);
			return null;
		}
	}

	

	/**
	 * cookieName에 해당하는 쿠키값을 Object로 넘겨준다.
	 * @param req
	 * @param cookieName
	 * @return
	 */
	public static Object getCookie(HttpServletRequest req,String cookieName){
		String cookieValue = "";
		try{
			Cookie[] cookies = req.getCookies();
			if (cookies != null && cookies.length > 0) {
				for (Cookie cookie : cookies) {
					if (cookieName.equals(cookie.getName())) {
						cookieValue = cookie.getValue();
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			cookieValue = "";
		}
		return cookieValue;
	}

	/**
	 * cookieName에 해당하는 value값으로 쿠키를 셋팅한다.
	 * @param res
	 * @param cookieName
	 * @param value
	 */
	public static void setCookie(HttpServletResponse res,String cookieName,String value){
		CookieGenerator cookieGer = new CookieGenerator();
		cookieGer.setCookieName(cookieName);
		cookieGer.addCookie(res, value);
	}
	
	/**
	 * headerName에 해당하는 해더값을 가져온다.(140915이여름추가)
	 * @param req
	 * @param headerName
	 * @return
	 */
	public static String getHeader(HttpServletRequest req, String headerName) {
		String headerValue = "";
		try {
			headerValue = req.getHeader(headerName);
		} catch (Exception ex){
			ex.printStackTrace();
			headerValue = "";
		}
		return headerValue;
	}
	
	/**
	 * User-Agent값을 가져온다.(140915이여름추가)
	 * @param req
	 * @return ANDROID, IOS, WEB
	 */
	public static String getUserAgent(HttpServletRequest req) {
		String headerValue = "";
		try {
			headerValue = req.getHeader("User-Agent").toUpperCase();
			if(headerValue.contains("ANDROID")){
				headerValue = "ANDROID";
			}else if(headerValue.contains("IPHONE")){
				headerValue = "IOS";
			}else{
				headerValue = "WEB";
			}
		} catch (Exception ex){
			ex.printStackTrace();
			headerValue = "";
		}
		return headerValue;
	}
	
	
		
	
	
	/**
	 * 브라우저 종류 체크
	 * @param userAgent
	 * @return 
	 */
	public static String getCheckBrowser(String userAgent){
		String browser = "";
        if (userAgent.indexOf("Trident") > -1) {
        	browser = "Trident";
        } else if(userAgent.indexOf("MSIE") > -1){
        	browser = "MSIE";
        } else if (userAgent.indexOf("Chrome") > -1) {
        	browser = "Chrome";
        } else if (userAgent.indexOf("Opera") > -1) {
        	browser = "Opera";
        } else if (userAgent.indexOf("Firefox") > -1) {
        	browser = "Firefox";
        }
        
        return browser; 
	}
	
	/**
	 * 브라우저 종류별 버전 체크
	 * @return
	 */
	public static int getCheckBrowserVersion(String userAgent){
		String browser = EgovUtil.getCheckBrowser(userAgent);
		
		Pattern pattern = Pattern.compile(browser+"/\\d.\\d");
		Matcher matcher = pattern.matcher(userAgent);
		String tmp = "";
		if(matcher.find()){
			tmp = matcher.group(0);
			//System.out.println(tmp.substring(browser.length()-1));
			//System.out.println(tmp.substring(browser.length()));
			try{
				float tmpFloat = Float.parseFloat(tmp.substring(browser.length()+1));
				
				if("Trident".equals(EgovUtil.getCheckBrowser(userAgent))){
					return (int)(tmpFloat+4.0f);
				}else{
					return (int)tmpFloat;
				}
				
			}catch(Exception ex){ex.printStackTrace();return 0;}
		}else{
			return 0;
		} 
	}
	
	
	
	public String encMd5(String str) throws Exception{
		StringBuffer sb = new StringBuffer();
		if(str != null){
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(str.getBytes()); 
			byte byteData[] = md.digest();
			 
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
		}else{
			sb.setLength(0);
		}
		return sb.toString();
	}
	
	
	/**
	 * object를 맵으로 변경
	 * @param obj
	 * @return
	 */
	public static HashMap<String,Object> ConverObjectToMap(Object obj){
		try {
			//Field[] fields = obj.getClass().getFields(); //private field는 나오지 않음.
			Field[] fields = obj.getClass().getDeclaredFields();
			HashMap<String,Object> resultMap = new HashMap<String,Object>();
			//System.out.println("#### surosuro :: "+fields.length);
			for(int i=0; i<=fields.length-1;i++){
				fields[i].setAccessible(true);
				//System.out.println(fields[i].getName()+" : "+fields[i].get(obj));
				resultMap.put(fields[i].getName(), fields[i].get(obj));
			}
			return resultMap;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
