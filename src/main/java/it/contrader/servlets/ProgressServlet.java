package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.ProgressDTO;
import it.contrader.service.Service;
import it.contrader.service.ProgressService;
import it.contrader.dto.UserDTO;



public class ProgressServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	
	public ProgressServlet() {
		
	}
 
 public void updateList(HttpServletRequest request) {
	 Service <ProgressDTO> service = new ProgressService();
	 List<ProgressDTO>listDTO= service.getAll();
	 request.setAttribute("list", listDTO);
 }

 
 @Override
 public void service (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	Service<ProgressDTO> service = new ProgressService();
	String mode =request.getParameter("mode");
	ProgressDTO dto;
	int id;
	boolean ans;
	
	switch(mode.toUpperCase()) {
	
	
	case "PROGRESSLIST":
	
		updateList(request);
		
		getServletContext().getRequestDispatcher("/progress/progressmenager.jsp").forward(request, response);
		
		break;
	
	case "READ":
		id = Integer.parseInt(request.getParameter("id"));
		dto = service.read(id);
		request.setAttribute("dto",dto);
		
		if (request.getParameter("update")==null){
			getServletContext().getRequestDispatcher("/progress/readprogress.jsp").forward(request, response);
			
		}
		
		else getServletContext().getRequestDispatcher("/progress/updateprogress.jsp").forward(request, response);
	    break;
	
	case "INSERT":
		UserDTO userDTO=(UserDTO) request.getSession(false).getAttribute("user");
		float cash= Float.parseFloat(request.getParameter("cash").toString());
		double expectation=Double.parseDouble(request.getParameter("expectation").toString());
		double time= Double.parseDouble(request.getParameter("time").toString());
	    String proprietario=userDTO.getUsername();
	    int id_prodotto=Integer.parseInt(request.getParameter("prodotto_id"));
		dto=new ProgressDTO(cash,expectation,time,id_prodotto,proprietario);//da debuggare in futuro
	    ans =service.insert(dto);
	    request.setAttribute("ans", ans);
	    updateList(request);
	    getServletContext().getRequestDispatcher("/progress/progressmenager.jsp").forward(request, response);
	    break;
	    
	case "UPDATE":
		cash= Float.parseFloat(request.getParameter("cash"));
		expectation= Double.parseDouble(request.getParameter("expectation"));
		time=Double.parseDouble(request.getParameter("time"));
		id=Integer.parseInt(request.getParameter("id"));
		dto = new ProgressDTO (id,cash, expectation, time);
		ans = service.update(dto);
		
		updateList(request);
		getServletContext().getRequestDispatcher("/progress/progressmenager.jsp").forward(request, response);
		
		break;

		
	case "DELETE":
		id = Integer.parseInt(request.getParameter("id"));
		ans = service.delete(id);
		request.setAttribute("ans", ans);
		updateList(request);
		getServletContext().getRequestDispatcher("/progress/progressmenager.jsp").forward(request, response);
		
		break;
	}
	
	}
	
 }
 

