import { DashboardPage } from './page-objects/dashboard.po';

describe('dashboard page', () => {
  let page: DashboardPage;

  beforeEach(() => {
    page = new DashboardPage();
  });

  
  it('should get search input box', () => {
    page.navigateToDashBoard();
    expect(page.isSearchInputBoxPresent())
    .toBeTruthy(`<input class="search" [formControl]='query'> should exist in dashboard.component.html`);
  });

  it('should get search button', () => {
    page.navigateToDashBoard();
    expect(page.isSearchButtonPresent())
    .toBeTruthy(`<button type="submit" [disabled]="!searchForm.valid" mat-button>Search</button>`);
  });

  it('should search gipher', () => {
    page.navigateToDashBoard();
    let searchValues = page.addSearchValues();
    //expect(page.getSearchInputBoxesDefaultValues()).toEqual(searchValues, 'Should be able to set values for username and password');
    page.clickSearchButton();
    // page.getCurrentURL().then((url) => {
    //   if (url.indexOf('login') > -1) {
    //     newNoteValues = page.addLoginValues();
    //     page.clickLoginButton();
    //     page.navigateToDashboardView();
    //     expect(page.getCurrentURL()).toContain('login');
    //   } else {
    //     expect(page.getCurrentURL()).toContain('dashboard');
    //   }
    // });
  });

});
