import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ClienteService } from '../../services/cliente.service';

@Component({
  selector: 'app-cliente-form',
  templateUrl: './cliente-form.component.html',
  styleUrls: ['./cliente-form.component.css'],
  standalone: false
})
export class ClienteFormComponent implements OnInit {
  id: number | null = null;
  cargando = false;
  error: string | null = null;

  form = this.fb.group({
    cedula: ['', [Validators.required]],
    nombre: ['', [Validators.required]],
    apellido: ['', [Validators.required]],
    direccion: [''],
    telefono: [''],
    correo: ['', [Validators.email]]
  });

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private clienteService: ClienteService
  ) {}

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    this.id = idParam ? Number(idParam) : null;

    if (this.id) {
      this.cargando = true;
      this.clienteService.findOne(this.id).subscribe({
        next: (cliente) => {
          this.form.patchValue({
            cedula: cliente.cedula,
            nombre: cliente.nombre,
            apellido: cliente.apellido,
            direccion: cliente.direccion,
            telefono: cliente.telefono,
            correo: cliente.correo
          });
          this.cargando = false;
        },
        error: () => {
          this.error = 'No se pudo cargar el cliente.';
          this.cargando = false;
        }
      });
    }
  }

  get titulo(): string {
    return this.id ? 'Editar cliente' : 'Nuevo cliente';
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
      ? this.clienteService.update(this.id, payload)
      : this.clienteService.create(payload);

    req.subscribe({
      next: () => {
        this.cargando = false;
        this.router.navigate(['/clientes']);
      },
      error: () => {
        this.error = 'No se pudo guardar el cliente.';
        this.cargando = false;
      }
    });
  }

  cancelar(): void {
    this.router.navigate(['/clientes']);
  }
}
