import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AutorComponent } from './components/autor/autor';
import { CategoriaComponent } from './components/categoria/categoria';
import { ClienteComponent } from './components/cliente/cliente';
import { LibroComponent } from './components/libro/libro';

const routes: Routes = [
  { path: '', redirectTo: 'libros', pathMatch: 'full' },

  { path: 'autores', component: AutorComponent },
  { path: 'categorias', component: CategoriaComponent },
  { path: 'clientes', component: ClienteComponent },
  { path: 'libros', component: LibroComponent },

  { path: '**', redirectTo: 'libros' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
