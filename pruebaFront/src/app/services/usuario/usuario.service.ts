import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import{HttpClient, HttpClientModule, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private API_SERVER = 'http://localhost:8080/usuario/' ;

  constructor(
    private httpClient: HttpClient
  ) { }

  httpOptions = {
    headers: new HttpHeaders({ 
      'Access-Control-Allow-Origin':'*'
    })
  };

  public getAllUsuarios(): Observable<any>{
    debugger;
    return this.httpClient.get(this.API_SERVER,this.httpOptions);
  }
}
