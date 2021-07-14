package sec01.ex01;


import java.io.File;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String encoding="utf-8";
		File currentDirPath = new File("C:\\file_repo"); //업로드할 파일 경로 지정
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath); // 파일 경로 설정
		factory.setSizeThreshold(1024*1024); //최대 업로드 가능한 파일 크기 설정
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			
			List items = upload.parseRequest(request); //request 객체에서 매개변수를 List로 가져옴
			
			for(int i=0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);
				if(fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName()+ "=" +fileItem.getString(encoding));
				}else {
					System.out.println("매개변수이름: " + fileItem.getFieldName());
					System.out.println("파일이름: " +fileItem.getName());
					System.out.println("파일크기: " +fileItem.getSize()+"bytes");
					
					if(fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						
						if(idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx+1);
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						fileItem.write(uploadFile);
					} // end if
				} //end if
			}//end for
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
