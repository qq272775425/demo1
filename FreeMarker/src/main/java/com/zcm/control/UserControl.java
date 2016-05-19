package com.zcm.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@WebServlet(name="user",urlPatterns={"*.do"})
public class UserControl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserControl() {

		super();
	}
	private Configuration cfg;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		cfg=new Configuration();
		cfg.setServletContextForTemplateLoading(this.getServletContext(), "WEB-INF/templates");
		
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String path=request.getRequestURI();
			System.out.println(path);
			int fmPathLast=path.lastIndexOf(".do");
			int fmPathFirst=path.lastIndexOf("/");
			String fmPath=path.substring(fmPathFirst+1, fmPathLast);
			System.out.println(fmPath);
			Map map=new HashMap();
			map.put("user", "Clay");
			map.put("ok", "80");
			map.put("score", "95");
			Template t=cfg.getTemplate(fmPath+".ftl");
			response.setContentType("text/html");
     		response.setCharacterEncoding(t.getEncoding());
			PrintWriter out=response.getWriter();
		try {
			t.process(map, out);
			} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
