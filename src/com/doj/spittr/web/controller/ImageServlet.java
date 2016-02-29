package com.doj.spittr.web.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.doj.spittr.service.DAppImgService;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
@Configuration
@ComponentScan(basePackages = "com.doj.spittr")
@Component
public class ImageServlet extends HttpServlet implements HttpRequestHandler {
	@Autowired
	private DAppImgService appImgService;
	private WebApplicationContext springContext;
	private static final long serialVersionUID = 1L;
	 @Override
	    public void init(final ServletConfig config) throws ServletException {
	        super.init(config);
	        springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
	        final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
	        System.out.println("springContext::"+springContext + "beanFactory:::"+beanFactory);
	        beanFactory.autowireBean(this);
	    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id=Long.valueOf(request.getParameter("id"));
		System.out.println("dAppImgService::"+appImgService + "id::"+ id);
		//byte img[]= appImgService.getImage((long)40);
		//response.getOutputStream().write(img);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	@Override
	public void handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
