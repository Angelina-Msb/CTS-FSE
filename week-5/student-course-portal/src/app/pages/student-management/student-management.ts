import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SharedStateService } from '../../services/shared-state';
import { FilterPipe } from '../../pipes/filter-pipe';

@Component({
  selector: 'app-student-management',
  standalone: true,
  imports: [CommonModule, FormsModule, FilterPipe],
  templateUrl: './student-management.html',
  styleUrl: './student-management.css'
})
export class StudentManagementComponent implements OnInit {
  students: any[] = [];
  searchTerm: string = '';

  constructor(private sharedState: SharedStateService) {}

  ngOnInit(): void {
    this.sharedState.registeredStudents$.subscribe(data => {
      this.students = data;
    });
  }
}