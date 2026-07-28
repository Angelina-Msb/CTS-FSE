import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { CourseService } from '../../services/course';

@Component({
  selector: 'app-course-api-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './course-api-list.html',
  styleUrl: './course-api-list.css'
})
export class CourseApiListComponent implements OnInit {
  apiData: any[] = [];
  loading = true;
  errorMessage: string | null = null; // <--- Add this property

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    this.courseService.getCourses().subscribe({
      next: (data) => {
        this.apiData = data;
        this.loading = false;
      },
      error: (err) => {
        this.errorMessage = 'Failed to load courses from the server.';
        this.loading = false;
        console.error(err);
      }
    });
  }
}