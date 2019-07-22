import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../service/authentication.service';
import { User } from '../model/user.model';
import { Router, ActivatedRoute } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService,private user:User,private route: ActivatedRoute, private router: Router){
  }

  logIn(): void {
    alert("login");
  //   this.authenticationService.isAuthenticated(this.user).subscribe(
  //     data => {
  //       if(data)
  //       this.router.navigate(['/home']);
  //     },
  //     error => {
  //       console.error("Error in Authenticating User!");
  //       return Observable.throw(error);
  //     }
  //  );
    }
  ngOnInit():  void {
  }

}
