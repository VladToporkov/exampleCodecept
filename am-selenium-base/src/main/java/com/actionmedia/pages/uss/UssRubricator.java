package com.actionmedia.pages.uss;

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
public class UssRubricator extends UssBasePage<UssRubricator> implements IRubricator {

    public UssRubricator checkRubricatorButtonIsPressed() {
        getHelper(RubricatorHelper.class).checkRubricatorButtonIsPressed();
        return this;
    }

    public UssRubricator checkActiveItemForFirstMenuIsHighlighted() {
        getHelper(RubricatorHelper.class).checkActiveItemForFirstMenuIsHighlighted();
        return this;
    }

    public UssRubricator checkActiveItemForSecondMenuIsHighlighted() {
        getHelper(RubricatorHelper.class).checkActiveItemForSecondMenuIsHighlighted();
        return this;
    }

    public UssRubricator checkActiveItemForThirdMenuIsHighlighted() {
        getHelper(RubricatorHelper.class).checkActiveItemForThirdMenuIsHighlighted();
        return this;
    }

    public UssRubricator checkKodeksArticleIsHighlighted() {
        getHelper(RubricatorHelper.class).checkKodeksArticleIsHighlighted();
        return this;
    }

    public UssRubricator checkOpenedItemIsHighlighted() {
        getHelper(RubricatorHelper.class).checkOpenedItemIsHighlighted();
        return this;
    }

    public UssRubricator checkFirstElementIsSelected() {
        getHelper(RubricatorHelper.class).checkFirstElementIsSelected();
        return this;
    }

    public UssRubricator checkNameOfSelectedElementIs(String name, int i) {
        getHelper(RubricatorHelper.class).checkNameOfSelectedElementIs(name, i);
        return this;
    }

    public UssRubricator checkKodeksContentsIsPresent() {
        getHelper(RubricatorHelper.class).checkKodeksContentsIsPresent();
        return this;
    }

    public UssRubricator checkContentsIsPresent() {
        getHelper(RubricatorHelper.class).checkContentsIsPresent();
        return this;
    }

    public UssRubricator checkRubricatorIsClosed() {
        getHelper(RubricatorHelper.class).checkRubricatorIsClosed();
        return this;
    }

    public UssRubricator checkRubricatorButtonIsUnPressed() {
        getHelper(RubricatorHelper.class).checkRubricatorButtonIsUnPressed();
        return this;
    }

    public UssRubricator checkAllRubricatorSectionsHaveContent() {
        getHelper(RubricatorHelper.class).checkAllRubricatorSectionsHaveContent();
        return this;
    }

    public UssRubricator clickRandomKodeks() {
        getHelper(RubricatorHelper.class).clickRandomKodeks();
        return this;
    }

    public UssRubricator clickRandomPBU() {
        getHelper(RubricatorHelper.class).clickRandomPBU();
        return this;
    }

    public UssRubricator clickRandomPart() {
        getHelper(RubricatorHelper.class).clickRandomPart();
        return this;
    }

    public UssDocumentPage clickFirstArticle() {
        getHelper(RubricatorHelper.class).clickFirstArticle();
        return redirectTo(UssDocumentPage.class);
    }

    public UssDocumentPage clickRandomArticle() {
        getHelper(RubricatorHelper.class).clickRandomArticle();
        return redirectTo(UssDocumentPage.class);
    }

    public UssDocumentPage clickRandomNotFirstAndNotLastArticle() {
        getHelper(RubricatorHelper.class).clickRandomNotFirstAndNotLastArticle();
        return redirectTo(UssDocumentPage.class);
    }

    public UssRubricator clickActiveMenuItem() {
        getHelper(RubricatorHelper.class).clickActiveMenuItem();
        return this;
    }

    public UssRubricator clickRandomItemFromFirstMenu() {
        getHelper(RubricatorHelper.class).clickRandomItemFromFirstMenu();
        return this;
    }

    public UssRubricator clickRubricFromFirstColumnByName(String rubricName) {
        getHelper(RubricatorHelper.class).clickRubricFromFirstColumnByName(rubricName);
        return this;
    }

    public UssRubricator clickRubricFromFirstColumnByName(String metaRubric, String rubricName) {
        getHelper(RubricatorHelper.class).clickRubricFromFirstColumnByName(metaRubric, rubricName);
        return this;
    }

    public UssRubricator clickRandomItemFromSecondMenu() {
        getHelper(RubricatorHelper.class).clickRandomItemFromSecondMenu();
        return this;
    }

    public UssRubricator clickRandomItemFromThirdMenu() {
        getHelper(RubricatorHelper.class).clickRandomItemFromThirdMenu();
        return this;
    }

    public UssRubricator clickRandomMagazine() {
        getHelper(RubricatorHelper.class).clickRandomMagazineUss();
        return this;
    }

    public UssRubricator clickRandomCommentaries() {
        getHelper(RubricatorHelper.class).clickRandomCommentaries();
        return this;
    }

    public UssRubricator clickRandomBook() {
        getHelper(RubricatorHelper.class).clickRandomBook();
        return this;
    }

    public UssRubricator clickRandomWizard() {
        getHelper(RubricatorHelper.class).clickRandomWizard();
        return this;
    }

    public UssRubricator checkCloseRubricatorButtonIsPresent() {
        getHelper(RubricatorHelper.class).checkCloseRubricatorButtonIsPresent();
        return this;
    }

    public UssRubricator clickCloseRubricatorButton() {
        getHelper(RubricatorHelper.class).clickCloseRubricatorButton();
        return this;
    }

    public UssRubricator checkRubricatorIsOpened() {
        getHelper(RubricatorHelper.class).checkRubricatorIsOpened();
        return this;
    }

    public boolean isNotFirstAndNotLastArticle() {
        return getHelper(RubricatorHelper.class).isNotFirstAndNotLastArticle();
    }

    public UssRubricator checkSearchRubricatorInputIsPresent() {
        getHelper(RubricatorHelper.class).checkSearchRubricatorInputIsPresent();
        return this;
    }

    public UssRubricator clickSearchRubricatorInput() {
        getHelper(RubricatorHelper.class).clickSearchRubricatorInput();
        return this;
    }

    public UssRubricator clickTableOfContentsButton(){
        getHelper(DocumentHelper.class).clickTableOfContentsButton();
        return this;
    }

    public UssDocumentPage clickLastArticle() {
        getHelper(RubricatorHelper.class).clickLastArticle();
        return redirectTo(UssDocumentPage.class);
    }

    public UssRubricator openRubricInNewTab() {
        getHelper(RubricatorHelper.class).openRubricInNewTab();
        return this;
    }
}
