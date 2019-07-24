import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatToolbarModule } from '@angular/material/toolbar';
import { Routes, RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { BookmarkComponent } from './bookmark/bookmark.component';
import { FavouriteComponent } from './favourite/favourite.component';
import { User } from './model/user.model';
import { AuthenticationService } from './service/authentication.service';
import { RouterService } from './service/router.service';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CanActivateRouteGuard } from './can-activate-route.guard';
import { HeaderComponent } from './header/header.component';

const appRoutes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [CanActivateRouteGuard],
    children: [
      {
        path: 'dashboard/bookmarkview',
        component: BookmarkComponent
      },
      {
        path: 'dashboard/favouriteView',
        component: FavouriteComponent,
      },
    ]
  },
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path: '',
    redirectTo: '/register',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    BookmarkComponent,
    FavouriteComponent,
    DashboardComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    HttpClientModule,
    MatToolbarModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [RouterService,AuthenticationService,User,CanActivateRouteGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
