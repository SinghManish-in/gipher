import { Injectable } from '@angular/core';
import { Gipher } from '../model/gipher.model';
import { AuthenticationService } from './authentication.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable()
export class GipherService {
    
    giphers: Array<Gipher>;
    gipherSubject: BehaviorSubject<Array<Gipher>>;
    
    constructor(private authService: AuthenticationService, private httpClient: HttpClient) {
        this.giphers = [];
        this.gipherSubject = new BehaviorSubject(this.giphers);
    }
    
    fetchGiphersFromServer(query) {
        const token = this.authService.getBearerToken();
        const headerValue = 'Bearer ' + token;
        console.log(headerValue);
        return this.httpClient.get<Array<Gipher>>(`http://localhost:8088/api/v1/gipher/externalapi/${this.authService.getUserId()}/${query}`, {
            headers: new HttpHeaders().set('Authorization', headerValue)
        })
    }
}
