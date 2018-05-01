import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { config, environment } from '../../environments/environment';

@Injectable()
export class ApiService {
    public apiUrl;

    constructor(private http: HttpClient, private rou: Router) {
        if (environment.production) {
            this.apiUrl = (!config.apiUrl.startsWith(location.origin) ? location.origin : '') + config.apiUrl;
        }
        else {
            this.apiUrl = config.apiUrl;
        }
    }

    private getToken(): string {
        let t = localStorage.getItem("CURRENT_TOKEN");
        let json = JSON.parse(t);

        if (json === null) {
            t = "";
            this.rou.navigate(['/']);
        } else {
            t = "Bearer " + json.token;
        }

        return t;
    }
}