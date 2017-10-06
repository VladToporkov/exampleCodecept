package com.actionmedia.tests.services.searchservice.searchlaw;

import com.actionmedia.components.Document;
import com.actionmedia.util.DBUtils;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.types.UnsignedByte;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.List;

import static com.actionmedia.autotest.Group.search;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 15.01.14
 * Time: 12:22
 * <p/>
 * <p/>
 * <p/>
 * Поиск по документам НПД
 * <p/>
 * <p/>
 * <p/>
 * <param name="searchString">поисковая строка</param>
 * <param name="pubId">ID издания (6..14)</param>
 * <param name="excludedModules">Список модулей, в которых производится поиск (не используется)</param>
 * <param name="searchTagList">Список поисковых тэгов (фильтр)</param>
 * <param name="sortOrder">Сортировка результатов поиска
 * ///"по релевантности"= 0,
 * ///"по дате принятия" = 6,
 * ///"по юр.силе и дате" = 11
 * </param>
 * <param name="searchOptionFlags">Параметры поиска - сумма следующих значений:
 * ///"Признак запрета на восстановление строки" = 1,
 * ///"Признак расширеного поиска (по реквизитам)" = 2,
 * ///"Признак поиска по всем документам (не только по актуальным)" = 4,
 * ///"Признак частотного поиска" = 8,
 * ///"Включен поиск по всем разделам (колдунщики)" = 32,
 * ///"Отключен эталонный поиск" = 64,
 * ///"Поиск только по заголовкам" = 128
 * </param>
 * <param name="snippetSize">Размер сниппета в словах</param>
 * <param name="docPosition">Позиция последнего найденного документа в предыдущем запросе</param>
 * <param name="pageSize">Размер страницы поисковой выдачи</param>
 * <param name="searchType">Стартовый тип поиска</param>
 * <param name="statusFilter">Статус документа
 * ///"Значение по-умолчанию" = 0,
 * ///"Актуальный документ" = 1,
 * ///"Документ утратил силу" = 2,
 * ///"Документ не вступил в силу" = 3,
 * ///"Документ не действует" = 4
 * </param>
 * <param name="docRegionIdList">Список ID регионов</param>
 * <param name="docTypeIdList">Список ID типов документов</param>
 * <param name="docLobbyIdList">Список ID органов принятия документов</param>
 * <param name="docNumber">Номер документа</param>
 * <param name="pubDateStartedOn">Дата принятия документа с</param>
 * <param name="pubDateEndedOn">Дата принятия документа по</param>
 * <param name="searchPrevStringList">Список предыдущих запросов для поиска в найденном</param>
 */
public class SearchLaw extends SearchLawBase {

    private String searchString = "";
    private UnsignedByte pubId = new UnsignedByte(6);
    private UnsignedByte pubDivId = new UnsignedByte(3);
    private int[] excludedModules = new int[]{};
    private int[] searchTagList = new int[]{};
    private UnsignedByte sortOrder = new UnsignedByte(0);
    private int searchOptionFlags = 0;
    private int snippetSize = 25;
    private int docPosition = 1;
    private int pageSize = 100;
    private String searchType = "";
    private UnsignedByte statusFilter = new UnsignedByte(0);
    private int[] docRegionIdList = new int[]{};
    private int[] docTypeIdList = new int[]{};
    private int[] docLobbyIdList = new int[]{};
    private String docNumber = "";
    private Calendar pubDateStartedOn = getCalendarByDateString("01-01-1990", "dd-MM-yyyy");
    private Calendar pubDateEndedOn = null;
    private String[] searchPrevStringList = new String[]{};

    @Test(groups = {search, service})
    public void searchLaw_structure_test() {
        report("Проверяется общая структура ответного xml для метода '" + METHOD_NAME + "'");

        String searchString = "закон";
        ServiceResponse response = getSearchLawResponse(searchString, pubId, pubDivId, excludedModules, searchTagList, sortOrder, searchOptionFlags, snippetSize, docPosition, pageSize, searchType, statusFilter, docRegionIdList, docTypeIdList, docLobbyIdList, docNumber, pubDateStartedOn, pubDateEndedOn, searchPrevStringList);

        checkLingvoNode(response, false);
        checkHeaderInfo(response, false);
        checkSearchList(response);
    }

