package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class EditPage extends BasePage {

    // Elements of the Edit Page
    By txtPageTitle = By.id("post-title-0");
    By fldPageBody = By.xpath("//*[@class='editor-default-block-appender__content block-editor-default-block-appender__content']");
    By fldInputBodyText = By.xpath("//*[@class='block-editor-rich-text__editable editor-rich-text__editable wp-block-paragraph'][contains(@aria-label,'или нажмите прямой слэш (/) для выбора блока')]");
    By btnPublish = By.xpath("//*[@class='components-button editor-post-publish-panel__toggle is-button is-primary']");
    By btnPublishConfirm = By.xpath("//*[@class='components-button editor-post-publish-button is-button is-default is-primary is-large']");
    By btnShowPost = By.xpath("//a[contains(text(),\'Просмотреть запись\')]");

    public EditPage (WebDriver driver) {
        super(driver);
    }

    // Enter new page's title
    public EditPage enterPageTitle (String title) {
        clickAndInputText(txtPageTitle, title);
        return this;
    }

    // Enter some one-line text inside a new page
    public EditPage enterOneLineText (String text) {
        click(fldPageBody);
        inputText(fldInputBodyText, text);
        return this;
    }

    // Enter some one-line text inside a new page
    public EditPage enterTextFromFile (String fileName) throws IOException {
        click(fldPageBody);
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while((line = br.readLine()) != null){
            inputText(fldInputBodyText, line + "\n");
        }
        br.close();
        return this;
    }

    // Publish a new page
    public EditPage publishPage () {
        click(btnPublish);
        click(btnPublishConfirm);
        return this;
    }

    // Navigate to the created page
    public EditPage navigateToCreatedPage() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='editor-post-publish-panel__header-published']")));
        click(btnShowPost);
        return this;
    }
}