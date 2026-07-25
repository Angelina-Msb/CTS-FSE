import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedStateService {
  private registeredStudentsSource = new BehaviorSubject<any[]>([]);
  registeredStudents$ = this.registeredStudentsSource.asObservable();

  addStudent(student: any) {
    const currentStudents = this.registeredStudentsSource.value;
    this.registeredStudentsSource.next([...currentStudents, student]);
  }
}