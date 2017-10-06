
'use strict';

let I;

module.exports = {

    _init() {
      I = require('../steps/steps_file.js')();
    },

    // insert your locators and methods here

    tabs:{
        registration: {
            tabTitle:{
              css: 'div[data-tab-name="demo"]'
            },
        },
        auth: {
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

    fillLogin(login) {
        I.fillInput(this.tabs.auth.loginField, login);
    },

    fillPass(pass) {
        I.fillInput(this.tabs.auth.passField, pass);
    },

    loginSubmit() {
        I.click(this.tabs.auth.submit.css);
    },

    goToAuthTab() {
        I.clickButton(this.tabs.auth.tabTitle);
    },

    goToDemoTab() {},



}
