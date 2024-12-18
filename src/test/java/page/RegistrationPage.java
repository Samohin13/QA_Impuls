package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    private static final SelenideElement emailField = $("[id = 'email']");
    private final SelenideElement firstName = $("[id ='firstName']");
    private final SelenideElement lastName = $("[id ='lastName']");
    public final SelenideElement birthday = $("[id='birthday']"); // Добавлено поле даты рождения
    private final SelenideElement clubName = $("[id ='clubName']");
    private final SelenideElement password = $("[id ='password']");
    private final SelenideElement password1 = $("[id ='password1']");
    private final SelenideElement checkBox = $(byText("Согласие на обработку персональных данных"));
    public SelenideElement registrationButton = $(byText("Регистрация"));


 public  void register(String email, String firstName, String lastName, int birthday, String clubName, String password) {
        emailField.setValue(email);
        this.firstName.setValue(firstName);
        this.lastName.setValue(lastName);
        this.birthday.setValue(String.valueOf(birthday));
        this.clubName.setValue(clubName);
        this.password.setValue(password);
        password1.setValue(password);
        checkBox.click();
        registrationButton.click();
    }
}





