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
		File currentDirPath = new File("C:\\file_repo"); //���ε��� ���� ��� ����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath); // ���� ��� ����
		factory.setSizeThreshold(1024*1024); //�ִ� ���ε� ������ ���� ũ�� ����
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			
			List items = upload.parseRequest(request); //request ��ü���� �Ű������� List�� ������
			
			for(int i=0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);
				if(fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName()+ "=" +fileItem.getString(encoding));
				}else {
					System.out.println("�Ű������̸�: " + fileItem.getFieldName());
					System.out.println("�����̸�: " +fileItem.getName());
					System.out.println("����ũ��: " +fileItem.getSize()+"bytes");
					
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
