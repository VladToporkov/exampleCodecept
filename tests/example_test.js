
Feature('example');
let data = require('../data/exampleTest.json');
let searchData = new DataTable(["obj"]);
for (let obj of data) {
    searchData.add([obj]);
};
/*
  9. Проверить наличие указана скриншоте блоков http://i.imgur.com/FSbeTGI.png, соответствие текста заголовка, соответствие выбранных значений вида и региона.
*/

let user = {
    mail: 'autoUser@mailinator.com',
    pass: 'autoPass'
}

Data(searchData).Scenario('test something', function* (I, mainPagePage, loginPagePage, legalBaseMainPage,
                                                       searchFragment, searchResultPage, current) {

    // 1. Открыть сайт www.1gl.ru
    mainPagePage.getPage();

    // 2. Перейти на страницу входа http://i.imgur.com/yqR9zAX.png
    mainPagePage.goToLoginPage();
    loginPagePage.checkPage();

    // 3. Переключиться на вкладку «вход в систему» http://i.imgur.com/JkRRHKv.png
    let name = yield* loginPagePage.getActiveTab();
    loginPagePage.goToAuthTab(name);

    // 4. Ввести логин и пароль пользователя:
    loginPagePage.fillLoginForm(user);

    // 5. Нажать на кнопку «Войти» http://i.imgur.com/klnRKbJ.png
    loginPagePage.submitLoginForm();

    // 6. Перейти в раздел правовая база по кнопке со стартовой страницы http://i.imgur.com/E8kP7UM.png
    mainPagePage.getPage();
    let activeTabId = yield* mainPagePage.getActiveTabId();
    mainPagePage.goToLegalBase(activeTabId);
    legalBaseMainPage.checkPage();

    // 7. Нажать на кнопку «по реквизитам» http://i.imgur.com/5CGDQ4M.
    let searchState = yield* searchFragment.checkExtendSearchState();
    searchFragment.openExtendSearch(searchState);


    // 8. Во всплывающем блоке заполнить поля и выбрать нужные варианты в списках в соответствии со скрином http://i.imgur.com/L3maaNx.png и нажать кнопку «найти».
    searchFragment.fillSearchRequest(current.obj);
    I.wait(20)
    searchFragment.submitSearch();

    // 9. Проверить наличие указана скриншоте блоков http://i.imgur.com/FSbeTGI.png, соответствие текста заголовка, соответствие выбранных значений вида и региона.
    searchResultPage.waitForSearchResult(10);
    searchResultPage.checkSearchResultBlockIsPresent();
    searchResultPage.checkSearchResultTitle(current.obj.searchString.value);
    searchResultPage.checkSearchResultTypeAndRegion(current.obj.type.value, current.obj.region.value);
    let actualSectionId = yield* searchResultPage.getActiveSearchResultSection();
    searchResultPage.checkSearchResultSection(3, actualSectionId);
    

});
