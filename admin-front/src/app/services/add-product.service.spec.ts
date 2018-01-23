import { TestBed, inject } from '@angular/core/testing';

import { AddProductService } from './add-product.service';

describe('AddProductService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AddProductService]
    });
  });

  it('should be created', inject([AddProductService], (service: AddProductService) => {
    expect(service).toBeTruthy();
  }));
});
