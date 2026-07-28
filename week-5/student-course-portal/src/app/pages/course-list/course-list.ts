import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCardComponent } from '../../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCardComponent],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseListComponent implements OnInit {
  isLoading = true;
  selectedCourseId: number | null = null;

  courses = [
    { id: 101, name: 'Angular Fundamentals', code: 'CS101', credits: 3, gradeStatus: 'passed' as const },
    { id: 102, name: 'Data Structures & Algorithms', code: 'CS102', credits: 4, gradeStatus: 'passed' as const },
    { id: 103, name: 'Web Development Basics', code: 'CS103', credits: 3, gradeStatus: 'pending' as const },
    { id: 104, name: 'Database Management Systems', code: 'CS104', credits: 4, gradeStatus: 'failed' as const },
    { id: 105, name: 'Software Engineering Principles', code: 'CS105', credits: 3, gradeStatus: 'pending' as const }
  ];

  constructor(private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    setTimeout(() => {
      this.isLoading = false;
      console.log('Loading finished, isLoading set to false.');
      this.cdr.detectChanges(); // <--- This forces the UI to update right away
    }, 1500);
  }

  trackByCourseId(index: number, course: any): number {
    return course.id;
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }
}