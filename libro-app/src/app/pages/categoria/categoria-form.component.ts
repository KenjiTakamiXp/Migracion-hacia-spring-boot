import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoriaService } from '../../services/categoria.service';

@Component({
  selector: 'app-categoria-form',
  templateUrl: './categoria-form.component.html',
  styleUrls: ['./categoria-form.component.css'],
  standalone: false
})
export class CategoriaFormComponent implements OnInit {
  id: number | null = null;
  cargando = false;
  error: string | null = null;

  form = this.fb.group({
    categoria: ['', [Validators.required]],
    descripcion: ['']
  });

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private categoriaService: CategoriaService
  ) {}

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    this.id = idParam ? Number(idParam) : null;

    if (this.id) {
      this.cargando = true;
      this.categoriaService.findOne(this.id).subscribe({
        next: (cat) => {
          this.form.patchValue({
            categoria: cat.categoria,
            descripcion: cat.descripcion
          });
          this.cargando = false;
        },
        error: () => {
          this.error = 'No se pudo cargar la categoría.';
          this.cargando = false;
        }
      });
    }
  }

  get titulo(): string {
    return this.id ? 'Editar categoría' : 'Nueva categoría';
  }

  guardar(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    this.error = null;
    this.cargando = true;
    const payload = this.form.getRawValue();

    const req = this.id
      ? this.categoriaService.update(this.id, payload)
      : this.categoriaService.create(payload);

    req.subscribe({
      next: () => {
        this.cargando = false;
        this.router.navigate(['/categorias']);
      },
      error: () => {
        this.error = 'No se pudo guardar la categoría.';
        this.cargando = false;
      }
    });
  }

  cancelar(): void {
    this.router.navigate(['/categorias']);
  }
}
