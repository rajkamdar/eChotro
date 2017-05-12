package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.dao.UtilityDAO;
@WebFilter({ "/UtilityFilter", "/index.jsp" })
public class UtilityFilter implements Filter {

	
    public UtilityFilter() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter called()");
		UtilityDAO utilityDAO=new  UtilityDAO();
		utilityDAO.incrementCount();
		utilityDAO=null;
		chain.doFilter(request, response);
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
