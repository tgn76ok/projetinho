import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './pages/home';
import { RegistrationComponent } from './pages/registration';
import { MainComponent } from './pages/main'
import { AuthGuardService } from './service/auth-guard.service'

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'cadastrar', component: RegistrationComponent },
  { path: 'inicio', component: MainComponent, canActivate: [AuthGuardService] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
