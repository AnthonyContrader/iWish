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
		UserDTO userDTO = (UserDTO) request.getSession(false).getAttribute("user");
		String proprietario_c = userDTO.getUsername();
		Service<CategoryDTO> service = new CategoryService();
		String mode = request.getParameter("mode");
		CategoryDTO dto;
		String name, description;
		int rating;
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
			try {
			name = request.getParameter("name").toString();
			if (!name.equals("")) {
				
			description = request.getParameter("description").toString();
			rating = Integer.parseInt(request.getParameter("rating").toString());
		    dto = new CategoryDTO (name, description, rating, proprietario_c);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
		} } catch (Exception e) {}  
			updateList(request);
		    getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			
			name = request.getParameter("name");
			description = request.getParameter("description");
			rating = Integer.parseInt(request.getParameter("rating"));
			id = Integer.parseInt(request.getParameter("id"));
			dto  = service.read(id);
			if(dto.getProprietario_c().equals(proprietario_c)) {
			dto = new CategoryDTO (id, name, description, rating);
			ans = service.update(dto);
			} else {
				ans = false;
			}
			updateList(request);
			getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			if(dto.getProprietario_c().equals(proprietario_c)) {
			ans = service.delete(id);
			} else {
				ans = false;
			}
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
			break;
		}
	}
	
}
	