    @Test(groups = {search, service})
    public void searchLaw_with_attribute_with_text_test() {
        report("Проверяется работа поиска по реквизитам с текстом");

        String searchString = "об образовании";
        int searchOptionFlags = 2;
        int[] docTypeIdList = new int[]{13};

        ServiceResponse response = getSearchLawResponse(searchString, pubId, pubDivId, excludedModules, searchTagList, sortOrder, searchOptionFlags, snippetSize, docPosition, pageSize, searchType, statusFilter, docRegionIdList, docTypeIdList, docLobbyIdList, docNumber, pubDateStartedOn, pubDateEndedOn, searchPrevStringList);

        checkLingvoNode(response, false);
        checkHeaderInfo(response, false);
        checkAdvancedSearchFilters(response);
        checkSearchList(response);
    }

    @Test(groups = {search, service})
    public void searchLaw_with_attribute_without_text_test() {
        report("Проверяется работа поиска по реквизитам без текста");

        int searchOptionFlags = 2;
        int[] docTypeIdList = new int[]{218};
        String docNumber = "123-фз";

        ServiceResponse response = getSearchLawResponse(searchString, pubId, pubDivId, excludedModules, searchTagList, sortOrder, searchOptionFlags, snippetSize, docPosition, pageSize, searchType, statusFilter, docRegionIdList, docTypeIdList, docLobbyIdList, docNumber, pubDateStartedOn, pubDateEndedOn, searchPrevStringList);

        checkLingvoNode(response, true);
        checkHeaderInfo(response, true);
        checkAdvancedSearchFilters(response);
        checkSearchList(response);
    }

    @Test(groups = {search, service})
    public void searchLaw_with_attribute_with_tag_test() {
        report("Проверяется работа поиска с тегами");

        String searchString = "плата за образование ребёнка";
        int[] searchTagList = new int[]{8};
        int searchOptionFlags = 2;

        ServiceResponse response = getSearchLawResponse(searchString, pubId, pubDivId, excludedModules, searchTagList, sortOrder, searchOptionFlags, snippetSize, docPosition, pageSize, searchType, statusFilter, docRegionIdList, docTypeIdList, docLobbyIdList, docNumber, pubDateStartedOn, pubDateEndedOn, searchPrevStringList);

        checkLingvoNode(response, false);
        checkHeaderInfo(response, false);
        checkAdvancedSearchFilters(response);
        checkSearchList(response);
    }

    @Test(groups = {search, service})
    public void searchLaw_status_test() {
        report("Проверяется работа поиска по статусу");

        String searchString = "закон о бухучете";
        int searchOptionFlags = 2;
        UnsignedByte statusFilter = new UnsignedByte(2);

        ServiceResponse response = getSearchLawResponse(searchString, pubId, pubDivId, excludedModules, searchTagList, sortOrder, searchOptionFlags, snippetSize, docPosition, pageSize, searchType, statusFilter, docRegionIdList, docTypeIdList, docLobbyIdList, docNumber, pubDateStartedOn, pubDateEndedOn, searchPrevStringList);

        checkLingvoNode(response, false);
        checkHeaderInfo(response, false);
        checkAdvancedSearchFilters(response);
        checkSearchList(response);
    }

    @Test(groups = {search, service})
    public void searchLaw_only_date_test() {
        report("Проверяется работа поиска только по дате");

        int searchOptionFlags = 2;
        Calendar pubDateStartedOn = getCalendarByDateString("01-01-2011", "dd-MM-yyyy");
        Calendar pubDateEndedOn = getCalendarByDateString("01-01-2014", "dd-MM-yyyy");

        ServiceResponse response = getSearchLawResponse(searchString, pubId, pubDivId, excludedModules, searchTagList, sortOrder, searchOptionFlags, snippetSize, docPosition, pageSize, searchType, statusFilter, docRegionIdList, docTypeIdList, docLobbyIdList, docNumber, pubDateStartedOn, pubDateEndedOn, searchPrevStringList);

        checkLingvoNode(response, true);
        checkHeaderInfo(response, true);
        checkAdvancedSearchFilters(response);
        checkSearchList(response);
    }

