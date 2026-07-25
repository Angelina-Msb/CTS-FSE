import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CourseService } from '../../services/course';

@Component({
  selector: 'app-course-detail',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './course-detail.html',
  styleUrl: './course-detail.css'
})
export class CourseDetailComponent implements OnInit {
  courseId: string | null = null;
  courseDetails: any = null;
  loading = true;

  constructor(private route: ActivatedRoute, private courseService: CourseService) {}

  ngOnInit(): void {
    // Read the :id parameter from the URL
    this.courseId = this.route.snapshot.paramMap.get('id');
    
    // Fetch data and find the matching item
    this.courseService.getCourses().subscribe((data) => {
      this.courseDetails = data.find((item) => item.id.toString() === this.courseId);
      this.loading = false;
    });
  }
}