import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';         // <--- Import pipe
import { HighlightDirective } from '../../directives/highlight';  // <--- Import directive

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, CreditLabelPipe, HighlightDirective],   // <--- Add them to imports array
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCardComponent implements OnChanges {
  @Input() course!: { id: number; name: string; code: string; credits: number; gradeStatus: 'passed' | 'failed' | 'pending' };
  @Output() enrollRequested = new EventEmitter<number>();

  isEnrolled = false;
  isExpanded = false;

  ngOnChanges(changes: SimpleChanges): void {
    console.log('Course card input changed:', changes);
  }

  get cardClasses() {
    return {
      'card--enrolled': this.isEnrolled,
      'card--full': this.course.credits >= 4,
      'expanded': this.isExpanded
    };
  }

  get borderStyle() {
    let color = 'gray';
    if (this.course.gradeStatus === 'passed') color = 'green';
    else if (this.course.gradeStatus === 'failed') color = 'red';
    else if (this.course.gradeStatus === 'pending') color = 'orange';

    return { 'border-left-color': color };
  }

  toggleEnroll(): void {
    this.isEnrolled = !this.isEnrolled;
    this.enrollRequested.emit(this.course.id);
  }

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }
}