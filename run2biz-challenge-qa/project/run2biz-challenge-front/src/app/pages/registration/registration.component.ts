import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
import { showError, Error } from 'src/app/utils/errors';
import { formatCpf } from 'src/app/utils/string';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
})
export class RegistrationComponent implements OnInit {
  form = this.fb.group({
    name: ['', [Validators.required, Validators.pattern('[a-zA-Z ]*')]],
    cpf: ['', [Validators.required]],
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(8)]],
  });
  loading = false;

  get invalidForm() {
    return this.form.invalid;
  }

  get nameInputError() {
    return this.form.controls.name.errors && this.form.controls.name.touched;
  }

  get cpfInputError() {
    return this.form.controls.cpf.errors && this.form.controls.cpf.touched;
  }

  get emailInputError() {
    return this.form.controls.email.errors && this.form.controls.email.touched;
  }

  get passwordInputError() {
    return (
      this.form.controls.password.errors && this.form.controls.password.touched
    );
  }

  constructor(
    private fb: FormBuilder,
    private api: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  onSubmit() {
    this.loading = true;
    const data = {
      ...this.form.value,
      cpf: this.form.value.cpf.replace(/[.-]/g, ''),
    };
    this.api.createUser(data).subscribe(
      () => {
        alert('Usuário cadastrado com sucesso! Faça seu login');
        this.form.reset();
        this.loading = false;
        this.goToLogin();
      },
      (err) => {
        this.loading = false;

        const errors = err.error.errors as Error[];
        showError(errors);
      }
    );
  }

  format(event: Event) {
    formatCpf(event);
  }

  goToLogin() {
    this.router.navigate(['']);
  }
}
