package it.contrader.servlets;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.ProdottoDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
import it.contrader.service.ProdottoService;

public class ProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ProdottoServlet() {
}
	
	public void updateList(HttpServletRequest request) {
		Service<ProdottoDTO> service = new ProdottoService();
		List<ProdottoDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ProdottoDTO> service = new ProdottoService();
		String mode = request.getParameter("mode");
		ProdottoDTO dto;
		int id;
		boolean ans;
		
		switch (mode.toUpperCase()) {
		
		case "PRODOTTOLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/prodotto/prodottomanager.jsp").forward(request, response);
			break;
			
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/prodotto/readprodotto.jsp").forward(request, response);
			}
			
			else { getServletContext().getRequestDispatcher("/prodotto/updateprodotto.jsp").forward(request, response);
		}
		    break;
			
		case "INSERT":
			UserDTO userDTO = (UserDTO) request.getSession(false).getAttribute("user");
			String name = request.getParameter("name").toString();
			String description = request.getParameter("description").toString();
			String proprietario = userDTO.getUsername();
			float price = Float.parseFloat(request.getParameter("price").toString());
			int priority = Integer.parseInt(request.getParameter("priority").toString());
			dto = new ProdottoDTO (name,description,price,priority, proprietario);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/prodotto/prodottomanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			description = request.getParameter("description");
			price = Float.parseFloat(request.getParameter("price"));
			priority = Integer.parseInt(request.getParameter("priority"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new ProdottoDTO (id, name, description, price, priority);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/prodotto/prodottomanager.jsp").forward(request, response);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/prodotto/prodottomanager.jsp").forward(request, response);
			break;
		}
	}

}
