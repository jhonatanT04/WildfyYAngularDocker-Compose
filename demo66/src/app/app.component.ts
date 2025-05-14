import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PersonaService } from './persona.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,FormsModule,CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'demo66';
  personas: any[] = [];
  nuevaPersona = { nombre:  '', edad: 0};

  constructor(private personaService: PersonaService) {}

  ngOnInit(): void {
    this.cargarPersonas();
  }

  cargarPersonas(): void {
    this.personaService.listarPersonas().subscribe(data => {
      this.personas = data;
    });
  }

  agregarPersona(): void {
    if (this.nuevaPersona.nombre) {
      this.personaService.agregarPersona(this.nuevaPersona).subscribe(() => {
        this.cargarPersonas(); 
        this.nuevaPersona = { nombre: '', edad: 0}; 
      });
    }
  }
}
