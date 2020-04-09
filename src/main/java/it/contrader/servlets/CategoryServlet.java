package it.contrader.servlets;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.CategoryDTO;
import it.contrader.service.Service;
import it.contrader.service.CategoryService;
import it.contrader.dto.UserDTO;

public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CategoryServlet() {
  }
	
	public void updateList(HttpServletRequest request) {
		Service<CategoryDTO> service = new CategoryService();
		List<CategoryDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<CategoryDTO> service = new CategoryService();
		String mode = request.getParameter("mode");
		CategoryDTO dto;
		int id;
		boolean ans;
		
		switch (mode.toUpperCase()) {
		
		case "CATEGORYLIST":
		updateList(request);
		getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
		break;
		
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
		    dto = service.read(id);
		    request.setAttribute("dto", dto);
		    
		    if(request.getParameter("update") == null ) {
		    	getServletContext().getRequestDispatcher("/category/readcategory.jsp").forward(request, response);
		    }
		    else getServletContext().getRequestDispatcher("/category/updatecategory.jsp").forward(request, response);
		    break;
		    
		case "INSERT":
			UserDTO userDTO = (UserDTO) request.getSession(false).getAttribute("user");
			String name = request.getParameter("name").toString();
			String description = request.getParameter("description").toString();
			int rating = Integer.parseInt(request.getParameter("rating").toString());
		    String proprietario_c = userDTO.getUsername();
			dto = new CategoryDTO (name, description, rating, proprietario_c);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			description = request.getParameter("description");
			rating = Integer.parseInt(request.getParameter("rating"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new CategoryDTO (id, name, description, rating);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
			break;
		}
	}
	
}
	