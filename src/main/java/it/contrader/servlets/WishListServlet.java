package it.contrader.servlets;

import it.contrader.service.WishListService;
import it.contrader.service.Service;
import it.contrader.dto.WishListDTO;
import it.contrader.dto.UserDTO;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class WishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public WishListServlet() {}
	
	public void updateList(HttpServletRequest request) {
		Service<WishListDTO> service = new WishListService();
		List<WishListDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<WishListDTO> service = new WishListService();
		String mode = request.getParameter("mode");
		WishListDTO dto;
		int id;
		boolean ans;
		switch(mode.toUpperCase()) {
		case "WISHLISTS":
			updateList(request);
			getServletContext().getRequestDispatcher("/wishlist/wishlistmanager.jsp").forward(request, response);
			break;
		
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if(request.getParameter("update")==null) {
				getServletContext().getRequestDispatcher("/wishlist/readwishlist.jsp").forward(request, response);
			}
			
			else {
				getServletContext().getRequestDispatcher("/wishlist/updatewishlist.jsp").forward(request,response);
				
			}
			break;
			
		case "INSERT":
			UserDTO userDTO = (UserDTO) request.getSession(false).getAttribute("user");
			String name = request.getParameter("name").toString(); 
			String description = request.getParameter("description").toString();
			String proprietario =userDTO.getUsername();
			dto = new WishListDTO(name, description, proprietario);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/wishlist/wishlistmanager.jsp").forward(request, response);
			break;
		case "UPDATE":
			name = request.getParameter("name");
			description = request.getParameter("description");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new WishListDTO(id, name, description);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/wishlist/wishlistmanager.jsp").forward(request, response);
			break;
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/wishlist/wishlistmanager.jsp").forward(request, response);
			break;
			}
		
	}
}
