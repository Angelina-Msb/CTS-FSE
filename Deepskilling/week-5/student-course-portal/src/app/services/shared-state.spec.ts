import { TestBed } from '@angular/core/testing';
import { SharedStateService } from './shared-state';

describe('SharedStateService', () => {
  let service: SharedStateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SharedStateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should add a student to the behavior subject stream', (done) => {
    const testStudent = {
      fullName: 'Jane Doe',
      email: 'jane@example.com',
      courseCode: 'CS101',
      phone: '9876543210'
    };

    service.addStudent(testStudent);

    service.registeredStudents$.subscribe(students => {
      if (students.length > 0) {
        expect(students.length).toBe(1);
        expect(students[0].fullName).toEqual('Jane Doe');
        done();
      }
    });
  });
});