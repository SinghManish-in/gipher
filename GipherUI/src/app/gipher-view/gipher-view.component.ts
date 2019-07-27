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
    this.gipherService.updateGipher(gipher);
  }

  favouriteGipher(gipher:Gipher){
    gipher.favouritedBy = gipher.userId;
    this.gipherService.updateGipher(gipher);
  }

  ngOnInit() {
    console.log("ngOnInit"+localStorage.getItem('query'));
    this.gipherService.fetchGiphersFromServer(localStorage.getItem('query')).subscribe(
      data => {
      this.giphers=data;
    }, err => {
      console.log(err);
    });
  }

}
