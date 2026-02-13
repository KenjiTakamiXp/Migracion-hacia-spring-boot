import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  template: `
    <div class="p-4 bg-light rounded-3">
      <h1 class="h3">Librería</h1>
      <p class="mb-0">Selecciona una opción en el menú para administrar datos.</p>
    </div>
  `,
  standalone: false,
})
export class HomeComponent {}