    @Test(groups = {search, service})
    public void searchLaw_one_day_test() {
        report("Проверяется работа поиска по одному дню");

        int searchOptionFlags = 2;
        Calendar pubDateStartedOn = getCalendarByDateString("11-11-2011", "dd-MM-yyyy");
        Calendar pubDateEndedOn = getCalendarByDateString("11-11-2011", "dd-MM-yyyy");

        ServiceResponse response = getSearchLawResponse(searchString, pubId, pubDivId, excludedModules, searchTagList, sortOrder, searchOptionFlags, snippetSize, docPosition, pageSize, searchType, statusFilter, docRegionIdList, docTypeIdList, docLobbyIdList, docNumber, pubDateStartedOn, pubDateEndedOn, searchPrevStringList);

        checkLingvoNode(response, true);
        checkHeaderInfo(response, true);
        checkAdvancedSearchFilters(response);
        checkSearchList(response);
    }

    @Test(groups = {search, service})
    public void searchLaw_spell_text_test() {
        report("Проверяется работа исправления опечаток и раскладки клавиатуры");

        String searchString = "ext";

        ServiceResponse response = getSearchLawResponse(searchString, pubId, pubDivId, excludedModules, searchTagList, sortOrder, searchOptionFlags, snippetSize, docPosition, pageSize, searchType, statusFilter, docRegionIdList, docTypeIdList, docLobbyIdList, docNumber, pubDateStartedOn, pubDateEndedOn, searchPrevStringList);

        postponedAssertEquals(response.getNodeElementByName("input_search_string").getValue(), "ext", "Неправильное значение для тэга 'input_search_string'");
        postponedAssertEquals(response.getNodeElementByName("fix_search_string").getValue(), "учет", "Неправильное значение для тэга 'fix_search_string'");

        checkLingvoNode(response, false);
        checkHeaderInfo(response, false);
        checkSearchList(response);
    }

    @Test(groups = {search, service})
    public void searchLaw_standard_test() {
        report("Проверяется работа эталонной выдачи");

        String searchString = "проверка эталонной выдачи";
        Calendar pubDateStartedOn = null;

        ServiceResponse response = getSearchLawResponse(searchString, pubId, pubDivId, excludedModules, searchTagList, sortOrder, searchOptionFlags, snippetSize, docPosition, pageSize, searchType, statusFilter, docRegionIdList, docTypeIdList, docLobbyIdList, docNumber, pubDateStartedOn, pubDateEndedOn, searchPrevStringList);

        checkLingvoNode(response, false);
        checkHeaderInfo(response, false);
        checkSearchList(response);
        checkFoundedItemNameByNumber(response, "Налоговый кодекс РФ. Часть первая", 0);
    }

    @Test(groups = {search, service})
    public void searchLaw_search_in_results_test() {
        report("Проверяется работа поиска в найденном");

        UnsignedByte pubId = new UnsignedByte(11);
        String searchString = "ссср";
        String[] searchPrevStringList = new String[]{"таможенный кодекс"};

        ServiceResponse response = getSearchLawResponse(searchString, pubId, pubDivId, excludedModules, searchTagList, sortOrder, searchOptionFlags, snippetSize, docPosition, pageSize, searchType, statusFilter, docRegionIdList, docTypeIdList, docLobbyIdList, docNumber, pubDateStartedOn, pubDateEndedOn, searchPrevStringList);

        checkLingvoNode(response, false);
        checkOldLingvoNode(response, false);
        checkHeaderInfo(response, false);
        checkSearchList(response);
        checkFoundedItemNameByNumber(response, "Таможенный кодекс СССР", 0);
    }

    @Test(groups = {search, service})
    public void searchLaw_search_only_in_titles_test() {
        report("Проверяется работа поиска только в заголовках(только в заголовках - 1 документ)");

        String searchString = "распоряжение ржд термос-контейнер";
        int searchOptionFlags = 130;

        ServiceResponse response = getSearchLawResponse(searchString, pubId, pubDivId, excludedModules, searchTagList, sortOrder, searchOptionFlags, snippetSize, docPosition, pageSize, searchType, statusFilter, docRegionIdList, docTypeIdList, docLobbyIdList, docNumber, pubDateStartedOn, pubDateEndedOn, searchPrevStringList);

        checkLingvoNode(response, false);
        checkHeaderInfo(response, false);
        checkAdvancedSearchFilters(response);
        checkSearchList(response);
        checkNumberOfFoundedItems(response, 1);
    }

