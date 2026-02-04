import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from '../../models/cliente.model';
import { ClienteService } from '../../services/cliente.service';

@Component({
  selector: 'app-cliente-list',
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.css'],
  standalone: false
})
export class ClienteListComponent implements OnInit {
  clientes: Cliente[] = [];
  cargando = false;
  error: string | null = null;

  constructor(private clienteService: ClienteService, private router: Router) {}

  ngOnInit(): void {
    this.cargar();
  }

  cargar(): void {
    this.cargando = true;
    this.error = null;
    this.clienteService.findAll().subscribe({
      next: (data) => {
        this.clientes = data;
        this.cargando = false;
      },
      error: () => {
        this.error = 'No se pudo cargar la lista de clientes.';
        this.cargando = false;
      }
    });
  }

  nuevo(): void {
    this.router.navigate(['/clientes/nuevo']);
  }

  editar(id?: number): void {
    if (!id) return;
    this.router.navigate(['/clientes/editar', id]);
  }

  eliminar(id?: number): void {
    if (!id) return;
    if (!confirm('¿Seguro que deseas eliminar este cliente?')) return;

    this.clienteService.delete(id).subscribe({
      next: () => this.cargar(),
      error: () => alert('No se pudo eliminar el cliente.')
    });
  }
}
