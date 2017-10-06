
'use strict';

let I;

module.exports = {

    _init() {
      I = require('../steps/steps_file.js')();
    },

    // insert your locators and methods here
    url: 'http://www.1gl.ru/#!/law/',
    timeout: '',


    checkPage() {

        I.seeCurrentUrlEquals(this.url);

    },
}
