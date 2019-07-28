import { Component, OnInit } from '@angular/core';
import { GipherService} from '../service/gipher.service';
import { Gipher } from '../model/gipher.model';

@Component({
  selector: 'app-gipher-view',
  templateUrl: './gipher-view.component.html',
  styleUrls: ['./gipher-view.component.css']
})
export class GipherViewComponent implements OnInit {

  giphers : Array<Gipher>;

  constructor(private gipherService: GipherService) { }

  getSantizeUrl(url:string){
    return this.gipherService.getSantizeUrl(url);
  }

  bookmarkGipher(gipher:Gipher){
    gipher.bookMarkedBy = gipher.userId; 
    this.gipherService.updateGipher(gipher).subscribe(data => {
      this.updateExistingGiphers(data);
    },err =>{
      console.log("bookmarkGipher: "+err);
    });
  }

  favouriteGipher(gipher:Gipher){
    gipher.favouritedBy = gipher.userId;
    this.gipherService.updateGipher(gipher).subscribe(data =>{
      this.updateExistingGiphers(data);
    },err=>{
      console.log("favouriteGipher: "+err);
    });
  }

  updateExistingGiphers(gipher:Gipher){
    for(var i=0;i<this.giphers.length;i++){
      if(gipher.gipherId == this.giphers[i].gipherId){
        this.giphers[i]=gipher;
        break;
      }
    }
  }

  printGipher(gipher : Gipher){
    console.log("gipherId: "+gipher.gipherId);
    console.log("userId: "+gipher.userId);
    console.log("embedURL: "+gipher.embedURL);
    console.log("bookMarkedBy: "+gipher.bookMarkedBy);
    console.log("favouritedBy: "+gipher.favouritedBy);
  }

  ngOnInit() {
    this.gipherService.fetchGiphers(localStorage.getItem('query')).subscribe(
      data => {
      this.giphers=data;
    }, err => {
      console.log(err);
    });
  }

}
