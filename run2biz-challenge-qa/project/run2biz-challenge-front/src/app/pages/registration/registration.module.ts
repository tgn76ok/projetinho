import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegistrationComponent } from './registration.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [RegistrationComponent],
  imports: [CommonModule, HttpClientModule, FormsModule, ReactiveFormsModule],
  exports: [RegistrationComponent],
  providers: [HttpClientModule]
})
export class RegistrationModule {}
