import { AppPage } from './app.po';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
   // console.log(expect(page.getParagraphText()));
    expect(page.isParagraphText()).toBeTruthy("test");
  });
});
