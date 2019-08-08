import { browser, by, element, ElementFinder, promise } from 'protractor';

export class DashboardPage {
  navigateToDashBoard() {
    return browser.get('/dashboard');
  }
  getCurrentURL() {
    return browser.getCurrentUrl();
  }
  navigateToDashboardView() {
    return browser.get('/dashboard');
  }
  getDashboardComponent(): ElementFinder {
    return element(by.tagName('app-dashboard'));
  }
  getSearchInputBox(): ElementFinder {
    return element(by.css("input[formControlName=query]"));  
  }
  isSearchInputBoxPresent(): promise.Promise<boolean> {
    return this.getSearchInputBox().isPresent();
  }
  getSearchButton(): ElementFinder {
    return this.getDashboardComponent().element(by.buttonText('Search'));
  }
  isSearchButtonPresent(): promise.Promise<boolean> {
    return this.getSearchButton().isPresent();
  }
  clickSearchButton(): promise.Promise<void> {
    return this.getSearchButton().click();
  }
}