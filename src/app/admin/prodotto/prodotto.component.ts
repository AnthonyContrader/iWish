import { Component, OnInit, wtfLeave, ElementRef, ViewChild } from '@angular/core';
import { ProdottoService } from 'src/service/prodotto.service';
import { ProdottoDTO } from 'src/dto/prodottodto';
import { UserDTO } from 'src/dto/userdto';
import { WishListDTO } from 'src/dto/wishlistdto';
import { CategoryDTO } from 'src/dto/categorydto';
import { WishListService } from 'src/service/wishlist.service';
import { CategoryService } from 'src/service/category.service';

@Component({
  selector: 'app-prodotto',
  templateUrl: './prodotto.component.html',
  styleUrls: ['./prodotto.component.css']
})
export class ProdottoComponent implements OnInit {

  prodotti: ProdottoDTO[];
  prodottotoinsert: ProdottoDTO = new ProdottoDTO();
  me: UserDTO;
  wishlist: WishListDTO;
  category: CategoryDTO;
  wishlists: WishListDTO[]=[];
  categories: CategoryDTO[]=[];
  class: string = "list-group-item";
  selectedFile: string = '';
  @ViewChild('inputFile')
   inputFile: ElementRef;

  constructor(private service: ProdottoService, private wishlistservice: WishListService, private categoryservice: CategoryService) { }

  ngOnInit() {
    this.getProdotto();
    this.me = JSON.parse(localStorage.getItem('currentUser'));
    this.getwishlists();
    this.getcategories();
  }

  getProdotto() {
    this.service.getAll().subscribe(prodotti => this.prodotti = prodotti);
  }

  getwishlists() {
    this.wishlistservice.getAll().subscribe(wish_lists => 
      {
       this.wishlists =[];
        for (let w of wish_lists){
          if (w.proprietario_id===this.me.id)
          {
            
            this.wishlists.push(new WishListDTO(w.id, w.name));
          
          }
        }
      }
    );
    
  }

  getcategories() {
    this.categoryservice.getAll().subscribe(categories => 
      {
        this.categories = [];
        for (let c of categories){
          if (c.proprietario_c.username===this.me.username)
          {this.categories.push(new CategoryDTO(c.id, c.name));}
        }
      }
    );
    
  }

  delete(prodotto: ProdottoDTO) {
    this.service.delete(prodotto.id).subscribe(() => this.getProdotto());
  }

  update(prodotto: ProdottoDTO) {
    
    this.service.update(prodotto).subscribe(() => this.getProdotto());
  }

  insert(prodotto: ProdottoDTO) {
    prodotto.proprietario_id=this.me.id;
    
    prodotto.image = this.selectedFile;
    this.selectedFile ='';//IMPORTANTE!!!
    this.inputFile.nativeElement.value='';
    this.service.insert(prodotto).subscribe(() => this.getProdotto());
    this.clear();
    
  }

  clear() {
    this.prodottotoinsert = new ProdottoDTO();
  }

  compareFn(c1: CategoryDTO, c2: CategoryDTO): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
}

compareWishLists(w1: WishListDTO, w2: WishListDTO){
  return w1 && w2 ? w1.id === w2.id: w1===w2;
}

handleInputChange(e) {
  var file = e.dataTransfer ? e.dataTransfer.files[0] : e.target.files[0];
  var pattern = /image-*/;
  var reader = new FileReader();
  if (!file.type.match(pattern)) {
    alert('invalid format');
    return;
  }
  reader.onload = this._handleReaderLoaded.bind(this);
  reader.readAsDataURL(file);
}
_handleReaderLoaded(e) {
  let reader = e.target;
  this.selectedFile = reader.result;
  console.log(this.selectedFile)
}
 

}

