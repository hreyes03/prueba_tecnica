import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import{HttpClient, HttpClientModule} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ArticuloService {

  private API_SERVER = 'http://localhost:8080/articulo/' ;

  constructor(
    private httpClient: HttpClient
  ) { }

  public getAllArticulos(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }
}
