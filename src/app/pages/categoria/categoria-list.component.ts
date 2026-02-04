import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Categoria } from '../../models/categoria.model';
import { CategoriaService } from '../../services/categoria.service';

@Component({
  selector: 'app-categoria-list',
  templateUrl: './categoria-list.component.html',
  styleUrls: ['./categoria-list.component.css'],
  standalone: false
})
export class CategoriaListComponent implements OnInit {
  categorias: Categoria[] = [];
  cargando = false;
  error: string | null = null;

  constructor(private categoriaService: CategoriaService, private router: Router) {}

  ngOnInit(): void {
    this.cargar();
  }

  cargar(): void {
    this.cargando = true;
    this.error = null;
    this.categoriaService.findAll().subscribe({
      next: (data) => {
        this.categorias = data;
        this.cargando = false;
      },
      error: () => {
        this.error = 'No se pudo cargar la lista de categorías.';
        this.cargando = false;
      }
    });
  }

  nuevo(): void {
    this.router.navigate(['/categorias/nuevo']);
  }

  editar(id?: number): void {
    if (!id) return;
    this.router.navigate(['/categorias/editar', id]);
  }

  eliminar(id?: number): void {
    if (!id) return;
    if (!confirm('¿Seguro que deseas eliminar esta categoría?')) return;

    this.categoriaService.delete(id).subscribe({
      next: () => this.cargar(),
      error: () => alert('No se pudo eliminar la categoría.')
    });
  }
}
