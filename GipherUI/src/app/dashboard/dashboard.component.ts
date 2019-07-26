import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { Gipher } from '../model/gipher.model';
import { GipherService } from '../service/gipher.service';
import { RouterService } from '../service/router.service';
import { Validators } from '@angular/forms';
import { DomSanitizer, SafeResourceUrl, SafeUrl} from '@angular/platform-browser';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  value : string
  submitMessage: String = '';
  submitted : Boolean = false;
  giphers: Array<Gipher>;
  safe : SafeResourceUrl;
  constructor(private gipherService: GipherService, private routerService: RouterService,private sanitizer: DomSanitizer) {}

  searchForm = new FormGroup ({
    query : new FormControl('', [Validators.required])
  });

  showBookmark(gipherId:string){
    //this.routerService.routeToBookmarkView();
    console.log(gipherId);
  }

  showFavorite(event: Event){
    this.routerService.routeToFavouriteView();
  }
  getSantizeUrl(url:string){
    console.log(url);
    return this.sanitizer.bypassSecurityTrustResourceUrl(url);
  }
  searchSubmit() {
    this.submitted = true;
    const query = this.searchForm.value.query;
    this.gipherService.fetchGiphersFromServer(query).subscribe(
      data => {
      console.log(data+"-----"+this.safe);
      this.giphers=data;
      //this.giphers=this.getSafeData(data);
      //this.routerService.routeToGipherView();
    }, err => {
      console.log(err);
    });
  }

  searchhashaserror() {
    return this.query.hasError('required') ? true : false;
  }
  
  get query() {
    return this.searchForm.get('query');
  }

  set query(query) {
    this.query.setValue(query);
  }

  get lf() {
    return this.searchForm.controls;
  }
  ngOnInit() {
    this.value = "";
  }

}
