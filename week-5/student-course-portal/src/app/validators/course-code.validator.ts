import { AbstractControl, ValidationErrors } from '@angular/forms';

export function courseCodeValidator(control: AbstractControl): ValidationErrors | null {
  const value = control.value;
  if (value && !value.toUpperCase().startsWith('CS')) {
    return { invalidCourseCode: true };
  }
  return null;
}