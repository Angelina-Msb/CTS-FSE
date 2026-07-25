import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseApiList } from './course-api-list';

describe('CourseApiList', () => {
  let component: CourseApiList;
  let fixture: ComponentFixture<CourseApiList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseApiList],
    }).compileComponents();

    fixture = TestBed.createComponent(CourseApiList);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
