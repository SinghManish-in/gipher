import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { BookmarkComponent } from './bookmark/bookmark.component';
import { FavouriteComponent } from './favourite/favourite.component';
import { User } from './model/user.model';
import { LoginUser } from './model/loginUser.model';
import { AuthenticationService } from './service/authentication.service';
import { RouterService } from './service/router.service';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    BookmarkComponent,
    FavouriteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    HttpClientModule
  ],
  providers: [RouterService,AuthenticationService,User,LoginUser],
  bootstrap: [AppComponent]
})
export class AppModule { }
