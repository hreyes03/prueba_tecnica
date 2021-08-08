import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UsuarioService } from './services/usuario/usuario.service';
import { ArticuloService } from './services/articulo/articulo.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'pruebaFront';

  articuloForm = new FormGroup({});
  articulos: any;
  usuarios: any;

  constructor(
    public fb: FormBuilder,
    public usuarioService: UsuarioService,
    public articuloService: ArticuloService
  ) { }

  ngOnInit(): void {
    this.articuloForm = this.fb.group({
      nombre: ['', Validators.required],
      cantidad: ['', Validators.required],
      fecha: ['', Validators.required],
      usuario: ['', Validators.required],
    });

    this.usuarioService.getAllUsuarios().subscribe(resp => {
      console.log(resp);
      this.usuarios = resp;
    },
      error => { console.error(error) }
    )

    this.articuloService.getAllArticulos().subscribe(resp => {
      this.articulos = resp;
    },
      error => { console.error(error) }
    )
  }

  guardar() { }

}
