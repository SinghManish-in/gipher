import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { Gipher } from '../model/gipher.model';
import { GipherService } from '../service/gipher.service';
import { RouterService } from '../service/router.service';
import { Validators } from '@angular/forms';



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
  constructor(private gipherService: GipherService, private routerService: RouterService) {}

  searchForm = new FormGroup ({
    query : new FormControl('', [Validators.required])
  });
  
  
  searchSubmit() {
    this.submitted = true;
    localStorage.setItem('query', this.searchForm.value.query);
    location.reload();
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
