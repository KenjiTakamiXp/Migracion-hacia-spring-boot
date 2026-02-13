import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AutorService } from '../../services/autor.service';

@Component({
  selector: 'app-autor-form',
  templateUrl: './autor-form.component.html',
  styleUrls: ['./autor-form.component.css'],
  standalone: false
})
export class AutorFormComponent implements OnInit {
  id: number | null = null;
  cargando = false;
  error: string | null = null;

  form = this.fb.group({
    nombre: ['', [Validators.required]],
    apellido: ['', [Validators.required]],
    pais: [''],
    direccion: [''],
    telefono: [''],
    correo: ['', [Validators.email]]
  });

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private autorService: AutorService
  ) {}

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    this.id = idParam ? Number(idParam) : null;

    if (this.id) {
      this.cargando = true;
      this.autorService.findOne(this.id).subscribe({
        next: (autor) => {
          this.form.patchValue({
            nombre: autor.nombre,
            apellido: autor.apellido,
            pais: autor.pais,
            direccion: autor.direccion,
            telefono: autor.telefono,
            correo: autor.correo
          });
          this.cargando = false;
        },
        error: () => {
          this.error = 'No se pudo cargar el autor.';
          this.cargando = false;
        }
      });
    }
  }

  get titulo(): string {
    return this.id ? 'Editar autor' : 'Nuevo autor';
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
      ? this.autorService.update(this.id, payload)
      : this.autorService.create(payload);

    req.subscribe({
      next: () => {
        this.cargando = false;
        this.router.navigate(['/autores']);
      },
      error: () => {
        this.error = 'No se pudo guardar el autor.';
        this.cargando = false;
      }
    });
  }

  cancelar(): void {
    this.router.navigate(['/autores']);
  }
}
