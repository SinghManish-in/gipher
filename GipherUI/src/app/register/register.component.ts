import { Component, OnInit } from '@angular/core';
import { User} from '../model/user.model'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private user:User) { }

  ngOnInit() {
  }

}
