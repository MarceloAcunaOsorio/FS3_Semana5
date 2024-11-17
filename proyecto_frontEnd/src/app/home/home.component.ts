import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { CabeceraComponent } from '../cabecera/cabecera.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule,CabeceraComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
