import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Autor } from '../models/autor.model';
import { API_BASE_URL } from '../shared/api';

@Injectable({ providedIn: 'root' })
export class AutorService {
  private readonly url = `${API_BASE_URL}/autores`;

  constructor(private http: HttpClient) {}

  findAll(): Observable<Autor[]> {
    return this.http.get<Autor[]>(this.url);
  }

  findOne(id: number): Observable<Autor> {
    return this.http.get<Autor>(`${this.url}/${id}`);
  }

  create(autor: Autor): Observable<Autor> {
    return this.http.post<Autor>(this.url, autor);
  }

  update(id: number, autor: Autor): Observable<Autor> {
    return this.http.put<Autor>(`${this.url}/${id}`, autor);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
