package it.contrader.servlets;

import it.contrader.service.WishListService;
import it.contrader.service.ProdottoService;
import it.contrader.service.Service;
import it.contrader.dto.WishListDTO;
import it.contrader.dto.ProdottoDTO;
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
		UserDTO userDTO = (UserDTO) request.getSession(false).getAttribute("user");
		String proprietario =userDTO.getUsername();
		Service<WishListDTO> service = new WishListService();
		String description;
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
				Service<ProdottoDTO> service_prodotto = new ProdottoService();
				List<ProdottoDTO> lista_prodotti = service_prodotto.getAll();
				request.setAttribute("prodotti", lista_prodotti);
				getServletContext().getRequestDispatcher("/wishlist/readwishlist.jsp").forward(request, response);
			}
			
			else {
				getServletContext().getRequestDispatcher("/wishlist/updatewishlist.jsp").forward(request,response);
				
			}
			break;
			
		case "INSERT":
			String name = request.getParameter("name").toString(); 
			if(!name.equals("")) 
			{
			description = request.getParameter("description").toString();
			dto = new WishListDTO(name, description, proprietario);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			}
			updateList(request);
			getServletContext().getRequestDispatcher("/wishlist/wishlistmanager.jsp").forward(request, response);
			break;
		case "UPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			dto  = service.read(id);
			if(dto.getProprietario().equals(proprietario)) {
			name = request.getParameter("name");
			if(!name.equals("")) {
			description = request.getParameter("description");
			dto = new WishListDTO(id, name, description);
			ans = service.update(dto);
			}
			updateList(request);
			getServletContext().getRequestDispatcher("/wishlist/wishlistmanager.jsp").forward(request, response);
			}
			else {
				ans = false;
				request.getSession().invalidate();
				getServletContext().getRequestDispatcher("/illegal_operation.jsp").forward(request, response);
			}
			
			break;
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			if(dto.getProprietario().equals(proprietario)) {
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/wishlist/wishlistmanager.jsp").forward(request, response);}
			else {
				ans = false;
				request.getSession().invalidate();
				request.setAttribute("ans", ans);
				getServletContext().getRequestDispatcher("/illegal_operation.jsp").forward(request, response);
			}
			
			
			break;
			}
		
	}
}
