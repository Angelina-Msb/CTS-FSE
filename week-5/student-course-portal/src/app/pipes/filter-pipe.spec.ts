import { FilterPipe } from './filter-pipe';

describe('FilterPipe', () => {
  let pipe: FilterPipe;

  beforeEach(() => {
    pipe = new FilterPipe();
  });

  it('should create an instance', () => {
    expect(pipe).toBeTruthy();
  });

  it('should return empty array if items are null or undefined', () => {
    expect(pipe.transform([], 'test', 'name')).toEqual([]);
    expect(pipe.transform(null as any, 'test', 'name')).toEqual([]);
  });

  it('should return original items if search text is empty', () => {
    const list = [{ fullName: 'Alice' }, { fullName: 'Bob' }];
    expect(pipe.transform(list, '', 'fullName')).toEqual(list);
  });

  it('should filter items based on property name and search query', () => {
    const list = [
      { fullName: 'Alice Smith' },
      { fullName: 'Bob Jones' },
      { fullName: 'Charlie Brown' }
    ];

    const result = pipe.transform(list, 'bob', 'fullName');
    expect(result.length).toBe(1);
    expect(result[0].fullName).toBe('Bob Jones');
  });
});