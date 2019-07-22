import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { BookmarkComponent } from './bookmark/bookmark.component';
import { FavouriteComponent } from './favourite/favourite.component';
import { User } from './model/user.model';
import { AuthenticationService } from './service/authentication.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';



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
    HttpModule,
    HttpClientModule
  ],
  providers: [User,AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
