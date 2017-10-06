
'use strict';
var assert = require('assert');

let I;

module.exports = {

    _init() {
      I = require('../steps/steps_file.js')();
    },

    // insert your locators and methods here
    header: {
        title: {
            css: '.search-result h1', text: 'Результаты поиска по реквизитам: '
        },
        searchExtendedString: {
            css: '.search-extended-string'
        },

    },

    searchResult: {
        css: '#searchResultsSection'
    },

    sidebar: {
        sectionFilter: {
            active: {
                css: 'ul[data-filtr-name="pubDiv"] .active',
            }
        },
    },

    waitForSearchResult(time) {
        I.waitForVisible(this.searchResult.css, time);
    },

    checkSearchResultTitle (request) {

        let title = this.header.title.text + '«' + request.toLowerCase() + '»';
        I.see(title, this.header.title.css);

    },

    checkSearchResultTypeAndRegion(type, region) {

       I.see(type, this.header.searchExtendedString.css + ' span:nth-child(1)');
       I.see(region, this.header.searchExtendedString.css + ' span:nth-child(2)');

    },

    getActiveSearchResultSection: function* () {

        let id = yield I.grabAttributeFrom(this.sidebar.sectionFilter.active, 'data-param');
        return id;

    },

    checkSearchResultSection (sectionId, id) {

        assert.equal(sectionId, id)

    },

    checkSearchResultBlockIsPresent () {

        I.seeElement(this.searchResult.css);

    },

    checkSearchResultType () {},
}
