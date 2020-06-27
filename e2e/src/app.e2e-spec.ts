import { AppPage } from './app.po';
import { browser,by, logging, element } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display login page', () => {
    page.navigateTo();
    let par = element(by.tagName('p'));
    expect(par.getText()).toContain("Insert username and password to Login or Sign Up");
  });

  it('should login',()=>{
    let adminInput = element(by.id("user"));
    let pswInput = element(by.id("pass"));
    let loginButton = element(by.id("login"));
    adminInput.sendKeys("admin");
    pswInput.sendKeys("admin");
    loginButton.click();
    expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + '/admin-dashboard');
    expect()
  });

  it('should display welcome message', () => {
    let el = element(by.tagName('h3'));
    expect(el.getText()).toContain("Welcome admin");
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
