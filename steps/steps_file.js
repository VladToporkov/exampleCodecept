
'use strict';
// in this file you can append custom step methods to 'I' object
let timeout = 5;
var assert = require('assert');

module.exports = function() {
  return actor({


    // Define custom steps here, use 'this' to access default methods of I.
    // It is recommended to place a general 'login' function here.

      clickButton: function(button) {
        this.waitForElement(button.css, timeout);
        this.see(button.text, button.css);
        this.click(button.css);
      },

      fillInput: function (input, text) {

          // Определяем локаторы для поля ввода и заголовка
          let labelCss = 'label[for="'+input.name+'"]';
          let inputCss = 'input[name="'+input.name+'"]';
          // Проверяем заголовок
          this.waitForElement(labelCss, timeout);
          this.see(input.label, labelCss);
          // Вводим данные
          this.fillField(inputCss, text);

      },



  });
};
