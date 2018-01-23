import { TestBed, inject } from '@angular/core/testing';

import { RemoveProductService } from './remove-product.service';

describe('RemoveProductService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RemoveProductService]
    });
  });

  it('should be created', inject([RemoveProductService], (service: RemoveProductService) => {
    expect(service).toBeTruthy();
  }));
});