    @Test(groups = {search, service})
    public void searchLaw_search_only_in_titles_search_in_all_test() {
        report("Проверяется работа поиска только в заголовках(поиск везде - находит более одного документа )");

        String searchString = "распоряжение ржд термос-контейнер ";
        int searchOptionFlags = 2;

        ServiceResponse response = getSearchLawResponse(searchString, pubId, pubDivId, excludedModules, searchTagList, sortOrder, searchOptionFlags, snippetSize, docPosition, pageSize, searchType, statusFilter, docRegionIdList, docTypeIdList, docLobbyIdList, docNumber, pubDateStartedOn, pubDateEndedOn, searchPrevStringList);

        checkLingvoNode(response, false);
        checkHeaderInfo(response, false);
        checkAdvancedSearchFilters(response);
        checkSearchList(response);
        List<NodeElement> foundedItemList = response.getNodeElementListByName("itemfound");
        postponedAssertFalse(foundedItemList.isEmpty(), "Не найдено ни одного документа");
    }

    @Test(groups = {search, service})
    public void searchLaw_search_only_in_actual_in_all_documents_test() {
        report("Проверяется работа поиска только в действующих документах (во всех находит 4 таможенных кодекса (ТС, часть РФ, РФ, СССР)");

        String searchString = "таможенный кодекс";
        int searchOptionFlags = 2;
        UnsignedByte statusFilter = new UnsignedByte(0);
        int[] docTypeIdList = new int[]{4};

        ServiceResponse response = getSearchLawResponse(searchString, pubId, pubDivId, excludedModules, searchTagList, sortOrder, searchOptionFlags, snippetSize, docPosition, pageSize, searchType, statusFilter, docRegionIdList, docTypeIdList, docLobbyIdList, docNumber, pubDateStartedOn, pubDateEndedOn, searchPrevStringList);

        checkLingvoNode(response, true);
        checkHeaderInfo(response, true);
        checkAdvancedSearchFilters(response);
        checkSearchList(response);
        checkItemFoundByDocIdIsPresent(response, "902202883");
        checkItemFoundByDocIdIsPresent(response, "9005480");
        checkItemFoundByDocIdIsPresent(response, "901863313");
        checkItemFoundByDocIdIsPresent(response, "901607571");
    }

    @Test(groups = {search, service})
    public void searchLaw_search_only_in_actual_documents_test() {
        report("Проверяется работа поиска только в действующих документах (находит 2 таможенных кодекса (ТС, часть РФ)");

        int moduleDocId = 99;
        int docId = 902202883;
        Document actualRedactionForDocument = DBUtils.getActualRedactionForDocument(moduleDocId, docId);
        assertNotNull(actualRedactionForDocument, "Не найдена актуальная редакция для документа " + moduleDocId + "/" + docId);

        String searchString = "таможенный кодекс";
        int searchOptionFlags = 2;
        UnsignedByte statusFilter = new UnsignedByte(1);
        int[] docTypeIdList = new int[]{4};

        ServiceResponse response = getSearchLawResponse(searchString, pubId, pubDivId, excludedModules, searchTagList, sortOrder, searchOptionFlags, snippetSize, docPosition, pageSize, searchType, statusFilter, docRegionIdList, docTypeIdList, docLobbyIdList, docNumber, pubDateStartedOn, pubDateEndedOn, searchPrevStringList);

        checkLingvoNode(response, true);
        checkHeaderInfo(response, true);
        checkAdvancedSearchFilters(response);
        checkSearchList(response);
        checkItemFoundByDocIdIsPresent(response, String.valueOf(actualRedactionForDocument.getDocumentId()));
        checkItemFoundByDocIdIsNotPresent(response, "9005480");
        checkItemFoundByDocIdIsNotPresent(response, "901863313");
        checkItemFoundByDocIdIsNotPresent(response, "901607571");
    }
}
