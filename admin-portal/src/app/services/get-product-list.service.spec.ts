import { TestBed, inject } from '@angular/core/testing';

import { GetProductListService } from './get-product-list.service';

describe('GetProductListService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GetProductListService]
    });
  });

  it('should be created', inject([GetProductListService], (service: GetProductListService) => {
    expect(service).toBeTruthy();
  }));
});
