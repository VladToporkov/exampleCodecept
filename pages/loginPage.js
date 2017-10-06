
'use strict';

let I;
let assert = require('assert');

module.exports = {

    _init() {
      I = require('../steps/steps_file.js')();

    },

    // insert your locators and methods here

    timeout: 5,
    url: 'http://www.1gl.ru/#/customer/auth/',
    title: {
        css: 'head title',
        text: 'Вход в Систему Главбух'
    },
    header: {
        loginButton: {
            css: '#user-geo a', text: 'Вход и регистрация'
        },
    },
    tabs:{
        registration: {
            tabTitle:{
                css: 'div[data-tab-name="demo"]'
            },
        },
        auth: {
            name: 'auth',
            tabTitle:{
                css: 'div[data-tab-name="auth"] .auth__title', text: 'Войдите на сайт'

            },
            loginField: {
                name: 'email',
                label: 'Эл. почта'
            },
            passField: {
                name: 'password',
                label: 'Пароль'
            },
            forgotPassButton: {
                css: '.js-password-remind',
                text: 'Забыли пароль?'
            },
            submit: {
                css: '#customer-enter',
                text: 'Войти'
            },
            autoLogin: {

            }

        }
    },

    getPage () {

        I.amOnPage(this.url);
        I.waitForElement(this.title.css, this.timeout);
        I.see(this.title.text, this.title.css);

    },

    checkPage() {

        I.waitForElement(this.title.css, this.timeout);
        I.seeCurrentUrlEquals(this.url);

    },

    fillLoginForm(user) {

        I.fillInput(this.tabs.auth.loginField, user.mail);
        I.fillInput(this.tabs.auth.passField,user.pass);

    },

    submitLoginForm() {

        I.click(this.tabs.auth.submit.css);

    },

    getActiveTab: function* () {

        let name = yield I.grabAttributeFrom('div.auth__tab_state_active', 'data-tab-name');
        return name;

    },

    goToAuthTab(name) {

        console.log(!(name == this.tabs.auth.name));

        if (!(name == this.tabs.auth.name)) {
            I.clickButton(this.tabs.auth.tabTitle);
        }


    }


}
