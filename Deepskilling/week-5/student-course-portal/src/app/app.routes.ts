import { Routes } from '@angular/router';
import { EnrollmentFormComponent } from './pages/enrollment-form/enrollment-form';
import { CourseRegistrationComponent } from './pages/course-registration/course-registration';
import { CourseApiListComponent } from './pages/course-api-list/course-api-list';
import { CourseDetailComponent } from './pages/course-detail/course-detail';
import { StudentRegistrationComponent } from './pages/student-registration/student-registration';
import { StudentManagementComponent } from './pages/student-management/student-management'; // <--- Add this import

export const routes: Routes = [
  { path: 'enroll', component: EnrollmentFormComponent },
  { path: 'register', component: CourseRegistrationComponent },
  { path: 'api-courses', component: CourseApiListComponent },
  { path: 'course/:id', component: CourseDetailComponent },
  { path: 'student-register', component: StudentRegistrationComponent },
  { path: 'student-management', component: StudentManagementComponent } // <--- Route
];