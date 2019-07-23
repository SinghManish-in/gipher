import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  submitMessage: String = '';
  submitSuccessMessage: String = '';
  submitted: Boolean = false;

  constructor(private authenticationService: AuthenticationService) { }

  RegisterForm = new FormGroup({
    userId: new FormControl('', [Validators.required]),
    userPassword: new FormControl('', [Validators.required, Validators.minLength(4)]),
    firstName: new FormControl('', [Validators.required]),
    lastName: new FormControl('', [Validators.required]),
    userRole: new FormControl('', [Validators.required])
  });

  register() {
    this.submitted = true;
    console.log(this.RegisterForm.value);
    this.authenticationService.registerUser(this.RegisterForm.value).subscribe(
      data => {
        this.submitMessage = "User is registered sucessfully";
      }, err => {
        if (err.status === 403) {
          this.submitMessage = err.error.message;
        } else if (err.status === 404) {
          this.submitMessage = err.message;
        }
      }
    );

  }
  ngOnInit() {
  }

}
