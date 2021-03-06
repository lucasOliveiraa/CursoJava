package br.com.javaweb.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
								
		HttpServletRequest req = (HttpServletRequest) request;
		
		
		HttpServletResponse resp = (HttpServletResponse) response;
		
		Cookie cookie = getUsuario(req);
		String usuario = "<deslogado>";
		
		if(cookie != null){
			cookie.setMaxAge(60*10); //aqui aumentamos o tempo de vida do cookie
			resp.addCookie(cookie);
			usuario = cookie.getValue();
		}
		
		
		System.out.println("Usuario " + usuario + " acessando a URI " + req.getRequestURI());
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	private Cookie getUsuario(HttpServletRequest req){
		
		Cookie[] cookies = req.getCookies();
		
		if(cookies == null){
			return null;
		}
		
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("usuario.logado")){
				return cookie;
			}
		}			
		return null;		
	}
	
	

	
}
