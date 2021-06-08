package hustar.page.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	public static String saveFile(MultipartFile file, String path) {
		if (file == null) {
			return null;
		}
		
	    // 파일 이름 변경
	    UUID uuid = UUID.randomUUID();
	    String filename = uuid + "_" + file.getOriginalFilename();	//파일이 많아지면 이름이 중복될 수 있으니 랜덤으로 생성한 값을 앞에 붙여준다.

	    // 저장할 File 객체를 생성(껍데기 파일)ㄴ
	    File saveFile = new File(path, filename); // 저장할 폴더 이름, 저장할 파일 이름

	    try {
	        file.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입힘
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }

	    return filename;
	}
	
	/**
	 * 서버 파일에 대하여 다운로드를 처리한다.
	 *
	 * @param response
	 * @param streFileNm 파일저장 경로가 포함된 형태
	 * @param orignFileNm
	 * @throws Exception
	 */
	public static void downFile(HttpServletRequest request, HttpServletResponse response, String streFileNm, String orignFileNm) throws Exception {
		String downFileName = streFileNm;
		String orgFileName = orignFileNm;

		File file = new File(downFileName);
		
		if (!file.exists()) {
			throw new FileNotFoundException(downFileName);
		}

		if (!file.isFile()) {
			throw new FileNotFoundException(downFileName);
		}

		int fSize = (int) file.length();
		if (fSize > 0) {
			orgFileName = getEncodedFilename(request, orgFileName);
			
			BufferedInputStream in = null;

			try {
				in = new BufferedInputStream(new FileInputStream(file));

				//String mimetype = "application/x-msdownload";
				
				String mimetype = "application/octet-stream";

				response.reset(); // test
				//response.setBufferSize(fSize);
				response.setContentType(mimetype);
				//response.setHeader("Content-Disposition:", "attachment; filename=" + orgFileName);
				response.setContentLength(fSize);
				response.setHeader("Content-Disposition", String.format("attachment; filename=%s", orgFileName));
				//response.setHeader("Content-Transfer-Encoding","binary");
				//response.setHeader("Pragma","no-cache");
				//response.setHeader("Expires","0");
				
				dumpFile(file, response);
				
				
				//FileCopyUtils.copy(in, response.getOutputStream());
			} finally {
				//EgovResourceCloseHelper.close(in);
				
				response.setContentType("application/x-msdownload");

				PrintWriter printwriter = response.getWriter();
				
				printwriter.println("<html>");
				printwriter.println("<br><br><br><h2>Could not get file name:<br>" + orignFileNm + "</h2>");
				printwriter.println("<br><br><br><center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
				printwriter.println("<br><br><br>&copy; webAccess");
				printwriter.println("</html>");
				
				printwriter.flush();
				printwriter.close();
			}
			//response.getOutputStream().flush();
			//response.getOutputStream().close();
		}
	}
	
	public static void dumpFile(File realFile, HttpServletResponse response) throws Exception{
		
		byte readByte[] = new byte[4096];
		  
		try {
			InputStream bufferedinputstream =new FileInputStream(realFile);
		    int i;
		    while ((i = bufferedinputstream.read(readByte, 0, 4096)) != -1){
		        response.getOutputStream().write(readByte, 0, i);
		    }
		    bufferedinputstream.close();
		  } catch (Exception _ex) {
		        _ex.printStackTrace();
		  }finally{
		    response.getOutputStream().flush();
		    response.getOutputStream().close();
		}
	}
	
	public static String getEncodedFilename(HttpServletRequest request, String filename) throws Exception {
		String encodedFilename = "Noname";
		String browser = getBrowser(request);
		
		if (browser.equals("MSIE")) {
		
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		
		} else if (browser.equals("Trident")) {       // IE11 문자열 깨짐 방지
		
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		
		} else if (browser.equals("Firefox")) {
		
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
			
			encodedFilename = URLDecoder.decode(encodedFilename);
		
		} else if (browser.equals("Opera")) {
		
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		
		} else if (browser.equals("Chrome")) {
		
			StringBuffer sb = new StringBuffer();
			
			for (int i = 0; i < filename.length(); i++) {
				char c = filename.charAt(i);
				
				if (c > '~') {
					sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} else {
					sb.append(c);
				}
			}
		
			encodedFilename = sb.toString();
		
		} else if (browser.equals("Safari")){
		
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1")+ "\"";
			
			encodedFilename = URLDecoder.decode(encodedFilename);
		}
		
		else {
		
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1")+ "\"";
		
		}
		
		return encodedFilename;
	}
	
    public static String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		if (header.indexOf("MSIE") > -1) {
			return "MSIE";
		} else if (header.indexOf("Trident") > -1) { // IE11 문자열 깨짐 방지
			return "Trident";
		} else if (header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if (header.indexOf("Opera") > -1) {
			return "Opera";
		}
		return "Firefox";
    }
    
    public static boolean deleteFile(String filePath) {
    	try {
	    	File file = new File(filePath);
	
			if(file.exists() == true){
				file.delete();
			}
	
			return true;
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
    	return false;
    }
    
    public static void displayImage(HttpServletResponse response, String path, String fileName) throws IOException {
        
        InputStream in = new FileInputStream(path + "\\" + fileName);
        
        IOUtils.copy(in, response.getOutputStream());
    }
}
