package com.actionmedia.pages.bss;

import com.actionmedia.pages.helpers.DocumentHelper;
import com.actionmedia.pages.helpers.RubricatorHelper;
import com.actionmedia.pages.interfaces.IRubricator;
import org.springframework.stereotype.Component;

/**
 * User: n.tyukavkin
 * Date: 09.01.14
 * Time: 17:48
 */
@Component
public class BssRubricator extends BssBasePage<BssRubricator> implements IRubricator{

    public BssRubricator checkRubricatorButtonIsPressed() {
        getHelper(RubricatorHelper.class).checkRubricatorButtonIsPressed();
        return this;
    }

    public BssRubricator checkActiveItemForFirstMenuIsHighlighted() {
        getHelper(RubricatorHelper.class).checkActiveItemForFirstMenuIsHighlighted();
        return this;
    }

    public BssRubricator checkActiveItemForSecondMenuIsHighlighted() {
        getHelper(RubricatorHelper.class).checkActiveItemForSecondMenuIsHighlighted();
        return this;
    }

    public BssRubricator checkActiveItemForThirdMenuIsHighlighted() {
        getHelper(RubricatorHelper.class).checkActiveItemForThirdMenuIsHighlighted();
        return this;
    }

    public BssRubricator checkKodeksArticleIsHighlighted() {
        getHelper(RubricatorHelper.class).checkKodeksArticleIsHighlighted();
        return this;
    }

    public BssRubricator checkOpenedItemIsHighlighted() {
        getHelper(RubricatorHelper.class).checkOpenedItemIsHighlighted();
        return this;
    }

    public BssRubricator checkFirstElementIsSelected() {
        getHelper(RubricatorHelper.class).checkFirstElementIsSelected();
        return this;
    }

    public BssRubricator checkNameOfSelectedElementIs(String name, int i) {
        getHelper(RubricatorHelper.class).checkNameOfSelectedElementIs(name, i);
        return this;
    }

    public BssRubricator checkKodeksContentsIsPresent() {
        getHelper(RubricatorHelper.class).checkKodeksContentsIsPresent();
        return this;
    }

    public BssRubricator checkContentsIsPresent() {
        getHelper(RubricatorHelper.class).checkContentsIsPresent();
        return this;
    }

    public BssRubricator checkRubricatorIsClosed() {
        getHelper(RubricatorHelper.class).checkRubricatorIsClosed();
        return this;
    }

    public BssRubricator checkRubricatorButtonIsUnPressed() {
        getHelper(RubricatorHelper.class).checkRubricatorButtonIsUnPressed();
        return this;
    }

    public BssRubricator checkAllRubricatorSectionsHaveContent() {
        getHelper(RubricatorHelper.class).checkAllRubricatorSectionsHaveContent();
        return this;
    }

    public BssRubricator checkAllRubricsInRubricator() {
        getHelper(RubricatorHelper.class).checkAllRubrics();
        return this;
    }

    public BssRubricator clickRandomKodeks() {
        getHelper(RubricatorHelper.class).clickRandomKodeks();
        return this;
    }

    public BssRubricator clickRandomPBU() {
        getHelper(RubricatorHelper.class).clickRandomPBU();
        return this;
    }

    public BssRubricator clickRandomPart() {
        getHelper(RubricatorHelper.class).clickRandomPart();
        return this;
    }

    public BssDocumentPage clickRandomArticle() {
        getHelper(RubricatorHelper.class).clickRandomArticle();
        return redirectTo(BssDocumentPage.class);
    }

    public BssDocumentPage clickFirstArticle() {
        getHelper(RubricatorHelper.class).clickFirstArticle();
        return redirectTo(BssDocumentPage.class);
    }

    public BssDocumentPage clickLastArticle() {
        getHelper(RubricatorHelper.class).clickLastArticle();
        return redirectTo(BssDocumentPage.class);
    }

    public BssDocumentPage clickRandomNotFirstAndNotLastArticle() {
        getHelper(RubricatorHelper.class).clickRandomNotFirstAndNotLastArticle();
        return redirectTo(BssDocumentPage.class);
    }

    public BssDocumentPage clickCalculatorByNumber(int number) {
        getHelper(RubricatorHelper.class).clickCalculatorByNumber(number);
        return redirectTo(BssDocumentPage.class);
    }

    public BssRubricator clickActiveMenuItem() {
        getHelper(RubricatorHelper.class).clickActiveMenuItem();
        return this;
    }

    public BssRubricator clickRubricFromFirstMenuByName(String rubricName) {
        getHelper(RubricatorHelper.class).clickRubricFromFirstMenuByName(rubricName);
        return this;
    }

    public BssRubricator clickRubricFromFirstColumnByName(String rubricName) {
        getHelper(RubricatorHelper.class).clickRubricFromFirstColumnByName(rubricName);
        return this;
    }

    public BssRubricator clickRubricFromFirstColumnByName(String metaRubric, String rubricName) {
        getHelper(RubricatorHelper.class).clickRubricFromFirstColumnByName(metaRubric, rubricName);
        return this;
    }

    public BssRubricator clickRandomItemFromFirstMenu() {
        getHelper(RubricatorHelper.class).clickRandomItemFromFirstMenu();
        return this;
    }

    public BssRubricator clickRandomItemFromSecondMenu() {
        getHelper(RubricatorHelper.class).clickRandomItemFromSecondMenu();
        return this;
    }

    public BssRubricator clickRandomItemFromThirdMenu() {
        getHelper(RubricatorHelper.class).clickRandomItemFromThirdMenu();
        return this;
    }

    public BssRubricator clickRandomMagazine() {
        getHelper(RubricatorHelper.class).clickRandomMagazine();
        return this;
    }

    public BssRubricator clickRandomBook() {
        getHelper(RubricatorHelper.class).clickRandomBook();
        return this;
    }

    public BssRubricator clickRandomBJGBook() {
        getHelper(RubricatorHelper.class).clickRandomBJGBook();
        return this;
    }

    public BssRubricator clickRandomWizard() {
        getHelper(RubricatorHelper.class).clickRandomWizard();
        return this;
    }

    public BssRubricator clickCalculatorSection() {
        getHelper(RubricatorHelper.class).clickCalculatorSection();
        return this;
    }

    public BssRubricator checkCloseRubricatorButtonIsPresent() {
        getHelper(RubricatorHelper.class).checkCloseRubricatorButtonIsPresent();
        return this;
    }

    public BssRubricator clickCloseRubricatorButton() {
        getHelper(RubricatorHelper.class).clickCloseRubricatorButton();
        return this;
    }

    public BssRubricator checkRubricatorIsOpened() {
        getHelper(RubricatorHelper.class).checkRubricatorIsOpened();
        return this;
    }

    public boolean isNotFirstAndNotLastArticle() {
        return getHelper(RubricatorHelper.class).isNotFirstAndNotLastArticle();
    }

    public BssRubricator checkSearchRubricatorInputIsPresent() {
        getHelper(RubricatorHelper.class).checkSearchRubricatorInputIsPresent();
        return this;
    }

    public BssRubricator clickSearchRubricatorInput() {
        getHelper(RubricatorHelper.class).clickSearchRubricatorInput();
        return this;
    }

    public BssRubricator clickTableOfContentsButton(){
        getHelper(DocumentHelper.class).clickTableOfContentsButton();
        return this;
    }

    @Override
    public BssRubricator openRubricInNewTab() {
        getHelper(RubricatorHelper.class).openRubricInNewTab();
        return this;
    }
}
