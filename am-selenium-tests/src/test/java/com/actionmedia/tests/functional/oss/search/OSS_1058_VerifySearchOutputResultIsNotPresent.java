package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.components.MainMenuButtons;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1058_VerifySearchOutputResultIsNotPresent extends AbstractDomainTest {

    private static final String QUERY = "65432123132123123132";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1058", testCaseVersion = "1")
    public void oss_1058_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) БСС");
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkTextInTypo("В рекомендациях ничего не найдено. Пожалуйста, посмотрите в других разделах: Правовая база, Формы, Справочники, Журналы, Видео, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickLinkOnTypoBySectionType(MainMenuButtons.LAW_BASE)
                .checkTabIsSelected(MainMenuButtons.LAW_BASE)
                .checkTextInTypo("Ничего не найдено. Пожалуйста, посмотрите в других разделах: Рекомендации, Формы, Справочники, Журналы, Видео, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickInLawPracticeLinkFilter()
                .checkInLawAndInPracticeFilterIsPresent()
                .checkTextInTypo("Ничего не найдено. Пожалуйста, посмотрите в других разделах: Рекомендации, Правовая база, Формы, Справочники, Журналы, Видео, Сервисы или переформулируйте запрос.")

                .clickLinkOnTypoBySectionType(MainMenuButtons.FORMS)
                .checkTabIsSelected(MainMenuButtons.FORMS)
                .checkTextInTypo("В формах ничего не найдено. Пожалуйста, посмотрите в других разделах: Рекомендации, Правовая база, Справочники, Журналы, Видео, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickLinkOnTypoBySectionType(MainMenuButtons.DICTIONARIES)
                .checkTabIsSelected(MainMenuButtons.DICTIONARIES)
                .checkTextInTypo("В справочниках ничего не найдено. Пожалуйста, посмотрите в других разделах: Рекомендации, Правовая база, Формы, Журналы, Видео, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickLinkOnTypoBySectionType(MainMenuButtons.VIDEO)
                .checkTabIsSelected(MainMenuButtons.VIDEO)
                .checkTextInTypo("В видео ничего не найдено. Пожалуйста, посмотрите в других разделах: Рекомендации, Правовая база, Формы, Справочники, Журналы, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickLinkOnTypoBySectionType(MainMenuButtons.SERVICES)
                .checkTabIsSelected(MainMenuButtons.SERVICES)
                .checkTextInTypo("В сервисах ничего не найдено. Пожалуйста, посмотрите в других разделах: Рекомендации, Правовая база, Формы, Справочники, Журналы, Видео или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .logout();

        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) КСС");
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkTabIsSelected(MainMenuButtons.ANSWERS)
                .checkTextInTypo("В ответах ничего не найдено. Пожалуйста, посмотрите в других разделах: Правовая база, Формы, Справочник, Журналы и книги, Видео, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickLinkOnTypoBySectionType(MainMenuButtons.LAW_BASE)
                .checkTabIsSelected(MainMenuButtons.LAW_BASE)
                .checkTextInTypo("Ничего не найдено. Пожалуйста, посмотрите в других разделах: Ответы, Формы, Справочник, Журналы и книги, Видео, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickInLawPracticeLinkFilter()
                .checkInLawAndInPracticeFilterIsPresent()
                .checkTextInTypo("Ничего не найдено. Пожалуйста, посмотрите в других разделах: Ответы, Правовая база, Формы, Справочник, Журналы и книги, Видео, Сервисы или переформулируйте запрос.")

                .clickLinkOnTypoBySectionType(MainMenuButtons.FORMS)
                .checkTabIsSelected(MainMenuButtons.FORMS)
                .checkTextInTypo("В формах ничего не найдено. Пожалуйста, посмотрите в других разделах: Ответы, Правовая база, Справочник, Журналы и книги, Видео, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickLinkOnTypoBySectionType(MainMenuButtons.DICTIONARY)
                .checkTabIsSelected(MainMenuButtons.DICTIONARY)
                .checkTextInTypo("В справочниках ничего не найдено. Пожалуйста, посмотрите в других разделах: Ответы, Правовая база, Формы, Журналы и книги, Видео, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickLinkOnTypoBySectionType(MainMenuButtons.VIDEO)
                .checkTabIsSelected(MainMenuButtons.VIDEO)
                .checkTextInTypo("В видео ничего не найдено. Пожалуйста, посмотрите в других разделах: Ответы, Правовая база, Формы, Справочник, Журналы и книги, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickLinkOnTypoBySectionType(MainMenuButtons.SERVICES)
                .checkTabIsSelected(MainMenuButtons.SERVICES)
                .checkTextInTypo("В сервисах ничего не найдено. Пожалуйста, посмотрите в других разделах: Ответы, Правовая база, Формы, Справочник, Журналы и книги, Видео или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .logout();

        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) ЮСС");
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkTabIsSelected(MainMenuButtons.RECOMEND)
                .checkTextInTypo("В рекомендациях ничего не найдено. Пожалуйста, посмотрите в других разделах: Правовая база, Судебная практика, Формы, Справочник, Журналы и книги, Видео, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickLinkOnTypoBySectionType(MainMenuButtons.LAW_BASE)
                .checkTabIsSelected(MainMenuButtons.LAW_BASE)
                .checkTextInTypo("Ничего не найдено. Пожалуйста, посмотрите в других разделах: Рекомендации, Судебная практика, Формы, Справочник, Журналы и книги, Видео, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickInLawPracticeLinkFilter()
                .checkTabIsSelected(MainMenuButtons.LAW_PRACTICE)
                .checkInLawAndInPracticeFilterIsPresent()
                .checkTextInTypo("Ничего не найдено. Пожалуйста, посмотрите в других разделах: Рекомендации, Правовая база, Формы, Справочник, Журналы и книги, Видео, Сервисы или переформулируйте запрос.")

                .clickLinkOnTypoBySectionType(MainMenuButtons.FORMS)
                .checkTabIsSelected(MainMenuButtons.FORMS)
                .checkTextInTypo("В формах ничего не найдено. Пожалуйста, посмотрите в других разделах: Рекомендации, Правовая база, Судебная практика, Справочник, Журналы и книги, Видео, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickLinkOnTypoBySectionType(MainMenuButtons.DICTIONARY)
                .checkTabIsSelected(MainMenuButtons.DICTIONARY)
                .checkTextInTypo("В справочнике ничего не найдено. Пожалуйста, посмотрите в других разделах: Рекомендации, Правовая база, Судебная практика, Формы, Журналы и книги, Видео, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickLinkOnTypoBySectionType(MainMenuButtons.VIDEO)
                .checkTabIsSelected(MainMenuButtons.VIDEO)
                .checkTextInTypo("В видео ничего не найдено. Пожалуйста, посмотрите в других разделах: Рекомендации, Правовая база, Судебная практика, Формы, Справочник, Журналы и книги, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickLinkOnTypoBySectionType(MainMenuButtons.SERVICES)
                .checkTabIsSelected(MainMenuButtons.SERVICES)
                .checkTextInTypo("В сервисах ничего не найдено. Пожалуйста, посмотрите в других разделах: Рекомендации, Правовая база, Судебная практика, Формы, Справочник, Журналы и книги, Видео или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .logout();

        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) ФСС");
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkTabIsSelected(MainMenuButtons.FSS_SOLUTIONS)
                .checkTextInTypo("В решениях ничего не найдено. Пожалуйста, посмотрите в других разделах: Положения и регламенты, Правовая база, Библиотека, Видео, Справочник, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickLinkOnTypoBySectionType(MainMenuButtons.FSS_LAW_BASE)
                .checkTabIsSelected(MainMenuButtons.FSS_LAW_BASE)
                .checkTextInTypo("Ничего не найдено. Пожалуйста, посмотрите в других разделах: Решения, Положения и регламенты, Библиотека, Видео, Справочник, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickInLawPracticeLinkFilter()
                .checkInLawAndInPracticeFilterIsPresent()
                .checkTextInTypo("Ничего не найдено. Пожалуйста, посмотрите в других разделах: Решения, Положения и регламенты, Правовая база, Библиотека, Видео, Справочник, Сервисы или переформулируйте запрос.")

                .clickLinkOnTypoBySectionType(MainMenuButtons.FSS_FORMS)
                .checkTabIsSelected(MainMenuButtons.FSS_FORMS)
                .checkTextInTypo("В положениях и регламентах ничего не найдено. Пожалуйста, посмотрите в других разделах: Решения, Правовая база, Библиотека, Видео, Справочник, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickLinkOnTypoBySectionType(MainMenuButtons.FSS_DICTIONARY)
                .checkTabIsSelected(MainMenuButtons.FSS_DICTIONARY)
                .checkTextInTypo("В справочнике ничего не найдено. Пожалуйста, посмотрите в других разделах: Решения, Положения и регламенты, Правовая база, Библиотека, Видео, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickLinkOnTypoBySectionType(MainMenuButtons.FSS_VIDEO)
                .checkTabIsSelected(MainMenuButtons.FSS_VIDEO)
                .checkTextInTypo("В видео ничего не найдено. Пожалуйста, посмотрите в других разделах: Решения, Положения и регламенты, Правовая база, Библиотека, Справочник, Сервисы или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .clickLinkOnTypoBySectionType(MainMenuButtons.FSS_SERVICES)
                .checkTabIsSelected(MainMenuButtons.FSS_SERVICES)
                .checkTextInTypo("В сервисах ничего не найдено. Пожалуйста, посмотрите в других разделах: Решения, Положения и регламенты, Правовая база, Библиотека, Видео, Справочник или переформулируйте запрос, или поищите через рубрикатор.")
                .checkRubricatorLinkOnTypo()

                .logout();
    }
}
