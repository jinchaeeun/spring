package egovframework.com.cmm;

import egovframework.com.cmm.service.CommonService;
import egovframework.com.cmm.util.EgovProperties;
import egovframework.com.cmm.util.EgovUtil;

/**
 *  Class Name : Globals.java
 *  Description : 시스템 구동 시 프로퍼티를 통해 사용될 전역변수를 정의한다.
 *  Modification Information
 *
 *     수정일         수정자                   수정내용
 *   -------    --------    ---------------------------
 *   2009.01.19    박지욱          최초 생성
 *
 *  @author 공통 서비스 개발팀 박지욱
 *  @since 2009. 01. 19
 *  @version 1.0
 *  @see
 *
 */

public class Globals {
	public static final String OS_TYPE = EgovProperties.getProperty("Globals.os_type");
	
	public static final String WEB_PATH = getWeb_path();
	
	/** 암호화 사용여부 ENC_J:자바 암호화 ENC_D:디비 암호화 ENC_N:사용안함 */
	public static final String ENC_USE_AT = EgovProperties.getProperty("Globals.enc_use_at");
	
	/** 사이트 도메인*/
	public static final String DOMAIN = getWeb_Domain();
	
	/** 사이트 절대경로*/
	public static final String WEB_REAL_PATH = getWeb_realPath(); 
			//EgovProperties.getProperty("Globals.realPath");
	
	/** 파일 저장 경로 - 절대경로 포함*/
	public static final String FILE_STORE_FULL_PATH = WEB_REAL_PATH+EgovProperties.getProperty("Globals.fileStorePath");
	
	/** 파일 저장 경로 - 절대경로 제외*/
	public static final String FILE_STORE_PATH = EgovProperties.getProperty("Globals.fileStorePath");
	
	/** 썸네일 사이즈*/
	public static final String FILE_THUMB_SIZE = EgovProperties.getProperty("Globals.fileThumbSize");
	
	/** 파일 업로드 절대경로(사이트 밖 경로) */
	public static final String FILE_OUT_REAL_PATH = EgovProperties.getProperty("Globals.fileOutRealPath");
	
	/** 업로드 가능 확장자 */
	public static final String EXT_IMG = EgovProperties.getProperty("Globals.ext_img");
	public static final String EXT_MOV = EgovProperties.getProperty("Globals.ext_mov");
	public static final String EXT_ETC = EgovProperties.getProperty("Globals.ext_etc");
		
    //DB 유형
    public static final String DB_TYPE = EgovProperties.getProperty("Globals.DbType");
    
   
        		
	/**
	 * 동적으로 현재 컨텍스트를 가져온다.
	 * @return
	 */
	private static String getWeb_path(){
		if(Globals.WEB_PATH == null){
			try{
				Object obj = EgovUtil.getComponent("commonService");
				CommonService commonService = (CommonService)obj;
				return "/".equals(commonService.getContextPath()) ? "" : commonService.getContextPath();
			}catch(Exception ex){
				ex.printStackTrace();
				return "";
			}
		}
		return Globals.WEB_PATH;
	}
	
	/**
	 * 동적으로 현재 컨텍스트의 절대경로를 가져온다.
	 * Properties 에 등록되어 있을 경우 Properties를 우선하며
	 * 없을경우 동적으로 가져옴
	 * @return
	 */
	private static String getWeb_realPath(){
		if(Globals.WEB_REAL_PATH == null || "99".equals(Globals.WEB_REAL_PATH)){
			if(EgovProperties.getProperty("Globals.web_real_path") == null || "99".equals(EgovProperties.getProperty("Globals.web_real_path"))){
				try{
					Object obj = EgovUtil.getComponent("commonService");
					CommonService commonService = (CommonService)obj;
					return commonService.getRealPath();
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}else{
				return EgovProperties.getProperty("Globals.web_real_Path");
			}
		}
		return Globals.WEB_REAL_PATH;
	}
	
	/**
	 * 동적으로 서버 도메인(호스트)을 가져온다.
	 * Properties 에 등록되어 있을 경우 Properties를 우선하며
	 * 없을경우 동적으로 가져옴
	 * @return
	 */
	private static String getWeb_Domain(){
		if(EgovProperties.getProperty("Globals.domain") == null || "99".equals(EgovProperties.getProperty("Globals.domain"))){
			try{
				Object obj = EgovUtil.getComponent("commonService");
				CommonService commonService = (CommonService)obj;
				return commonService.getServerName()+":"+commonService.getServerPort();
			}catch(Exception ex){
				ex.printStackTrace();
				return EgovProperties.getProperty("Globals.domain");
			}
		}else{
			return EgovProperties.getProperty("Globals.domain");
		}
	}
	
	/** 정적 이미지 최상위 경로
	public static final String IMG_PATH = getImg_path(); */
	/**
	 * 이미지 경로 가져오기
	 * Properties 에 등록되어 있을 경우 Properties를 우선하며
	 * 없을경우 WEB_PATH를 이용
	 * @return
	 
	private static String getImg_path(){
		if(EgovStrUtil.isEmpty(Globals.IMG_PATH)){
			if(EgovStrUtil.isEmpty(EgovProperties.getProperty("Globals.img_path"))){
				return getWeb_path()+"/";
			}else{
				return EgovProperties.getProperty("Globals.img_path")+"/";
			}
		}
		return Globals.IMG_PATH;
	}*/
}
