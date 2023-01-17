import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

const baseUrl = 'http://localhost:8080/api/v1';

type LoginData = Pick<User, 'email' | 'password'>;

interface User {
  email: string;
  password: string;
  name: string;
  cpf: string;
}

interface Token {
  token: string;
}

@Injectable({ providedIn: 'root' })
export class AuthService {
  constructor(private api: HttpClient) {}

  login(data: LoginData): Observable<Token> {
    return this.api
      .post<Token>(`${baseUrl}/users/auth`, data)
      .pipe(catchError(this.#handleError));
  }

  createUser(data: User) {
    return this.api
      .post(`${baseUrl}/users`, data)
      .pipe(catchError(this.#handleError));
  }

  #handleError = (res: HttpErrorResponse) => {
    return throwError(res);
  };

  getToken() {
    return localStorage.getItem('token-app');
  }

  isAuthenticated() {
    return !!this.getToken();
  }

  setToken(token: string) {
    localStorage.setItem('token-app', token);
  }
}
