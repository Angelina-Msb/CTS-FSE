import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SharedStateService } from '../../services/shared-state'; // <--- Import service

@Component({
  selector: 'app-student-registration',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './student-registration.html',
  styleUrl: './student-registration.css'
})
export class StudentRegistrationComponent {
  studentForm: FormGroup;
  submittedData: any = null;

  constructor(private fb: FormBuilder, private sharedState: SharedStateService) {
    this.studentForm = this.fb.group({
      fullName: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      courseCode: ['', Validators.required],
      phone: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]]
    });
  }

  onSubmit() {
    if (this.studentForm.valid) {
      this.submittedData = this.studentForm.value;
      this.sharedState.addStudent(this.submittedData); // <--- Add to shared state stream
      console.log('Student Added to State!', this.submittedData);
      this.studentForm.reset();
    } else {
      this.studentForm.markAllAsTouched();
    }
  }
}