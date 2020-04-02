package it.contrader.Prodotto;

import it.contrader.controller.Request;

import it.contrader.dto.ProdottoDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ProdottoReadView extends AbstractView {
	
	private int id;
	private Request request;
	private final String mode = "READ";
	
	public ProdottoReadView() {
		}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			ProdottoDTO prodotto = (ProdottoDTO) request.get("prodotto");
			System.out.println(prodotto);
			MainDispatcher.getInstance().callView("Prodotta", null);
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del prodotto:");
		id = Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Prodotto", "doControl", request);
	}
	
}
