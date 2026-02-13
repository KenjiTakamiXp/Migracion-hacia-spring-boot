import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Autor } from '../../models/autor.model';
import { AutorService } from '../../services/autor.service';

@Component({
  selector: 'app-autor-list',
  templateUrl: './autor-list.component.html',
  styleUrls: ['./autor-list.component.css'],
  standalone: false
})
export class AutorListComponent implements OnInit {
  autores: Autor[] = [];
  cargando = false;
  error: string | null = null;

  constructor(private autorService: AutorService, private router: Router) {}

  ngOnInit(): void {
    this.cargar();
  }

  cargar(): void {
    this.cargando = true;
    this.error = null;
    this.autorService.findAll().subscribe({
      next: (data) => {
        this.autores = data;
        this.cargando = false;
      },
      error: () => {
        this.error = 'No se pudo cargar la lista de autores.';
        this.cargando = false;
      }
    });
  }

  nuevo(): void {
    this.router.navigate(['/autores/nuevo']);
  }

  editar(id?: number): void {
    if (!id) return;
    this.router.navigate(['/autores/editar', id]);
  }

  eliminar(id?: number): void {
    if (!id) return;
    if (!confirm('¿Seguro que deseas eliminar este autor?')) return;

    this.autorService.delete(id).subscribe({
      next: () => this.cargar(),
      error: () => alert('No se pudo eliminar el autor.')
    });
  }
}
