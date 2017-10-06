
'use strict';

let I;

module.exports = {

    _init() {
      I = require('../steps/steps_file.js')();
    },

    // insert your locators and methods here
    timeout: 5,
    title: {
        css: 'head title', text: 'Система Главбух. Версия для коммерческих организаций'
    },
    header: {
        loginButton: {
            css: '#user-enter u', text: 'Вход и регистрация'
        },
    },
    mainMenu: {
        active: {
            css: 'a.btn_state_active'
        },
        recommendations: {
            css: 'a[data-tabid="1"] .btn__in',
            text: 'Рекомендации',
            id: 1
        },
        legalBase: {
            css: 'a[data-tabid="3"] .btn__in',
            text: 'Правовая база',
            id: 3
        }
    },

    getPage () {

        I.amOnPage('/');
        I.waitForElement(this.title.css, this.timeout);
        I.seeInTitle(this.title.text)

    },

    goToLoginPage() {

        I.clickButton(this.header.loginButton);
        I.wait(1);

    },

    goToLegalBase(id) {

        if (!(id == 3)) {
            I.clickButton(this.mainMenu.legalBase);
            I.wait(1);
        }

    },

    getActiveTabId: function* () {

        let id = yield I.grabAttributeFrom(this.mainMenu.active.css, 'data-tabid');
        return id;
    }

}
