import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { PortfolioComponent } from './portfolio.component';
import { PortfolioService } from 'src/service/portfolio.service';
import { PortfolioDTO } from 'src/dto/portfoliodto';
import { of } from 'rxjs';

describe('PortfolioComponent', () => {
  let component: PortfolioComponent;
  let fixture: ComponentFixture<PortfolioComponent>;
  let mockPortfolioService;

  let getMockedData = (lista: PortfolioDTO[]) => {

    let p: PortfolioDTO = new PortfolioDTO();
    p.totalmoney = 1200;
    p.revenue = 1400;
    p.outputs = 200;
    lista.push(p);
    return lista;
  }

  beforeAll(async(() => {
    let pList: PortfolioDTO[] = [];
    getMockedData(pList);
    mockPortfolioService = jasmine.createSpyObj(['getAll', 'delete', 'hasLoadedObs']);
    mockPortfolioService.getAll.and.returnValue(of(pList));
    mockPortfolioService.delete = (id: number) => {
      pList.pop();
      return of(true);
    }
    mockPortfolioService.hasLoadedObs = of(true);
  }));

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      providers: [{ provide: PortfolioService, useValue: mockPortfolioService }],
      declarations: [PortfolioComponent],
      imports: [FormsModule]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PortfolioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('shold get a wallet list', () => {
    component.getPortfolio();
    expect(component.portfolio.length).toEqual(1);
  });

  it('should delete an item from the list', () => {
    let p: PortfolioDTO = new PortfolioDTO();
    p.id = 3;
    component.delete(p);
    expect(component.portfolio.length).toEqual(0);
  });


});


