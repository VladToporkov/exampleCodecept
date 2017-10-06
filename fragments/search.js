
'use strict';


let I;

module.exports = {

    _init() {
      I = require('../steps/steps_file.js')();
    },

    // Локаторы элементов
    timeout:5,
    searchField: {
        css: '#search-text'
    },
    extendSearch: {
        css: '#search-form-extended',
        extendButton: {
            css: '#search-button-extended', text: 'По реквизитам ...'
        },
        lawPracticeSwitch: {
            css: '#law-practice-switch',
            inLaw: {
                css: '.in-law span', text: 'В законодательстве'
            },
            inPractice: {
                css: '.in-practice span', text: 'В судебной практике'
            }
        },
        sdNum: {
            css: '#sd-num'
        },
        date: {
            dateStart: {
                css: '#sd-datestart'
            },
            dateEnd: {
                css: '#sd-dateend'
            }
        },
        sdType: {
            css: '#sd-type'
        },
        sdTypeList: {
            css: '#typelist'
        },
        sdEntity: {
            css: '#sd-entity'
        },
        sdEntityList: {
            css: '#lobbylist'
        },
        sdRegion: {
            css: '#sd-region'
        },
        sdRegionList:{
            css: '#regionlist'
        },
        clearAll: {
            css: '#search-clear-all'
        },
        submit: {
            css: '#button-search-extended'
        },
    },

    checkExtendSearchState: function* () {
        let classes = yield I.grabAttributeFrom(this.extendSearch.extendButton.css, 'className');
        return classes.includes('btn_state_active');
    },

    openExtendSearch(state) {

        if (!state) {
            I.click(this.extendSearch.extendButton.css);
            I.waitForVisible(this.extendSearch.css, 5);
        };
    },

    fillSearchField (obj) {

        if (obj.exec) {
            I.fillField(this.searchField.css, obj.value);
            I.click(this.searchField.css);
        }

    },

    getActivePractice: function* () {
        let atr  = yield I.grabAttributeFrom(this.extendSearch.lawPracticeSwitch.css + ' .active', 'data-position');
        return atr;
    },

    chooseLawPractice(obj) {
        if (obj.exec) {
            let css = 'label[data-position="' + obj.atr + '"]';
            I.click(css);
        }
    },

    fillSdNumber (obj) {

        if (obj.exec) {
            I.fillField(this.extendSearch.sdNum.css, obj.value);
        }
    },

    fillSdDate (obj) {

        if (obj.exec) {
            I.fillField(this.extendSearch.date.dateStart.css, obj.dateStart);
            I.fillField(this.extendSearch.date.dateEnd.css, obj.dateEnd);
        }

    },

    chooseSdType (obj) {

        if (obj.exec) {
            I.fillField(this.extendSearch.sdType.css, obj.value);
            let css = this.extendSearch.sdTypeList.css + ' li[data-id-attr="' + obj.id + '"]';
            I.waitForVisible(css, this.timeout);
            I.click(css);
        }

    },

    chooseSdEntity (obj) {

        if (obj.exec) {
            I.fillField(this.extendSearch.sdEntity.css, obj.value);
            let css = this.extendSearch.sdEntityList.css + ' li[data-id-attr="' + obj.id + '"]';
            I.waitForVisible(css, this.timeout);
            I.click(css);
        }

    },

    chooseSdRegion (obj) {

        if (obj.exec) {
            I.fillField(this.extendSearch.sdRegion.css, obj.value);
            let css = this.extendSearch.sdRegionList.css + ' li[data-id-attr="' + obj.id + '"]';
            I.waitForVisible(css, this.timeout);
            I.click(css);
        }

    },

    clearAll () {

        I.click(this.extendSearch.clearAll.css);

    },

    submitSearch () {

        I.click(this.extendSearch.submit.css);

    },

    fillSearchRequest (obj) {

        this.fillSearchField(obj.searchString);
        this.chooseLawPractice(obj.lawAtr);
        this.fillSdNumber(obj.num);
        this.fillSdDate(obj.date);
        this.chooseSdType(obj.type);
        this.chooseSdEntity(obj.entity);
        this.chooseSdRegion(obj.region);

    },


}
