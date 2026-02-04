import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Categoria } from '../models/categoria.model';
import { API_BASE_URL } from '../shared/api';

@Injectable({ providedIn: 'root' })
export class CategoriaService {
  private readonly url = `${API_BASE_URL}/categorias`;

  constructor(private http: HttpClient) {}

  findAll(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(this.url);
  }

  findOne(id: number): Observable<Categoria> {
    return this.http.get<Categoria>(`${this.url}/${id}`);
  }

  create(categoria: Categoria): Observable<Categoria> {
    return this.http.post<Categoria>(this.url, categoria);
  }

  update(id: number, categoria: Categoria): Observable<Categoria> {
    return this.http.put<Categoria>(`${this.url}/${id}`, categoria);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
