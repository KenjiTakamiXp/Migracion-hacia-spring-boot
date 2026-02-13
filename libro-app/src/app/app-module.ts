import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';

import { ClienteListComponent } from './pages/cliente/cliente-list.component';
import { ClienteFormComponent } from './pages/cliente/cliente-form.component';
import { AutorListComponent } from './pages/autor/autor-list.component';
import { AutorFormComponent } from './pages/autor/autor-form.component';
import { CategoriaListComponent } from './pages/categoria/categoria-list.component';
import { CategoriaFormComponent } from './pages/categoria/categoria-form.component';

@NgModule({
  declarations: [
    App,
    ClienteListComponent,
    ClienteFormComponent,
    AutorListComponent,
    AutorFormComponent,
    CategoriaListComponent,
    CategoriaFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners()
  ],
  bootstrap: [App]
})
export class AppModule {}
