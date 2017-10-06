package com.actionmedia.pages.kss;

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
public class KssRubricator extends KssBasePage<KssRubricator> implements IRubricator {

    public KssRubricator checkRubricatorButtonIsPressed() {
        getHelper(RubricatorHelper.class).checkRubricatorButtonIsPressed();
        return this;
    }

    public KssRubricator checkActiveItemForFirstMenuIsHighlighted() {
        getHelper(RubricatorHelper.class).checkActiveItemForFirstMenuIsHighlighted();
        return this;
    }

    public KssRubricator checkActiveItemForSecondMenuIsHighlighted() {
        getHelper(RubricatorHelper.class).checkActiveItemForSecondMenuIsHighlighted();
        return this;
    }

    public KssRubricator checkActiveItemForThirdMenuIsHighlighted() {
        getHelper(RubricatorHelper.class).checkActiveItemForThirdMenuIsHighlighted();
        return this;
    }

    public KssRubricator checkKodeksArticleIsHighlighted() {
        getHelper(RubricatorHelper.class).checkKodeksArticleIsHighlighted();
        return this;
    }

    public KssRubricator checkOpenedItemIsHighlighted() {
        getHelper(RubricatorHelper.class).checkOpenedItemIsHighlighted();
        return this;
    }

    public KssRubricator checkFirstElementIsSelected() {
        getHelper(RubricatorHelper.class).checkFirstElementIsSelected();
        return this;
    }

    public KssRubricator checkNameOfSelectedElementIs(String name, int i) {
        getHelper(RubricatorHelper.class).checkNameOfSelectedElementIs(name, i);
        return this;
    }

    public KssRubricator checkKodeksContentsIsPresent() {
        getHelper(RubricatorHelper.class).checkKodeksContentsIsPresent();
        return this;
    }

    public KssRubricator checkContentsIsPresent() {
        getHelper(RubricatorHelper.class).checkContentsIsPresent();
        return this;
    }

    public KssRubricator checkRubricatorIsClosed() {
        getHelper(RubricatorHelper.class).checkRubricatorIsClosed();
        return this;
    }

    public KssRubricator checkCloseRubricatorButtonIsPresent() {
        getHelper(RubricatorHelper.class).checkCloseRubricatorButtonIsPresent();
        return this;
    }

    public KssRubricator checkAllRubricsInRubricator() {
        getHelper(RubricatorHelper.class).checkAllRubrics();
        return this;
    }

    public KssRubricator checkRubricatorIsOpened() {
        getHelper(RubricatorHelper.class).checkRubricatorIsOpened();
        return this;
    }

    public KssRubricator checkRubricatorButtonIsUnPressed() {
        getHelper(RubricatorHelper.class).checkRubricatorButtonIsUnPressed();
        return this;
    }

    public KssRubricator checkAllRubricatorSectionsHaveContent() {
        getHelper(RubricatorHelper.class).checkAllRubricatorSectionsHaveContent();
        return this;
    }

    public KssRubricator clickRandomKodeks() {
        getHelper(RubricatorHelper.class).clickRandomKodeks();
        return this;
    }

    public KssRubricator clickRandomPart() {
        getHelper(RubricatorHelper.class).clickRandomPart();
        return this;
    }

    public KssDocumentPage clickFirstArticle() {
        getHelper(RubricatorHelper.class).clickFirstArticle();
        return redirectTo(KssDocumentPage.class);
    }

    public KssDocumentPage checkAllRubricator() {
        getHelper(RubricatorHelper.class).checkAllRubricator();
        return redirectTo(KssDocumentPage.class);
    }

    public KssDocumentPage clickRandomArticle() {
        getHelper(RubricatorHelper.class).clickRandomArticle();
        return redirectTo(KssDocumentPage.class);
    }

    public KssRubricator clickActiveMenuItem() {
        getHelper(RubricatorHelper.class).clickActiveMenuItem();
        return this;
    }

    public KssRubricator clickRandomItemFromFirstMenu() {
        getHelper(RubricatorHelper.class).clickRandomItemFromFirstMenu();
        return this;
    }

    public KssRubricator clickRandomItemFromSecondMenu() {
        getHelper(RubricatorHelper.class).clickRandomItemFromSecondMenu();
        return this;
    }

    public KssRubricator clickRandomItemFromThirdMenu() {
        getHelper(RubricatorHelper.class).clickRandomItemFromThirdMenu();
        return this;
    }

    public KssRubricator clickRandomMagazine() {
        getHelper(RubricatorHelper.class).clickRandomMagazine();
        return this;
    }

    public KssRubricator clickRandomBook() {
        getHelper(RubricatorHelper.class).clickRandomBook();
        return this;
    }

    public KssRubricator clickRandomWizard() {
        getHelper(RubricatorHelper.class).clickRandomWizardKss();
        return this;
    }

    public KssRubricator clickCloseRubricatorButton() {
        getHelper(RubricatorHelper.class).clickCloseRubricatorButton();
        return this;
    }

    public KssDocumentPage clickRandomNotFirstAndNotLastArticle() {
        getHelper(RubricatorHelper.class).clickRandomNotFirstAndNotLastArticle();
        return redirectTo(KssDocumentPage.class);
    }

    public boolean isNotFirstAndNotLastArticle() {
        return getHelper(RubricatorHelper.class).isNotFirstAndNotLastArticle();
    }

    public KssRubricator checkSearchRubricatorInputIsPresent() {
        getHelper(RubricatorHelper.class).checkSearchRubricatorInputIsPresent();
        return this;
    }

    public KssRubricator clickSearchRubricatorInput() {
        getHelper(RubricatorHelper.class).clickSearchRubricatorInput();
        return this;
    }

    public KssRubricator clickTableOfContentsButton() {
        getHelper(DocumentHelper.class).clickTableOfContentsButton();
        return this;
    }

    public KssDocumentPage clickLastArticle() {
        getHelper(RubricatorHelper.class).clickLastArticle();
        return redirectTo(KssDocumentPage.class);
    }

    public KssRubricator openRubricInNewTab() {
        getHelper(RubricatorHelper.class).openRubricInNewTab();
        return this;
    }
}
