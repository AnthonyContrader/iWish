import { Component, OnInit } from '@angular/core';
import { ProgressService } from 'src/service/progress.service';
import { ProgressDTO } from 'src/dto/progressdto';

@Component({
  selector: 'app-progress',
  templateUrl: './progress.component.html',
  styleUrls: ['./progress.component.css']
})
export class ProgressComponent implements OnInit {

   progressi: ProgressDTO[];
   progressinsert: ProgressDTO = new ProgressDTO();

  constructor(private service: ProgressService) { }

  ngOnInit() {
    this.getProgress();
  }
 
  getProgress(){
    this.service.getAll().subscribe (progress=>this.progressi=progress);
  }

  delete (progress: ProgressDTO){
  this.service.delete(progress.id).subscribe(()=>this.getProgress());

  }
  update(progress: ProgressDTO) {
    this.service.update(progress).subscribe(() => this.getProgress());
  }

  insert (progress: ProgressDTO){
    this.service.insert(progress).subscribe(() => this.getProgress());
  }

  clear(){
    this.progressinsert= new ProgressDTO();
  }

}


