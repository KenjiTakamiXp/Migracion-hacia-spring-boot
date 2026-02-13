import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteListComponent } from './pages/cliente/cliente-list.component';
import { ClienteFormComponent } from './pages/cliente/cliente-form.component';
import { AutorListComponent } from './pages/autor/autor-list.component';
import { AutorFormComponent } from './pages/autor/autor-form.component';
import { CategoriaListComponent } from './pages/categoria/categoria-list.component';
import { CategoriaFormComponent } from './pages/categoria/categoria-form.component';

const routes: Routes = [
  { path: '', redirectTo: 'clientes', pathMatch: 'full' },

  { path: 'clientes', component: ClienteListComponent },
  { path: 'clientes/nuevo', component: ClienteFormComponent },
  { path: 'clientes/editar/:id', component: ClienteFormComponent },

  { path: 'autores', component: AutorListComponent },
  { path: 'autores/nuevo', component: AutorFormComponent },
  { path: 'autores/editar/:id', component: AutorFormComponent },

  { path: 'categorias', component: CategoriaListComponent },
  { path: 'categorias/nuevo', component: CategoriaFormComponent },
  { path: 'categorias/editar/:id', component: CategoriaFormComponent },

  { path: '**', redirectTo: 'clientes' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
