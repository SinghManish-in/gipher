import { Injectable, ComponentFactoryResolver } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';

@Injectable()
export class RouterService {

  constructor(private router: Router, private location: Location) {}

  routeToDashboard() {
    console.log("routeToDashboard");
      this.router.navigate(['dashboard']);
  }

  routeToLogin() {
    this.router.navigate(['login']);
  }

  routeToGipherView() {
    console.log("routeToGipherView");
      this.router.navigate(['dashboard/gipher']);
  }

  routeToBookmarkView() {
    console.log("routeToBookmarkView");
      this.router.navigate(['dashboard',
      {
        outlets: {
          bookmark: ['bookmark']
        }
      }])
  }

  routeToFavouriteView() {
    console.log("routeToFavouriteView");
      this.router.navigate(['dashboard',{
        outlets: {
          favourite: ['favourite']
        }
      }]);
  }

  routeBack() {
    this.location.back();
  }
}
