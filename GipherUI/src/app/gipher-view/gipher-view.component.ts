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
    console.log("gipherId "+gipher.gipherId);
      console.log("embedURL "+gipher.embedURL);
      console.log("bookMarkedBy "+gipher.bookMarkedBy);
      console.log("favouritedBy "+gipher.favouritedBy);
      console.log("userId "+gipher.userId);
    this.gipherService.updateGipher(gipher).subscribe(data => {
      console.log("gipherId1 "+data.gipherId);
      console.log("embedURL1 "+data.embedURL);
      console.log("bookMarkedBy1 "+data.bookMarkedBy);
      console.log("favouritedBy1 "+data.favouritedBy);
      console.log("userId1 "+data.userId);
    },err =>{
      console.log("bookmarkGipher error"+err);
    });
  }

  favouriteGipher(gipher:Gipher){
    gipher.favouritedBy = gipher.userId;
    this.gipherService.updateGipher(gipher).subscribe(data =>{
      console.log("FAV SUCESSS");
    },err=>{
      console.log("FAV ERROR");
    });
  }

  ngOnInit() {
    console.log("gipher view ngOnInit"+localStorage.getItem('query'));
    this.gipherService.fetchGiphersFromServer(localStorage.getItem('query')).subscribe(
      data => {
      this.giphers=data;
    }, err => {
      console.log(err);
    });
  }

}
