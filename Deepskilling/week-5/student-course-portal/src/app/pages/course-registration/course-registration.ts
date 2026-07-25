import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators, AbstractControl, ValidationErrors } from '@angular/forms';

// Custom validator function defined right here
export function courseCodeValidator(control: AbstractControl): ValidationErrors | null {
  const value = control.value;
  if (value && !value.toUpperCase().startsWith('CS')) {
    return { invalidCourseCode: true };
  }
  return null;
}

@Component({
  selector: 'app-course-registration',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './course-registration.html',
  styleUrl: './course-registration.css'
})
export class CourseRegistrationComponent {
  registrationForm: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder) {
    this.registrationForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      courseCode: ['', [Validators.required, courseCodeValidator]],
      credits: [3, [Validators.required, Validators.min(1), Validators.max(5)]]
    });
  }

  get f() {
    return this.registrationForm.controls;
  }

  onSubmit(): void {
    if (this.registrationForm.valid) {
      this.submitted = true;
      console.log('Reactive Form Value:', this.registrationForm.value);
    } else {
      this.registrationForm.markAllAsTouched();
    }
  }
}