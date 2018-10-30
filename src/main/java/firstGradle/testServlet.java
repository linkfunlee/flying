package firstGradle;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="testServlet",urlPatterns={"/testServlet"})
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 7109220574468622594L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String path = getServletContext().getRealPath("/");
		System.out.println("servlet初始化..."+path);
		
		
		
		File file=new File("."); 

		String path2=file.getAbsolutePath();

		path2=file.getPath();
		
		System.out.println("servlet2初始化2..."+path2);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		System.out.println("servleddddt初始化..."+getServletContext().getRealPath("/"));
		pw.append("Hello Servlet!<br>" );
		
		//servletName
		pw.append("servletName：" + getServletName() + "<br>");
		 String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
		 pw.append("savePath ="+	savePath+"<br>" );
		
		String path = request.getServletPath();
		request.getRequestURL();
		pw.append("path ="+	path );
		
		pw.append("<br>	request.getRequestURL(); ="+	request.getRequestURL()+"<br>" );
		
		try {
			pw.append("path dddddd="+ testServlet.class.getResource("/").toURI().getPath());
			
			 String savePath1 = this.getServletContext().getRealPath("/WEB-INF/tst");
			                  File file = new File(savePath);
		                 //判断上传文件的保存目录是否存在
	                if (!file.exists() && !file.isDirectory()) {
		                   System.out.println(savePath+"目录不存在，需要创建");
	                    //创建目录
		                    file.mkdir();
		               }
	                
	                
	                String pathsd="E:/TempOfFaceRegister/login.png";
					File file1=new File(pathsd);
					if(!file1.exists()){
						file1.mkdirs();
					}
	                
			
			
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 String path2 = request.getSession().getServletContext().getRealPath(request.getRequestURI());
		 try {
			String path3 = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
			
			pw.append("path3 ="+	path3 );
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 pw.append("path2 ="+	path2 );
		//initParam
		ServletConfig servletConfig = this.getServletConfig();
		Enumeration<String> paramNames = servletConfig.getInitParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			pw.append(paramName + "：" + servletConfig.getInitParameter(paramName) + "<br>");
		}
		String path5 = request.getSession().getServletContext().getRealPath("/WEB-INF");
		System.out.println("doPost:path:"+path5);
		pw.close();
		
	}
 
 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
