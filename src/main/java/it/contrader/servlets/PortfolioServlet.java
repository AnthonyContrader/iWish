package it.contrader.servlets;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.PortfolioDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
import it.contrader.service.PortfolioService;

public class PortfolioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PortfolioServlet() {
	}
	public void updateList(HttpServletRequest request) {
		Service<PortfolioDTO> service = new PortfolioService();
		List<PortfolioDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDTO userDTO = (UserDTO) request.getSession(false).getAttribute("user");
		String proprietario = userDTO.getUsername();
		Service<PortfolioDTO> service = new PortfolioService();
		String mode = request.getParameter("mode");
		PortfolioDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {
		
		case "PORTFOLIOLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/Portfolio/Portfoliomanager.jsp").forward(request, response);
			break;
			
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
		if (request.getParameter("update") == null) {
			getServletContext().getRequestDispatcher("/Portfolio/readPortfolio.jsp").forward(request, response);
				
		}
		
		else getServletContext().getRequestDispatcher("/Portfolio/updatePortfolio.jsp").forward(request, response);
		
		break;

		case "INSERT":
			float totalmoney = Float.parseFloat(request.getParameter("totalmoney").toString());
			float revenue = Float.parseFloat(request.getParameter("revenue").toString());
			float outputs = Float.parseFloat(request.getParameter("outputs").toString());
			
			
			dto = new PortfolioDTO (totalmoney,revenue,outputs, proprietario);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/Portfolio/Portfoliomanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
		    id = Integer.parseInt(request.getParameter("id"));
		    dto = service.read(id);
		    if(dto.getProprietario().equals(proprietario)) {
			totalmoney = Float.parseFloat(request.getParameter("totalmoney").toString());
			revenue = Float.parseFloat(request.getParameter("revenue").toString());
			outputs = Float.parseFloat(request.getParameter("outputs").toString());
			
			dto = new PortfolioDTO (id,totalmoney, revenue, outputs);
			ans = service.update(dto);
		    }
		    else {
		    	ans = false;
		    }
			updateList(request);
			getServletContext().getRequestDispatcher("/Portfolio/Portfoliomanager.jsp").forward(request, response);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			if(dto.getProprietario().equals(proprietario)) {
			ans = service.delete(id);}
			else {
				ans = false;
			}
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/Portfolio/Portfoliomanager.jsp").forward(request, response);
			break;
		}
	}
}


